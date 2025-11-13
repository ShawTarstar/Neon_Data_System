package com.taxing.tliaswebmanagement.service;

import com.taxing.tliaswebmanagement.pojo.JobOption;
import com.taxing.tliaswebmanagement.pojo.StudentOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();


    StudentOption getStudentCountData();

    List<Map<String, Object>> getStudentDegreeData();
}
