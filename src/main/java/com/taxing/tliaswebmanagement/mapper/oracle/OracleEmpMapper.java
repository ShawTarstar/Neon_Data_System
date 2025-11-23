package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.Emp;
import com.taxing.tliaswebmanagement.pojo.EmpDTO;
import com.taxing.tliaswebmanagement.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface OracleEmpMapper {

    List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert(
            "INSERT INTO \"emp\"(" +
                    "   \"username\", \"name\", \"gender\", \"phone\", \"job\", \"salary\", " +
                    "   \"image\", \"entry_date\", \"dept_id\", \"create_time\", \"update_time\"" +
                    ") VALUES (" +
                    "   #{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, " +
                    "   #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime}" +
                    ")"
    )
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String,Object>> countEmpGenderData();

    List<EmpDTO> select();

    @Select(
            "SELECT " +
                    "   \"id\", \"username\", \"name\", \"job\" " +
                    "FROM \"emp\" " +
                    "WHERE \"username\" = #{username} AND \"password\" = #{password}"
    )
    Emp selectByUsernameAndPassword(Emp emp);

    @Select(
            "SELECT \"id\" " +
                    "FROM \"emp\" " +
                    "WHERE \"name\" LIKE '%' || #{name} || '%'"
    )
    List<Integer> SelectEmpIdsByEmpName(String name);

    @Select(
            "SELECT \"name\" " +
                    "FROM \"emp\" " +
                    "WHERE \"id\" = #{id}"
    )
    String selectEmpNameById(Integer id);
}
