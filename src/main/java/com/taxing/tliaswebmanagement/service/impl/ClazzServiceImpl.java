package com.taxing.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taxing.tliaswebmanagement.mapper.mysql.ClazzMapper;
import com.taxing.tliaswebmanagement.mapper.oracle.OracleClazzMapper;
import com.taxing.tliaswebmanagement.pojo.Clazz;
import com.taxing.tliaswebmanagement.pojo.ClazzQueryParam;
import com.taxing.tliaswebmanagement.pojo.PageResult;
import com.taxing.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private OracleClazzMapper oracleClazzMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        List<Clazz> clazzList= clazzMapper.list(clazzQueryParam);
        if(!CollectionUtils.isEmpty(clazzList)){
            clazzList.forEach(clazz -> {
                LocalDate endDate=clazz.getEndDate();
                LocalDate beginDate=clazz.getBeginDate();
                LocalDate currentDate=LocalDate.now();
                if(currentDate.isAfter(endDate)){
                    clazz.setStatus("已结课");
                }
                else if(currentDate.isBefore(beginDate)){
                    clazz.setStatus("未开班");
                }
                else{
                    clazz.setStatus("在读中");
                }
            });
        }
        Page<Clazz> p=(Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }

    @Override
    public void insert(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
        oracleClazzMapper.insert(clazz);
    }

    @Override
    public Clazz selectById(Integer id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
        oracleClazzMapper.update(clazz);
    }

    @Override
    public boolean selectInStu(Integer id) {
        if(clazzMapper.selectInStu(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
        oracleClazzMapper.delete(id);
    }

    @Override
    public List<Clazz> selectAllClazzs() {
        return clazzMapper.selectAllClazzs();
    }

}
