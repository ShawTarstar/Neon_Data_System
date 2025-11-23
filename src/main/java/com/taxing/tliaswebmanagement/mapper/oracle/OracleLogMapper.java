package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.student.other.OperateLogStudent;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("OracleLogMapper")
public interface OracleLogMapper {

    @Select(
            "SELECT " +
                    "  o.\"id\", " +
                    "  o.\"operate_emp_id\", " +
                    "  o.\"operate_time\", " +
                    "  o.\"class_name\", " +
                    "  o.\"method_name\", " +
                    "  o.\"method_params\", " +
                    "  o.\"return_value\", " +
                    "  o.\"cost_time\", " +
                    "  e.\"name\" AS \"operateEmpName\" " +
                    "FROM \"operate_log\" o " +
                    "LEFT JOIN \"emp\" e ON o.\"operate_emp_id\" = e.\"id\" " +
                    "ORDER BY o.\"operate_time\" DESC"
    )
    List<OperateLog> list(Integer page, Integer pageSize);


    @Select(
            "SELECT " +
                    "  \"id\", " +
                    "  \"operate_time\", " +
                    "  \"operation\", " +
                    "  \"courseName\", " +
                    "  \"period\" " +
                    "FROM \"student_operate_log\" " +
                    "WHERE \"operate_student_id\" = #{id} " +
                    "ORDER BY \"operate_time\" DESC"
    )
    List<OperateLogStudent> listStudent(Integer page, Integer pageSize, Integer id);
}
