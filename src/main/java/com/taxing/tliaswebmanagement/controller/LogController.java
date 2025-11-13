package com.taxing.tliaswebmanagement.controller;

import com.github.pagehelper.Page;
import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/page")
    public Result page(Integer page,Integer pageSize){
        PageResult<OperateLog> pageResult=logService.page(page,pageSize);
        log.info("分页查询：{},{}",page,pageSize);
        return Result.success(pageResult);
    }
}
