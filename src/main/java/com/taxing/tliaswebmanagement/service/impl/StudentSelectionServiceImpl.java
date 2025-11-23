package com.taxing.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taxing.tliaswebmanagement.anno.StudentLog;
import com.taxing.tliaswebmanagement.exception.BusinessException;
import com.taxing.tliaswebmanagement.mapper.mysql.CourseMapper;
import com.taxing.tliaswebmanagement.mapper.mysql.EmpMapper;
import com.taxing.tliaswebmanagement.mapper.mysql.StudentSelectionMapper;
import com.taxing.tliaswebmanagement.mapper.oracle.OracleCourseMapper;
import com.taxing.tliaswebmanagement.mapper.oracle.OracleEmpMapper;
import com.taxing.tliaswebmanagement.mapper.oracle.OracleStudentSelectionMapper;
import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentSelectionPageDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;
import com.taxing.tliaswebmanagement.pojo.student.other.*;
import com.taxing.tliaswebmanagement.service.StudentSelectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class StudentSelectionServiceImpl implements StudentSelectionService {
    @Autowired
    private StudentSelectionMapper studentSelectionMapper;
    @Autowired
    private OracleStudentSelectionMapper oracleStudentSelectionMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private OracleEmpMapper oracleEmpMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private OracleCourseMapper oracleCourseMapper;
    @Override
    public PageResult<StudentSelectionPageVO> page(StudentSelectionPageDTO studentSelectionPageDTO) {
        //被占用的时段
        List<Integer> occupiedPeriods=new ArrayList<>();
        Integer date=studentSelectionPageDTO.getDate();
        Integer time=studentSelectionPageDTO.getTime();
        String empName=studentSelectionPageDTO.getEmpName();
        List<Integer> empIds=new ArrayList<>();
        if(studentSelectionPageDTO.isConflictsFilter()){
            //过滤冲突
            List<Integer> tempList = studentSelectionMapper.getOccupiedPeriodsWithStudentId(studentSelectionPageDTO.getId());
            if (tempList != null) {
                occupiedPeriods.addAll(tempList);
            }
        }
        if(date!=null){
            //周x
            List<Integer> tempList=getOccupiedPeriodsWithDateOrTime(date,true);
            Set<Integer> set=new HashSet<>(tempList);
            set.addAll(occupiedPeriods);
            occupiedPeriods=new ArrayList<>(set);
        }
        if(time!=null){
            //第x节
            List<Integer> tempList=getOccupiedPeriodsWithDateOrTime(time,false);
            Set<Integer> set=new HashSet<>(tempList);
            set.addAll(occupiedPeriods);
            occupiedPeriods=new ArrayList<>(set);
        }
        empName=empName.trim();
        log.info("empNameTrim:{}",empName);
        if(!empName.isEmpty()){
            log.info("empName:{}",empName);
            empIds.addAll(empMapper.SelectEmpIdsByEmpName(empName));
            if(empIds.isEmpty()){
                return new PageResult<>(0L,null);
            }
        }

        List<Integer> freePeriods=new ArrayList<>();
        for(int i=1;i<=16;i++){
            //找到空闲时段
            if(!occupiedPeriods.contains(i)){
                freePeriods.add(i);
            }
        }
        //查询到符合条件的数据
        StudentSelectionPageQuery studentSelectionPageQuery=
                new StudentSelectionPageQuery(empIds,freePeriods);
        PageHelper.startPage(studentSelectionPageDTO.getPage(),
                studentSelectionPageDTO.getPageSize());
        List<StudentSelectionPageTemp> list=
                studentSelectionMapper.list(studentSelectionPageQuery);

        //获取分页信息
        PageInfo<StudentSelectionPageTemp> pageInfo=new PageInfo<>(list);
        //根据courseId和empId查询courseName和empName
        List<StudentSelectionPageVO> listVO=new ArrayList<>();
        for(StudentSelectionPageTemp temp:list){
            listVO.add(new StudentSelectionPageVO(
                    temp.getId(),
                    courseMapper.selectCourseNameById(temp.getCourseId()),
                    empMapper.selectEmpNameById(temp.getEmpId()),
                    temp.getPeriod(),
                    temp.getId()
            ));
        }

        return new PageResult<StudentSelectionPageVO>(pageInfo.getTotal(),listVO);
    }

    @StudentLog
    @Override
    public void selectCourse(Integer studentId, Integer empCourseId) {
        CourseIdAndPeriod courseIdAndPeriod=studentSelectionMapper.getCourseIdAndPeriodWithId(empCourseId);
        Integer period=courseIdAndPeriod.getPeriod();
        //检查时段是否被占用
        StudentCourse s=studentSelectionMapper.getPeriodCourse(studentId,period);
        if(s!=null){
            throw new BusinessException("该时段已被占用");
        }
        StudentCourse studentCourse=new StudentCourse
                (studentId,courseIdAndPeriod.getCourseId(),courseIdAndPeriod.getPeriod(),empCourseId);
        studentSelectionMapper.insert(studentCourse);
        oracleStudentSelectionMapper.insert(studentCourse);
    }

    @Override
    public PageResult<StudentSelectionPageVO> pageSelectedCourse(Integer id, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<StudentSelectionPageVO> list=studentSelectionMapper.pageSelectedCourse(id);
        Page<StudentSelectionPageVO> p=(Page<StudentSelectionPageVO>) list;
        return new PageResult<StudentSelectionPageVO>(p.getTotal(),p.getResult());
    }

    @StudentLog
    @Override
    public void delete(Integer id) {
        studentSelectionMapper.delete(id);
        oracleStudentSelectionMapper.delete(id);
    }

    private static List<Integer> getOccupiedPeriodsWithDateOrTime(Integer num,boolean type){
        //type=true，为date;type=false，为time
        List<Integer> list=new ArrayList<>();
        if(type){
            for (int i = 1; i <= 16; i++) {
                if (i <= 4*(num-1) || i > 4*num) {
                    list.add(i);
                }
            }
        }else{
            for (int i = 1; i <= 16; i++) {
                if (i % 4 != num) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
