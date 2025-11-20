package com.taxing.tliaswebmanagement.aop;

import com.taxing.tliaswebmanagement.mapper.CourseMapper;
import com.taxing.tliaswebmanagement.mapper.OperateLogMapper;

import com.taxing.tliaswebmanagement.mapper.StudentSelectionMapper;
import com.taxing.tliaswebmanagement.pojo.student.other.OperateLogStudent;
import com.taxing.tliaswebmanagement.pojo.student.other.StudentCourse;
import com.taxing.tliaswebmanagement.utils.CurrentHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class StudentOperateLogAspect {
    @Autowired
    OperateLogMapper operateLogMapper;
    @Autowired
    StudentSelectionMapper studentSelectionMapper;
    @Autowired
    CourseMapper courseMapper;

    /**
     * 切点: 拦截 controller 包下的 增、删、改 方法
     */

    /**
     * 环绕通知: 记录操作日志
     */
    @Around("@annotation(com.taxing.tliaswebmanagement.anno.StudentLog)")
    public Object recordOperateLog(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        String methodParams = Arrays.toString(joinPoint.getArgs());

        // 预先为 delete 情况获取课程名
        String preCourseName = null;
        Integer prePeriod = null;

        if (methodName.equals("delete")) {
            Integer id = Integer.parseInt(methodParams.substring(1, methodParams.length() - 1));
            StudentCourse studentCourse = studentSelectionMapper.getStudentCourseById(id); // 删除前拿得到
            Integer courseId = studentCourse.getCourseId();
            prePeriod = studentCourse.getPeriod();
            preCourseName = courseMapper.selectCourseNameById(courseId);
        }

        try {
            // 执行目标方法
            result = joinPoint.proceed();
        }catch (Throwable e){
            log.error("方法执行异常，不记录学生操作日志: {}", e.getMessage());
            throw e; // 继续抛出，不吞异常
        }
        // 构建日志对象
        OperateLogStudent logEntity = new OperateLogStudent();
        logEntity.setOperateStudentId(getCurrentEmpId());
        logEntity.setOperateTime(LocalDateTime.now());
//            logEntity.setClassName(joinPoint.getTarget().getClass().getName());
//            logEntity.setMethodName(joinPoint.getSignature().getName());
        if(methodName.equals("selectCourse")){
            logEntity.setOperation("选课");
            String[] parts = methodParams.replace("[", "")
                    .replace("]", "")
                    .split(",");
            String studentIdString = parts[0].trim();
            String empCourseIdString = parts[1].trim();  // 去空格
            Integer studentId = Integer.parseInt(studentIdString);
            Integer empCourseId = Integer.parseInt(empCourseIdString);
            StudentCourse studentCourse = studentSelectionMapper.getStudentCourseWithStudentIdAndEmpCourseId(studentId, empCourseId);
            Integer courseId = studentCourse.getCourseId();
            Integer period = studentCourse.getPeriod();
            String courseName = courseMapper.selectCourseNameById(courseId);
            logEntity.setCourseName(courseName);
            logEntity.setPeriod(period);

        }else if(methodName.equals("delete")){
            logEntity.setOperation("退课");
            logEntity.setCourseName(preCourseName);
            logEntity.setPeriod(prePeriod);
        }else{
            logEntity.setOperation("未知操作");
        }
        // 保存到数据库
        operateLogMapper.studentInsert(logEntity);

        log.info("操作日志已记录: {}", logEntity);
        return result;
    }

    /**
     * 模拟获取当前登录用户的ID
     * 实际场景下可从SecurityContextHolder、ThreadLocal或session中获取
     */
    private Integer getCurrentEmpId() {
        return CurrentHolder.getCurrentId(); // 假设当前操作人ID为1
    }
}