package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.student.VO.StudentSelectionPageVO;
import com.taxing.tliaswebmanagement.pojo.student.other.CourseIdAndPeriod;
import com.taxing.tliaswebmanagement.pojo.student.other.StudentCourse;
import com.taxing.tliaswebmanagement.pojo.student.other.StudentSelectionPageQuery;
import com.taxing.tliaswebmanagement.pojo.student.other.StudentSelectionPageTemp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OracleStudentSelectionMapper {

    List<StudentSelectionPageTemp> list(StudentSelectionPageQuery q);

    // 查询学生已占用的时间段
    @Select("SELECT \"period\" " +
            "FROM \"student_course\" " +
            "WHERE \"student_id\" = #{id}")
    List<Integer> getOccupiedPeriodsWithStudentId(Integer id);

    // 查询课程与时间段，根据 emp_course.id
    @Select("SELECT \"courseId\", \"period\" " +
            "FROM \"emp_course\" " +
            "WHERE \"id\" = #{id}")
    CourseIdAndPeriod getCourseIdAndPeriodWithId(Integer id);

    // 根据 student_id + period 查是否冲突
    @Select("SELECT \"student_id\", \"course_id\", \"period\", \"empCourseId\" " +
            "FROM \"student_course\" " +
            "WHERE \"student_id\" = #{studentId} AND \"period\" = #{period}")
    StudentCourse getPeriodCourse(Integer studentId, Integer period);

    // 插入选课信息
    @Insert("INSERT INTO \"student_course\" (\"student_id\", \"course_id\", \"period\", \"empCourseId\") " +
            "VALUES (#{studentId}, #{courseId}, #{period}, #{empCourseId})")
    void insert(StudentCourse studentCourse);

    List<StudentSelectionPageVO> pageSelectedCourse(Integer id);

    // 删除选课
    @Delete("DELETE FROM \"student_course\" WHERE \"id\" = #{id}")
    void delete(Integer id);

    // 判断同一个学生是否已选该 empCourseId
    @Select("SELECT \"student_id\", \"course_id\", \"period\", \"empCourseId\" " +
            "FROM \"student_course\" " +
            "WHERE \"student_id\" = #{studentId} AND \"empCourseId\" = #{empCourseId}")
    StudentCourse getStudentCourseWithStudentIdAndEmpCourseId(Integer studentId, Integer empCourseId);

    // 根据 ID 查询选课记录
    @Select("SELECT \"student_id\", \"course_id\", \"period\", \"empCourseId\" " +
            "FROM \"student_course\" " +
            "WHERE \"id\" = #{id}")
    StudentCourse getStudentCourseById(Integer id);
}
