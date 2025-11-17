package com.taxing.tliaswebmanagement.pojo.student.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentSelectionPageQuery {
    List<Integer> empIds;
    List<Integer> periodIds;
}
