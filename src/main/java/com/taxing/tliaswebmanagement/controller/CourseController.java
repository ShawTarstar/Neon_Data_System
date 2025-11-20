package com.taxing.tliaswebmanagement.controller;

import com.taxing.tliaswebmanagement.pojo.CourseVO;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
@Slf4j
public class CourseController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CourseService courseService;
    @GetMapping("/admin/schd")
    public Result getAdminSchd(Integer id){
        String key="schd_"+id;
        //查询redis中是否存在课程表数据
        List<CourseVO> list= (List<CourseVO>)redisTemplate.opsForValue().get(key);
        if (list != null && list.size() > 0) {
            //如果存在，直接返回，无须查询数据库
            return Result.success(list);
        }
        //如果不存在，查询数据库，将查询到的数据放入redis中
        list=courseService.getAdminSchd(id);
        redisTemplate.opsForValue().set(key,list);
        return Result.success(list);
    }
    @GetMapping("/student/schd")
    public Result getStudentSchd(Integer id){
        String key="student_schd_"+id;
        //查询redis中是否存在课程表数据
        List<CourseVO> list= (List<CourseVO>)redisTemplate.opsForValue().get(key);
        if (list != null && list.size() > 0) {
            //如果存在，直接返回，无须查询数据库
            return Result.success(list);
        }
        //如果不存在，查询数据库，将查询到的数据放入redis中
        list=courseService.getStudentSchd(id);
        redisTemplate.opsForValue().set(key,list);
        return Result.success(list);
    }
}
