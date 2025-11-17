package com.taxing.tliaswebmanagement.service.impl;

import com.taxing.tliaswebmanagement.mapper.CourseMapper;
import com.taxing.tliaswebmanagement.pojo.CourseVO;
import com.taxing.tliaswebmanagement.pojo.EmpCourseId;
import com.taxing.tliaswebmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<CourseVO> getAdminSchd(Integer id) {
        List<EmpCourseId> list= courseMapper.getAdminSchd(id);
        List<CourseVO> courseVOList=new ArrayList<>();
        list.forEach(empCourseId -> {
            String name=courseMapper.selectCourseNameById(empCourseId.getCourseId());
            courseVOList.add(new CourseVO(name,empCourseId.getPeriod()));
        });
        return courseVOList;
    }

    @Override
    public List<CourseVO> getStudentSchd(Integer id) {
        List<EmpCourseId> list= courseMapper.getStudentSchd(id);
        List<CourseVO> courseVOList=new ArrayList<>();
        list.forEach(empCourseId -> {
            String name=courseMapper.selectCourseNameById(empCourseId.getCourseId());
            courseVOList.add(new CourseVO(name,empCourseId.getPeriod()));
        });
        return courseVOList;
    }
}
