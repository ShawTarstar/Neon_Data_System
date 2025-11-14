package com.taxing.tliaswebmanagement.controller;

import com.taxing.tliaswebmanagement.pojo.Emp;
import com.taxing.tliaswebmanagement.pojo.LoginInfo;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentLoginDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentLoginInfo;
import com.taxing.tliaswebmanagement.service.EmpService;
import com.taxing.tliaswebmanagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @Autowired
    private StudentService studentService;
    @PostMapping("/admin/login")
    public Result login(@RequestBody Emp emp){
        log.info("登录：{}",emp);
        LoginInfo info= empService.login(emp);
        if(info!=null){
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
    @PostMapping("/student/login")
    public Result studentLogin(@RequestBody StudentLoginDTO studentLoginDTO){
        log.info("学生登录：{}",studentLoginDTO);
        StudentLoginInfo info=studentService.login(studentLoginDTO);
        if(info!=null){
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
}
