package com.taxing.tliaswebmanagement.service;

import com.taxing.tliaswebmanagement.pojo.CourseVO;

import java.util.List;

public interface CourseService {
    List<CourseVO> getAdminSchd(Integer id);

    List<CourseVO> getStudentSchd(Integer id);
}
