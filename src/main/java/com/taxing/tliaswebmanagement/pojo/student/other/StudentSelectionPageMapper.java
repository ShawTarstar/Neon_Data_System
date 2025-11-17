package com.taxing.tliaswebmanagement.pojo.student.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSelectionPageMapper {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Integer period;
}
