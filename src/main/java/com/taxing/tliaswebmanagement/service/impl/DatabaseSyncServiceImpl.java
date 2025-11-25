package com.taxing.tliaswebmanagement.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.taxing.tliaswebmanagement.mapper.mysql.SyncMapper;
import com.taxing.tliaswebmanagement.mapper.oracle.OracleSyncMapper;
import com.taxing.tliaswebmanagement.pojo.tables.*;
import com.taxing.tliaswebmanagement.service.DatabaseSyncService;
import com.taxing.tliaswebmanagement.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DatabaseSyncServiceImpl implements DatabaseSyncService {
    @Autowired
    private SyncMapper syncMapper;
    @Autowired
    private OracleSyncMapper oracleSyncMapper;
    @Autowired
    private MailService mailService;
    @Override
    @Transactional
    public void syncDatabase() {
        List<ClazzTable> clazzTableList = syncMapper.clazzSelect();
        for(ClazzTable clazzTable:clazzTableList){
            ClazzTable exist=oracleSyncMapper.clazzSelect(clazzTable.getId());
            boolean same=clazzTable.equals(exist);
            if(!same){ sendMail(clazzTable,exist); }
            if(exist==null){
                oracleSyncMapper.clazzInsert(clazzTable);
            }else{
                oracleSyncMapper.ClazzUpdate(clazzTable);
            }
        }
        List<CourseTable> courseTableList = syncMapper.courseSelect();
        for(CourseTable courseTable:courseTableList){
            CourseTable exist=oracleSyncMapper.courseSelect(courseTable.getId());
            boolean same=courseTable.equals(exist);
            if(!same){ sendMail(courseTable,exist); }
            if(exist==null){
                oracleSyncMapper.courseInsert(courseTable);
            }else{
                oracleSyncMapper.CourseUpdate(courseTable);
            }
        }
        List<DeptTable> deptTableList = syncMapper.deptSelect();
        for(DeptTable deptTable:deptTableList){
            DeptTable exist=oracleSyncMapper.deptSelect(deptTable.getId());
            boolean same=deptTable.equals(exist);
            if(!same){ sendMail(deptTable,exist); }
            if(exist==null){
                oracleSyncMapper.deptInsert(deptTable);
            }else{
                oracleSyncMapper.DeptUpdate(deptTable);
            }
        }
        List<EmpTable> empTableList = syncMapper.empSelect();
        for(EmpTable empTable:empTableList){
            EmpTable exist=oracleSyncMapper.empSelect(empTable.getId());
            boolean same=empTable.equals(exist);
            if(!same){ sendMail(empTable,exist); }
            if(exist==null){
                oracleSyncMapper.empInsert(empTable);
            }else{
                oracleSyncMapper.EmpUpdate(empTable);
            }
        }
        List<EmpCourseTable> empCourseTableList = syncMapper.empCourseSelect();
        for(EmpCourseTable empCourseTable:empCourseTableList){
            EmpCourseTable exist=oracleSyncMapper.empCourseSelect(empCourseTable.getId());
            boolean same=empCourseTable.equals(exist);
            if(!same){ sendMail(empCourseTable,exist); }
            if(exist==null){
                oracleSyncMapper.empCourseInsert(empCourseTable);
            }else{
                oracleSyncMapper.EmpCourseUpdate(empCourseTable);
            }
        }
        List<EmpExprTable> empExprTableList = syncMapper.empExprSelect();
        for(EmpExprTable empExprTable:empExprTableList){
            EmpExprTable exist=oracleSyncMapper.empExprSelect(empExprTable.getId());
            boolean same=empExprTable.equals(exist);
            if(!same){ sendMail(empExprTable,exist); }
            if(exist==null){
                oracleSyncMapper.empExprInsert(empExprTable);
            }else{
                oracleSyncMapper.EmpExprUpdate(empExprTable);
            }
        }
        List<EmpLogTable> empLogTableList = syncMapper.empLogSelect();
        for(EmpLogTable empLogTable:empLogTableList){
            EmpLogTable exist=oracleSyncMapper.empLogSelect(empLogTable.getId());
            boolean same=empLogTable.equals(exist);
            if(!same){ sendMail(empLogTable,exist); }
            if(exist==null){
                oracleSyncMapper.empLogInsert(empLogTable);
            }else{
                oracleSyncMapper.EmpLogUpdate(empLogTable);
            }
        }
        List<OperateLogTable> operateLogTableList = syncMapper.operateLogSelect();
        for(OperateLogTable operateLogTable:operateLogTableList){
            OperateLogTable exist=oracleSyncMapper.operateLogSelect(operateLogTable.getId());
            boolean same=operateLogTable.equals(exist);
            if(!same){ sendMail(operateLogTable,exist); }
            if(exist==null){
                oracleSyncMapper.operateLogInsert(operateLogTable);
            }else{
                oracleSyncMapper.OperateLogUpdate(operateLogTable);
            }
        }
        List<StudentTable> studentTableList = syncMapper.studentSelect();
        for(StudentTable studentTable:studentTableList){
            StudentTable exist=oracleSyncMapper.studentSelect(studentTable.getId());
            boolean same=studentTable.equals(exist);
            if(!same){ sendMail(studentTable,exist); }
            if(exist==null){
                oracleSyncMapper.studentInsert(studentTable);
            }else{
                oracleSyncMapper.StudentUpdate(studentTable);
            }
        }
        List<StudentCourseTable> studentCourseTableList = syncMapper.studentCourseSelect();
        for(StudentCourseTable studentCourseTable:studentCourseTableList){
            StudentCourseTable exist=oracleSyncMapper.studentCourseSelect(studentCourseTable.getId());
            boolean same=studentCourseTable.equals(exist);
            if(!same){ sendMail(studentCourseTable,exist); }
            if(exist==null){
                oracleSyncMapper.studentCourseInsert(studentCourseTable);
            }else{
                oracleSyncMapper.StudentCourseUpdate(studentCourseTable);
            }
        }
        List<StudentLoginTable> studentLoginTableList = syncMapper.studentLoginSelect();
        for(StudentLoginTable studentLoginTable:studentLoginTableList){
            StudentLoginTable exist=oracleSyncMapper.studentLoginSelect(studentLoginTable.getId());
            boolean same=studentLoginTable.equals(exist);
            if(!same){ sendMail(studentLoginTable,exist); }
            if(exist==null){
                oracleSyncMapper.studentLoginInsert(studentLoginTable);
            }else{
                oracleSyncMapper.StudentLoginUpdate(studentLoginTable);
            }
        }
        List<StudentOperateLogTable> studentOperateLogTableList = syncMapper.studentOperateLogSelect();
        for(StudentOperateLogTable studentOperateLogTable:studentOperateLogTableList){
            StudentOperateLogTable exist=oracleSyncMapper.studentOperateLogSelect(studentOperateLogTable.getId());
            boolean same=studentOperateLogTable.equals(exist);
            if(!same){ sendMail(studentOperateLogTable,exist); }
            if(exist==null){
                oracleSyncMapper.studentOperateLogInsert(studentOperateLogTable);
            }else{
                oracleSyncMapper.StudentOperateLogUpdate(studentOperateLogTable);
            }
        }
        log.info("数据同步完成");
    }
    @Async
    @Scheduled(cron = "*/10 * * * * ?")//每十秒更新
    //@Scheduled(cron = "0 0 * * * ?")//每小时（整点）更新
    public void hourlySync() {
        syncDatabase();
    }

    public void sendMail(Object mysqlTable, Object oracleTable) {
        try {
            ObjectMapper mapper = JsonMapper.builder()
                    .addModule(new JavaTimeModule())
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .build();

            // 将两个对象格式化为 JSON 字符串
            String mysqlJson = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(mysqlTable);

            String oracleJson = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(oracleTable);

            // 邮件内容
            String content =
                    "【MySQL 表数据】\n" + mysqlJson +
                            "\n\n【Oracle 表数据】\n" + oracleJson;

            mailService.sendSimpleMail(
                    "56128639@qq.com",
                    "老大数据库有错误喵",
                    content
            );

        } catch (Exception e) {
            e.printStackTrace(); // 你可以换成日志
        }
    }


}
