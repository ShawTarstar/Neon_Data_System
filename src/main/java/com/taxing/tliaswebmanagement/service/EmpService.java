package com.taxing.tliaswebmanagement.service;

import com.taxing.tliaswebmanagement.pojo.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<EmpDTO> select();

    LoginInfo login(Emp emp);
}
