package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.tables.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface OracleSyncMapper {
    void clazzInsert(ClazzTable clazzTable);
    void courseInsert(CourseTable courseTable);
    void deptInsert(DeptTable deptTable);
    void empInsert(EmpTable empTable);
    void empCourseInsert(EmpCourseTable empCourseTable);
    void empExprInsert(EmpExprTable empExprTable);
    void empLogInsert(EmpLogTable empLogTable);
    void operateLogInsert(OperateLogTable operateLogTable);
    void studentInsert(StudentTable studentTable);
    void studentCourseInsert(StudentCourseTable studentCourseTable);
    void studentLoginInsert(StudentLoginTable studentLoginTable);
    void studentOperateLogInsert(StudentOperateLogTable studentOperateLogTable);

    void ClazzUpdate(ClazzTable clazzTable);
    void CourseUpdate(CourseTable courseTable);
    void DeptUpdate(DeptTable deptTable);
    void EmpUpdate(EmpTable empTable);
    void EmpCourseUpdate(EmpCourseTable empCourseTable);
    void EmpExprUpdate(EmpExprTable empExprTable);
    void EmpLogUpdate(EmpLogTable empLogTable);
    void OperateLogUpdate(OperateLogTable operateLogTable);
    void StudentUpdate(StudentTable studentTable);
    void StudentCourseUpdate(StudentCourseTable studentCourseTable);
    void StudentLoginUpdate(StudentLoginTable studentLoginTable);
    void StudentOperateLogUpdate(StudentOperateLogTable studentOperateLogTable);

    @Select("SELECT * FROM \"clazz\" WHERE \"id\" = #{id}")
    ClazzTable clazzSelect(Integer id);

    @Select("SELECT * FROM \"course\" WHERE \"id\" = #{id}")
    CourseTable courseSelect(Integer id);

    @Select("SELECT * FROM \"dept\" WHERE \"id\" = #{id}")
    DeptTable deptSelect(Integer id);

    @Select("SELECT * FROM \"emp\" WHERE \"id\" = #{id}")
    EmpTable empSelect(Integer id);

    @Select("SELECT * FROM \"emp_course\" WHERE \"id\" = #{id}")
    EmpCourseTable empCourseSelect(Integer id);

    @Select("SELECT * FROM \"emp_expr\" WHERE \"id\" = #{id}")
    EmpExprTable empExprSelect(Integer id);

    @Select("SELECT * FROM \"emp_log\" WHERE \"id\" = #{id}")
    EmpLogTable empLogSelect(Integer id);

    @Select("SELECT * FROM \"operate_log\" WHERE \"id\" = #{id}")
    OperateLogTable operateLogSelect(Integer id);

    @Select("SELECT * FROM \"student\" WHERE \"id\" = #{id}")
    StudentTable studentSelect(Integer id);

    @Select("SELECT * FROM \"student_course\" WHERE \"id\" = #{id}")
    StudentCourseTable studentCourseSelect(Integer id);

    @Select("SELECT * FROM \"student_login\" WHERE \"id\" = #{id}")
    StudentLoginTable studentLoginSelect(Integer id);

    @Select("SELECT * FROM \"student_operate_log\" WHERE \"id\" = #{id}")
    StudentOperateLogTable studentOperateLogSelect(Integer id);

}
