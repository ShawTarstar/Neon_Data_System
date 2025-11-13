package com.taxing.tliaswebmanagement.service;

import com.taxing.tliaswebmanagement.pojo.Clazz;
import com.taxing.tliaswebmanagement.pojo.ClazzQueryParam;
import com.taxing.tliaswebmanagement.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz selectById(Integer id);

    void update(Clazz clazz);


    boolean selectInStu(Integer id);

    void delete(Integer id);

    List<Clazz> selectAllClazzs();
}
