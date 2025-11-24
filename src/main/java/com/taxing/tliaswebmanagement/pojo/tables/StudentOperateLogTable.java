package com.taxing.tliaswebmanagement.pojo.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOperateLogTable {
    private Integer id;
    private Integer operateStudentId;
    private LocalDateTime operateTime;
    private String operation;
    private String courseName;
    private Integer period;
}
