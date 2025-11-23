package com.taxing.tliaswebmanagement.mapper.mysql;

import com.taxing.tliaswebmanagement.pojo.EmpCourseId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CourseMapper {
    @Select("select courseId,period from emp_course where empId=#{id}")
    List<EmpCourseId> getAdminSchd(Integer id);

    @Select("select course_name from course where id=#{id}")
    String selectCourseNameById(Integer id);

    @Select("select course_id,period from student_course where student_id=#{id}")
    List<EmpCourseId> getStudentSchd(Integer id);
}
