package com.taxing.tliaswebmanagement.mapper;

import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentSelectionPageDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;
import com.taxing.tliaswebmanagement.pojo.student.other.StudentSelectionPageMapper;
import com.taxing.tliaswebmanagement.pojo.student.other.StudentSelectionPageQuery;
import com.taxing.tliaswebmanagement.pojo.student.other.StudentSelectionPageTemp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentSelectionMapper {
    List<StudentSelectionPageTemp> list(StudentSelectionPageQuery q);

    @Select("select period from student_course where student_id=#{id}")
    List<Integer> getOccupiedPeriodsWithStudentId(Integer id);
}
