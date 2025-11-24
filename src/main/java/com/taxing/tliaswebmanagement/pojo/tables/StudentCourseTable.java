package com.taxing.tliaswebmanagement.pojo.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseTable {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Integer period;
    private Integer empCourseId;
}
