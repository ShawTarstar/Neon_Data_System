package com.taxing.tliaswebmanagement.mapper.mysql;

import com.taxing.tliaswebmanagement.pojo.Clazz;
import com.taxing.tliaswebmanagement.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface ClazzMapper {


    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz selectById(Integer id);

    void update(Clazz clazz);

    Integer selectInStu(Integer id);

    void delete(Integer id);

    List<Clazz> selectAllClazzs();
}
