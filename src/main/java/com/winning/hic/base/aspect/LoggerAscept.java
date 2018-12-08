package com.winning.hic.base.aspect;

import com.alibaba.druid.util.StringUtils;
import com.winning.hic.base.config.CisTableNameConfig;
import com.winning.hic.base.utils.StringUtil;
import com.winning.hic.model.MbzDataError;
import com.winning.hic.service.MbzDataErrorService;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author LENOVO
 * @title DAO 问题拦截
 * @project hic
 * @package com.winning.hic.base.aspect
 * @date: 2018-11-26 8:45
 */
@Aspect
@Component
public class LoggerAscept {

    @Autowired
    private MbzDataErrorService mbzDataErrorService;

    private static final Logger logger = LoggerFactory.getLogger(LoggerAscept.class);

    @Pointcut("execution(* com.winning.hic.dao..*(..))")
    public void DAOErrorPointcut(){}

    /**
     * DAO层异常问题捕捉
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "DAOErrorPointcut()",throwing = "e")
    public void handleThrowing(JoinPoint joinPoint, Exception e) {//controller类抛出的异常在这边捕获
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        //切点路径 void com.winning.hic.dao.hdw.SplitTableDao.selectAnmrRyjlRcyjlSplitByProc(HlhtRyjlRcyjl)
        String allName = joinPoint.getSignature().toString();
        allName = allName.split(" ")[1];
        //调用方法类名
        String className = allName.substring(0, allName.lastIndexOf("."));
       // System.out.println("classname:"+className);
        MbzDataError error = new MbzDataError();
        error.setClassName(className);
        error.setMethodName(methodName);
        error.setErrorMessage(e.getMessage());
        error.setErrorTime(new Date());
        mbzDataErrorService.createMbzDataError(error);
        logger.error("异常所在类：[{}],异常所在方法：[{}],异常中的参数:[{}],异常:[{}]\n\r",className,methodName,args,e.getMessage());
    }

}
