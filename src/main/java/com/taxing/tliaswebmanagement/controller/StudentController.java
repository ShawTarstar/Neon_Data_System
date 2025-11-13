package com.taxing.tliaswebmanagement.controller;

import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.pojo.Student;
import com.taxing.tliaswebmanagement.pojo.StudentQueryParam;
import com.taxing.tliaswebmanagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    private Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询：{}",studentQueryParam);
        PageResult<Student> pageResult=studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping
    private Result insert(@RequestBody Student student){
        log.info("添加学员：{}",student);
        studentService.insert(student);
        return Result.success();
    }
    @GetMapping("/{id}")
    private Result selectById(@PathVariable Integer id){
        log.info("根据ID查询学员：{}",id);
        Student student= studentService.selectById(id);
        return Result.success(student);
    }
    @PutMapping
    private Result update(@RequestBody Student student){
        log.info("修改学员信息：{}",student);
        studentService.update(student);
        return Result.success();
    }
    @DeleteMapping("/{ids}")
    private Result delete(@PathVariable String ids){
        log.info("删除学员信息：{}",ids);
        List<Integer> idList= Arrays.stream(ids.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        studentService.delete(idList);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    private Result violation(@PathVariable Integer id,@PathVariable Integer score){
        studentService.violation(id,score);
        return Result.success();
    }

}
