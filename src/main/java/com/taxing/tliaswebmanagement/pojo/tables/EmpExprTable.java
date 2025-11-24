package com.taxing.tliaswebmanagement.pojo.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpExprTable {
    private Integer id;
    private Integer emp_id;
    private LocalDate begin;
    private LocalDate end;
    private String company;
    private String job;
}
