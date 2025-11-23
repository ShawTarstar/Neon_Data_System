package com.taxing.tliaswebmanagement.mapper.oracle;

import com.taxing.tliaswebmanagement.pojo.Clazz;
import com.taxing.tliaswebmanagement.pojo.ClazzQueryParam;

import java.util.List;



public interface OracleClazzMapper {


    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz selectById(Integer id);

    void update(Clazz clazz);

    Integer selectInStu(Integer id);

    void delete(Integer id);

    List<Clazz> selectAllClazzs();
}
