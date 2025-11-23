package com.taxing.tliaswebmanagement.mapper.mysql;

import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;
import com.taxing.tliaswebmanagement.pojo.student.other.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface StudentSelectionMapper {
    List<StudentSelectionPageTemp> list(StudentSelectionPageQuery q);

    @Select("select period from student_course where student_id=#{id}")
    List<Integer> getOccupiedPeriodsWithStudentId(Integer id);

    @Select("select courseId,period from emp_course where id=#{id}")
    CourseIdAndPeriod getCourseIdAndPeriodWithId(Integer id);

    @Select("select student_id,course_id,period,empCourseId " +
            "from student_course where student_id=#{studentId} " +
            "and period=#{period}")
    StudentCourse getPeriodCourse(Integer studentId, Integer period);

    @Insert("insert into student_course (student_id, course_id, period,empCourseId)" +
            "values (#{studentId},#{courseId},#{period},#{empCourseId})")
    void insert(StudentCourse studentCourse);

    List<StudentSelectionPageVO> pageSelectedCourse(Integer id);

    @Delete("delete from student_course where id=#{id}")
    void delete(Integer id);

    @Select("select student_id,course_id,period,empCourseId from student_course where " +
            "student_id=#{studentId} and empCourseId=#{empCourseId}")
    StudentCourse getStudentCourseWithStudentIdAndEmpCourseId(Integer studentId, Integer empCourseId);

    @Select("select student_id,course_id,period,empCourseId from student_course where id=#{id}")
    StudentCourse getStudentCourseById(Integer id);
}
