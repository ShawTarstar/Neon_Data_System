package com.taxing.tliaswebmanagement.service;

import com.github.pagehelper.Page;
import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
