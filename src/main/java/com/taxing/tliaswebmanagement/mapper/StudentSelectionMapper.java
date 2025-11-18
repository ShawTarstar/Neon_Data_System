package com.taxing.tliaswebmanagement.mapper;

import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentSelectionPageDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;
import com.taxing.tliaswebmanagement.pojo.student.other.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentSelectionMapper {
    List<StudentSelectionPageTemp> list(StudentSelectionPageQuery q);

    @Select("select period from student_course where student_id=#{id}")
    List<Integer> getOccupiedPeriodsWithStudentId(Integer id);

    @Select("select courseId,period from emp_course where id=#{id}")
    CourseIdAndPeriod getCourseIdAndPeriodWithId(Integer id);

    @Insert("insert into student_course (student_id, course_id, period)" +
            "values (#{studentId},#{courseId},#{period})")
    void insert(StudentCourse studentCourse);
}
