package com.taxing.tliaswebmanagement.pojo.student.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {
    private Integer id;
    private Integer StudentId;
    private Integer courseId;
    private Integer period;
    private Integer empCourseId;
}
