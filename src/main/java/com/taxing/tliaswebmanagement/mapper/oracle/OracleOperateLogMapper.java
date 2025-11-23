package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.student.other.OperateLogStudent;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component("OracleOperateLogMapper")
public interface OracleOperateLogMapper {

    // 插入后台操作日志
    @Insert(
            "INSERT INTO \"operate_log\"(" +
                    "   \"operate_emp_id\", \"operate_time\", \"class_name\", " +
                    "   \"method_name\", \"method_params\", \"return_value\", \"cost_time\"" +
                    ") VALUES (" +
                    "   #{operateEmpId}, #{operateTime}, #{className}, " +
                    "   #{methodName}, #{methodParams}, #{returnValue}, #{costTime}" +
                    ")"
    )
    void insert(OperateLog log);


    // 插入学生操作日志
    @Insert(
            "INSERT INTO \"student_operate_log\"(" +
                    "   \"operate_student_id\", \"operate_time\", \"operation\", " +
                    "   \"courseName\", \"period\"" +
                    ") VALUES (" +
                    "   #{operateStudentId}, #{operateTime}, #{operation}, " +
                    "   #{courseName}, #{period}" +
                    ")"
    )
    void studentInsert(OperateLogStudent log);
}
