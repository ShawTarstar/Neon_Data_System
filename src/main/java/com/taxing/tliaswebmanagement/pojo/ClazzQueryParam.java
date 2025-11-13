package com.taxing.tliaswebmanagement.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private String name;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate end;
    private Integer page;
    private Integer pageSize;

}
