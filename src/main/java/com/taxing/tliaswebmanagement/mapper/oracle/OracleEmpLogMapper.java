package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component("OracleEmpLogMapper")
public interface OracleEmpLogMapper {

    @Insert("INSERT INTO \"emp_log\"(\"id\",\"operate_time\", \"info\") " +
            "VALUES(#{id},#{operateTime}, #{info})")
    void insert(EmpLog empLog);
}
