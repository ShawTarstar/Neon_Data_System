package com.taxing.tliaswebmanagement.mapper.mysql;

import com.taxing.tliaswebmanagement.pojo.tables.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SyncMapper {
    @Select("select * from clazz")
    List<ClazzTable> clazzSelect();

    @Select("select * from course")
    List<CourseTable> courseSelect();

    @Select("select * from dept")
    List<DeptTable> deptSelect();

    @Select("select * from emp")
    List<EmpTable> empSelect();

    @Select("select * from emp_course")
    List<EmpCourseTable> empCourseSelect();

    @Select("select * from emp_expr")
    List<EmpExprTable> empExprSelect();

    @Select("select * from emp_log")
    List<EmpLogTable> empLogSelect();

    @Select("select * from operate_log")
    List<OperateLogTable> operateLogSelect();

    @Select("select * from student")
    List<StudentTable> studentSelect();

    @Select("select * from student_course")
    List<StudentCourseTable> studentCourseSelect();

    @Select("select * from student_login")
    List<StudentLoginTable> studentLoginSelect();

    @Select("select * from student_operate_log")
    List<StudentOperateLogTable> studentOperateLogSelect();

}
