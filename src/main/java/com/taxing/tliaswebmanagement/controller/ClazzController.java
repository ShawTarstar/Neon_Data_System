package com.taxing.tliaswebmanagement.controller;

import com.github.pagehelper.Page;
import com.taxing.tliaswebmanagement.exception.BusinessException;
import com.taxing.tliaswebmanagement.pojo.Clazz;
import com.taxing.tliaswebmanagement.pojo.ClazzQueryParam;
import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/admin/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询：{}",clazzQueryParam);
        PageResult<Clazz> pageResult= clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result insert(@RequestBody Clazz clazz){
        log.info("添加班级：{}",clazz);
        clazzService.insert(clazz);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据ID查询班级：{}",id);
        Clazz clazz=clazzService.selectById(id);
        return Result.success(clazz);
    }
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        clazzService.update(clazz);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        if(clazzService.selectInStu(id)){
            throw new BusinessException(400,"该班级下有学生");
        }
        clazzService.delete(id);
        return Result.success();
    }
    @GetMapping("/list")
    public Result selectAllClazzs(){
        List<Clazz> clazzs= clazzService.selectAllClazzs();
        return Result.success(clazzs);
    }

}
