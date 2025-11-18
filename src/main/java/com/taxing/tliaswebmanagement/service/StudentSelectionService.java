package com.taxing.tliaswebmanagement.service;

import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentSelectionPageDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;

public interface StudentSelectionService {
    PageResult<StudentSelectionPageVO> page(StudentSelectionPageDTO studentSelectionPageDTO);

    void selectCourse(Integer studentId, Integer empCourseId);
}
