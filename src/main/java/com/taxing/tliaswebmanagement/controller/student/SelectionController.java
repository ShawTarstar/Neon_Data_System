package com.taxing.tliaswebmanagement.controller.student;

import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentSelectionPageDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;
import com.taxing.tliaswebmanagement.service.StudentSelectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student/selection")
@RestController
@Slf4j
public class SelectionController {
    @Autowired
    StudentSelectionService studentSelectionService;
    @GetMapping
    public Result page(StudentSelectionPageDTO studentSelectionPageDTO){
        log.info("分页查询：{}",studentSelectionPageDTO);
        PageResult<StudentSelectionPageVO> pageResult= studentSelectionService.page(studentSelectionPageDTO);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result selectCourse(Integer studentId,Integer empCourseId){
        log.info("选课：{},{}",studentId,empCourseId);
        studentSelectionService.selectCourse(studentId,empCourseId);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result pageSelectedCourse(@PathVariable Integer id,Integer page,Integer pageSize){
        log.info("查询已选课程：{}",id);
        PageResult<StudentSelectionPageVO> list= studentSelectionService.pageSelectedCourse(id,page,pageSize);
        return Result.success(list);
    }
    @DeleteMapping
    public Result delete(Integer id){
        log.info("退选课程：{}",id);
        studentSelectionService.delete(id);
        return Result.success();
    }
}
