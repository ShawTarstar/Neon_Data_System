package com.taxing.tliaswebmanagement.mapper;

import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.student.other.OperateLogStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("select o.id,o.operate_emp_id,operate_time,class_name,method_name,method_params,return_value,cost_time,e.name operateEmpName from operate_log o left join emp e on o.operate_emp_id=e.id")
    List<OperateLog> list(Integer page, Integer pageSize);

    @Select("select id,operate_time,operation,courseName,period " +
            "from student_operate_log where operate_student_id=#{id}")
    List<OperateLogStudent> listStudent(Integer page, Integer pageSize,Integer id);
}
