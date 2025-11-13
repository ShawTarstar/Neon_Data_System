package com.taxing.tliaswebmanagement.service.impl;

import com.taxing.tliaswebmanagement.mapper.EmpMapper;
import com.taxing.tliaswebmanagement.mapper.StudentMapper;
import com.taxing.tliaswebmanagement.pojo.JobOption;
import com.taxing.tliaswebmanagement.pojo.StudentOption;
import com.taxing.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list=empMapper.countEmpJobData();
        List<Object> jobList=list.stream().map(dataMap->dataMap.get("pos")).toList();
        List<Object> dataList=list.stream().map(dataMap->dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public StudentOption getStudentCountData() {
        List<Map<String,Object>> list= studentMapper.getStudentCountData();
        List<Object> nameList=list.stream().map(dataMap->dataMap.get("name")).toList();
        List<Object> numList=list.stream().map(dataMap->dataMap.get("num")).toList();
        return new StudentOption(nameList,numList);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();
    }


}
