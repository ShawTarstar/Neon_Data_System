package com.taxing.tliaswebmanagement.controller;

import com.taxing.tliaswebmanagement.pojo.CourseVO;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/admin/schd")
    public Result getAdminSchd(Integer id){
        List<CourseVO> list=courseService.getAdminSchd(id);
        return Result.success(list);
    }
    @GetMapping("/student/schd")
    public Result getStudentSchd(Integer id){
        List<CourseVO> list=courseService.getStudentSchd(id);
        return Result.success(list);
    }
}
