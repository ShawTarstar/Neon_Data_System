package com.taxing.tliaswebmanagement.pojo.student.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSelectionPageVO {
    private Integer id;
    private String courseName;
    private String empName;
    private Integer period;

    private Integer empCourseId;
}
