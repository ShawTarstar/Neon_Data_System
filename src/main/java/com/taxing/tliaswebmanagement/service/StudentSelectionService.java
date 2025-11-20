package com.taxing.tliaswebmanagement.service;

import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentSelectionPageDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;

import java.util.List;

public interface StudentSelectionService {
    PageResult<StudentSelectionPageVO> page(StudentSelectionPageDTO studentSelectionPageDTO);

    void selectCourse(Integer studentId, Integer empCourseId);

    PageResult<StudentSelectionPageVO> pageSelectedCourse(Integer id, Integer page, Integer pageSize);

    void delete(Integer id);
}
