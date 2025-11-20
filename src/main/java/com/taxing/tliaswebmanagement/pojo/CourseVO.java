package com.taxing.tliaswebmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String courseName;
    private Integer period;
}
