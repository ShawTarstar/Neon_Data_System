package com.taxing.tliaswebmanagement.mapper.mysql;

import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.student.other.OperateLogStudent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


public interface OperateLogMapper {

    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(OperateLog log);

    @Insert("insert into student_operate_log (operate_student_id, operate_time, operation,courseName,period)" +
            "values (#{operateStudentId},#{operateTime},#{operation},#{courseName},#{period}) ")
    public void studentInsert(OperateLogStudent log);
}
