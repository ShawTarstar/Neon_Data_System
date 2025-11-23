package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.Student;
import com.taxing.tliaswebmanagement.pojo.StudentQueryParam;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentLoginDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentLoginInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface OracleStudentMapper {

    List<Student> page(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student selectById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void violation(Integer id, Integer score, LocalDateTime updateTime);

    @MapKey("name")
    List<Map<String, Object>> getStudentCountData();

    @MapKey("name")
    List<Map<String, Object>> getStudentDegreeData();

    // Oracle 注解 SQL —— 使用双引号小写格式
    @Select("SELECT \"id\", \"no\", \"name\" " +
            "FROM \"student_login\" " +
            "WHERE \"no\" = #{no} AND \"password\" = #{password}")
    StudentLoginInfo login(StudentLoginDTO studentLoginDTO);

    void updateStudentLoginInfo(Student student);
}
