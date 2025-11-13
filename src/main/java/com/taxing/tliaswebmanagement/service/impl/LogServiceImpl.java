package com.taxing.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taxing.tliaswebmanagement.mapper.LogMapper;
import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Page<OperateLog> p=(Page<OperateLog>) logMapper.list(page,pageSize);
        return new PageResult<OperateLog>(p.getTotal(),p.getResult());
    }
}
