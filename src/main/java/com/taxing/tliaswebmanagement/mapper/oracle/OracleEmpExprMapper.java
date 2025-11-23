package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.EmpExpr;

import java.util.List;


public interface OracleEmpExprMapper {
    
    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);
}
