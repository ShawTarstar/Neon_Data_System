package com.taxing.tliaswebmanagement.aop;

import com.taxing.tliaswebmanagement.mapper.mysql.OperateLogMapper;
import com.taxing.tliaswebmanagement.pojo.OperateLog;
import com.taxing.tliaswebmanagement.utils.CurrentHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class OperateLogAspect {
    @Autowired
    OperateLogMapper operateLogMapper;

    /**
     * 切点: 拦截 controller 包下的 增、删、改 方法
     */

    /**
     * 环绕通知: 记录操作日志
     */
    @Around("@annotation(com.taxing.tliaswebmanagement.anno.Log)")
    public Object recordOperateLog(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object result = null;

        try {
            // 执行目标方法
            result = joinPoint.proceed();
            return result;
        } finally {
            long costTime = System.currentTimeMillis() - start;

            // 构建日志对象
            OperateLog logEntity = new OperateLog();
            logEntity.setOperateEmpId(getCurrentEmpId());
            logEntity.setOperateTime(LocalDateTime.now());
            logEntity.setClassName(joinPoint.getTarget().getClass().getName());
            logEntity.setMethodName(joinPoint.getSignature().getName());
            logEntity.setMethodParams(Arrays.toString(joinPoint.getArgs()));
            logEntity.setReturnValue(result!=null?result.toString():"void");
            logEntity.setCostTime(costTime);

            // 保存到数据库
            operateLogMapper.insert(logEntity);

            log.info("操作日志已记录: {}", logEntity);
        }
    }

    /**
     * 模拟获取当前登录用户的ID
     * 实际场景下可从SecurityContextHolder、ThreadLocal或session中获取
     */
    private Integer getCurrentEmpId() {
        return CurrentHolder.getCurrentId(); // 假设当前操作人ID为1
    }
}

