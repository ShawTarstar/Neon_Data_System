package com.taxing.tliaswebmanagement.controller;

import com.taxing.tliaswebmanagement.pojo.JobOption;
import com.taxing.tliaswebmanagement.pojo.Result;
import com.taxing.tliaswebmanagement.pojo.StudentOption;
import com.taxing.tliaswebmanagement.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位人数");
        JobOption jobOption= reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别人数");
        List<Map<String,Object>> genderList= reportService.getEmpGenderData();
        return Result.success(genderList);

    }
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计每一个班级的人数");
        StudentOption studentOption =reportService.getStudentCountData();
        return Result.success(studentOption);
    }
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员的学历信息");
        List<Map<String,Object>> studentDegreeData=reportService.getStudentDegreeData();
        return Result.success(studentDegreeData);
    }
}
