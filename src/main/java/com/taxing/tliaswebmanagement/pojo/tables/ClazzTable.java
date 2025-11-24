package com.taxing.tliaswebmanagement.pojo.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzTable {
    private Integer id;
    private String name;
    private String room;
    private LocalDate begin_date;
    private LocalDate end_date;
    private Integer master_id;
    private Integer subject;
    private LocalDateTime create_time;
    private LocalDateTime update_time;

}
