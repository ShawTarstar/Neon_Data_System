package com.taxing.tliaswebmanagement.controller.student;

import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentSelectionPageDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;
import com.taxing.tliaswebmanagement.service.StudentSelectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
