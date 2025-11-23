package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.EmpCourseId;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("OracleCourseMapper")
public interface OracleCourseMapper {

    // 员工课程表 emp_course，列名使用双引号小写
    @Select("SELECT \"courseId\", \"period\" FROM \"emp_course\" WHERE \"empId\" = #{id}")
    List<EmpCourseId> getAdminSchd(Integer id);

    // 课程表 course
    @Select("SELECT \"course_name\" FROM \"course\" WHERE \"id\" = #{id}")
    String selectCourseNameById(Integer id);

    // 学生课程表 student_course
    @Select("SELECT \"course_id\" AS \"courseId\", \"period\" FROM \"student_course\" WHERE \"student_id\" = #{id}")
    List<EmpCourseId> getStudentSchd(Integer id);
}
