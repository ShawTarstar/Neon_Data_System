package com.taxing.tliaswebmanagement.mapper;

import com.taxing.tliaswebmanagement.pojo.Student;
import com.taxing.tliaswebmanagement.pojo.StudentQueryParam;
import com.taxing.tliaswebmanagement.pojo.student.DTO.StudentLoginDTO;
import com.taxing.tliaswebmanagement.pojo.student.VO.StudentLoginInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    
    List<Student> page(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student selectById(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void violation(Integer id, Integer score, LocalDateTime updateTime);

    @MapKey("name") //标识哪个是key
    List<Map<String, Object>> getStudentCountData();

    @MapKey("name")
    List<Map<String, Object>> getStudentDegreeData();

    @Select("select id,no,name from student_login where no=#{no} and password=#{password}")
    StudentLoginInfo login(StudentLoginDTO studentLoginDTO);
}
