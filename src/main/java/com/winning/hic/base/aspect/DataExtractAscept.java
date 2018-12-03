package com.winning.hic.base.aspect;

import com.winning.hic.base.config.CisTableNameConfig;
import com.winning.hic.base.utils.StringUtil;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzOperateLog;
import com.winning.hic.service.MbzOperateLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author chensj
 * @title
 * @email chensj@winning.com.cn
 * @package com.winning.hic.base.aspect
 * @date: 2018-11-21 14:11
 */
@Aspect
@Component
public class DataExtractAscept {

    private static final Logger logger = LoggerFactory.getLogger(DataExtractAscept.class);

    @Autowired
    private MbzOperateLogService mbzOperateLogService;

    @Pointcut("execution(* com.winning.hic.service.impl..interface*(..))")
    public void servicePointcut() {
    }

    //@Before("servicePointcut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("==========执行controller前置通知===============");
        if (logger.isInfoEnabled()) {
            logger.info("before " + joinPoint);
        }
    }

    @Around("servicePointcut()")
    public void around(JoinPoint joinPoint) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        MbzDataCheck entity = (MbzDataCheck) arguments[0];
        MbzOperateLog log = new MbzOperateLog();
        log.setSetName(CisTableNameConfig.getDataListName(StringUtil.HumpToUnderline(methodName).replace("INTERFACE_", "")));
        log.setStartDate((String) entity.getMap().get("startDate"));
        log.setEndDate((String) entity.getMap().get("endDate"));
        //0:抽取中 1 :抽取完成
        log.setStatus(0);
        //0:手动 1：自动
        log.setType(entity.getIsAutomate());
        log.setCreateTime(new Date());
        mbzOperateLogService.createMbzOperateLog(log);
        long start = System.currentTimeMillis();
        try {

            MbzDataCheck check = (MbzDataCheck) ((ProceedingJoinPoint) joinPoint).proceed();
            if (check.getDataCount() == null || check.getRealCount() == null) {
                MbzOperateLog mbzOperateLog = new MbzOperateLog();
                mbzOperateLog.setId(log.getId());
                mbzOperateLogService.removeMbzOperateLog(mbzOperateLog);
                return;
            }
            log.setUpdateTime(new Date());
            log.setStatus(1);
            log.setOperateCount(check.getRealCount());
            log.setSumCount(check.getDataCount());
            mbzOperateLogService.modifyMbzOperateLog(log);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            long end = System.currentTimeMillis();
            logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + throwable.getMessage());
            log.setUpdateTime(new Date());
            log.setStatus(2);
            mbzOperateLogService.modifyMbzOperateLog(log);
        }
    }
}
