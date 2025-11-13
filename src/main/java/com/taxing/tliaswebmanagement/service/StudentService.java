package com.taxing.tliaswebmanagement.service;

import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.Student;
import com.taxing.tliaswebmanagement.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student selectById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void violation(Integer id, Integer score);
}
