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
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class SplitTableAscept {

    private static final Logger logger = LoggerFactory.getLogger(SplitTableAscept.class);

    @Autowired
    private MbzOperateLogService mbzOperateLogService;

    @Pointcut("execution(* com.winning.hic.dao.hdw.SplitTableDao..selectAnmr*(..))")
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
        String className = joinPoint.getTarget().getClass().getName();
        try {
            logger.info("拆分存储开始执行>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}", className);
            ((ProceedingJoinPoint) joinPoint).proceed();
            logger.info("拆分存储执行结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}", className);
        } catch (Throwable throwable) {
            logger.info(throwable.getMessage());
        }
    }
}
