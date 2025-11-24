package com.taxing.tliaswebmanagement.pojo.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpCourseTable {
    private Integer id;
    private Integer empId;
    private Integer courseId;
    private Integer period;
}
