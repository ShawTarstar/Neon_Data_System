package com.taxing.tliaswebmanagement.mapper.mysql;

import com.taxing.tliaswebmanagement.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface EmpExprMapper {
    
    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);
}
