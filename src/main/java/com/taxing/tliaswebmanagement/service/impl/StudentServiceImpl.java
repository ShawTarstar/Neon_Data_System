package com.taxing.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taxing.tliaswebmanagement.mapper.StudentMapper;
import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.Student;
import com.taxing.tliaswebmanagement.pojo.StudentQueryParam;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentLoginDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentLoginInfo;
import com.taxing.tliaswebmanagement.service.StudentService;
import com.taxing.tliaswebmanagement.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> studentList=studentMapper.page(studentQueryParam);
        Page<Student> p=(Page<Student>) studentList;
        return new PageResult<Student>(p.getTotal(),p.getResult());
    }

    @Override
    public void insert(Student student) {
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void violation(Integer id, Integer score) {
        LocalDateTime updateTime=LocalDateTime.now();
        studentMapper.violation(id,score,updateTime);
    }

    /**
     * 学生登录
     * @param studentLoginDTO
     * @return
     */
    public StudentLoginInfo login(StudentLoginDTO studentLoginDTO) {
        StudentLoginInfo studentLoginInfo = studentMapper.login(studentLoginDTO);
        if(studentLoginInfo!=null){
            log.info("登录成功，学生信息：{}",studentLoginInfo);
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",studentLoginInfo.getId());
            claims.put("username",studentLoginInfo.getNo());
            String jwt= JwtUtils.generateToken(claims);
            studentLoginInfo.setToken(jwt);
            studentLoginInfo.setType(2);
            return studentLoginInfo;
        }
        return null;
    }
}
