package com.taxing.tliaswebmanagement.service;

import com.github.pagehelper.Page;
import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.pojo.student.other.OperateLogStudent;

public interface LogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);

    PageResult<OperateLogStudent> pageStudent(Integer page, Integer pageSize,Integer id);
}
