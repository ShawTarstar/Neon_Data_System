package com.taxing.tliaswebmanagement;

import com.taxing.tliaswebmanagement.mapper.oracle.OracleCourseMapper;
import com.taxing.tliaswebmanagement.pojo.EmpCourseId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CourseMapperTest {

    @Autowired
    @Qualifier("oracleSqlSessionTemplate")
    private SqlSessionTemplate oracleTemplate;

    private OracleCourseMapper courseMapper;

    @BeforeEach
    public void setUp() {
        // 手动获取 Mapper，不让 Spring 冲突
        courseMapper = oracleTemplate.getMapper(OracleCourseMapper.class);
    }

    @Test
    public void testGetAdminSchd() {
        List<EmpCourseId> list = courseMapper.getAdminSchd(1);
        System.out.println(list);
        assertNotNull(list);
    }
}

