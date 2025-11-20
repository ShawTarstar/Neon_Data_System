package com.taxing.tliaswebmanagement.pojo.student.other;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperateLogStudent {
    private Integer id;
    private Integer operateStudentId;
    private LocalDateTime operateTime;
    private String operation;
    private String courseName;
    private Integer period;
}
