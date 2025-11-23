package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("OracleDeptMapper")
public interface OracleDeptMapper {

    // dept 表
    @Select("SELECT \"id\", \"name\", \"create_time\", \"update_time\" " +
            "FROM \"dept\" ORDER BY \"update_time\" DESC")
    List<Dept> findAll();

    @Delete("DELETE FROM \"dept\" WHERE \"id\" = #{id}")
    void deleteById(Integer id);

    @Insert("INSERT INTO \"dept\"(\"name\", \"create_time\", \"update_time\") " +
            "VALUES(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    @Select("SELECT \"id\", \"name\", \"create_time\", \"update_time\" " +
            "FROM \"dept\" WHERE \"id\" = #{id}")
    Dept getById(Integer id);

    @Update("UPDATE \"dept\" SET \"name\" = #{name}, \"update_time\" = #{updateTime} " +
            "WHERE \"id\" = #{id}")
    void update(Dept dept);

    // emp 表中 dept_id 外键计数
    @Select("SELECT COUNT(*) FROM \"emp\" WHERE \"dept_id\" = #{id}")
    int selectInEmp(Integer id);
}
