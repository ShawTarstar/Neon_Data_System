package com.taxing.tliaswebmanagement.pojo.student.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSelectionPageDTO {
    private Integer id;
    private Integer date;
    private Integer time;
    private String empName;
    private boolean conflictsFilter;
    private Integer page;
    private Integer pageSize;
}
