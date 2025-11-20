package com.taxing.tliaswebmanagement.controller;

import com.github.pagehelper.Page;
import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.pojo.student.other.OperateLogStudent;
import com.taxing.tliaswebmanagement.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RestController
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/admin/log/page")
    public Result page(Integer page,Integer pageSize){
        PageResult<OperateLog> pageResult=logService.page(page,pageSize);
        log.info("分页查询：{},{}",page,pageSize);
        return Result.success(pageResult);
    }
    @GetMapping("/student/log/page")
    public Result pageStudent(Integer id,Integer page,Integer pageSize){
        PageResult<OperateLogStudent> pageResult=logService.pageStudent(page,pageSize,id);
        log.info("分页查询：{},{}",page,pageSize);
        return Result.success(pageResult);
    }
}
