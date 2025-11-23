package com.taxing.tliaswebmanagement.service.impl;

import com.taxing.tliaswebmanagement.mapper.mysql.EmpLogMapper;
import com.taxing.tliaswebmanagement.mapper.oracle.OracleEmpLogMapper;
import com.taxing.tliaswebmanagement.pojo.EmpLog;
import com.taxing.tliaswebmanagement.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;
    @Autowired
    private OracleEmpLogMapper oracleEmpLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
        oracleEmpLogMapper.insert(empLog);
    }
}
