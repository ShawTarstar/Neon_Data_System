package com.taxing.tliaswebmanagement.service.impl;

import com.taxing.tliaswebmanagement.mapper.DeptMapper;
import com.taxing.tliaswebmanagement.pojo.Dept;
import com.taxing.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override

    public void deleteById(Integer id) {

        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public boolean selectInEmp(Integer id) {
        if(deptMapper.selectInEmp(id)>0){
            return true;
        }
        return false;
    }

}
