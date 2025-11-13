package com.taxing.tliaswebmanagement.controller;

import com.taxing.tliaswebmanagement.anno.Log;
import com.taxing.tliaswebmanagement.exception.BusinessException;
import com.taxing.tliaswebmanagement.pojo.Dept;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    //private static final Logger log= LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        //System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList= deptService.findAll();
        return Result.success(deptList);
    }
    @Log
    @DeleteMapping
    public Result delete(Integer id){
        log.info("根据ID删除部门：{}",id);
        //System.out.println("根据ID删除部门："+id);
        if(deptService.selectInEmp(id)){
            throw new BusinessException(400,"该部门下有员工");
        }
        deptService.deleteById(id);
        return Result.success();

    }
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        //System.out.println("添加部门："+dept);
        log.info("添加部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        //System.out.println("根据ID查询部门数据："+id);
        log.info("根据ID查询部门数据：{}",id);
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //System.out.println("修改部门"+dept);
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
