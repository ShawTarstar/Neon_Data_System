package com.taxing.tliaswebmanagement.pojo.student.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentLoginInfo {
    private Integer id;
    private String no;
    private String name;
    private String token;
    private Integer type;
}
