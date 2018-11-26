//package com.winning.hic.base.aspect;
//
//import com.alibaba.druid.util.StringUtils;
//import org.aopalliance.intercept.Joinpoint;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author LENOVO
// * @title
// * @project hic
// * @package com.winning.hic.base.aspect
// * @date: 2018-11-26 8:45
// */
//@Aspect
//@Component
//public class LoggerAscept {
//
//    private static final Logger logger = LoggerFactory.getLogger(LoggerAscept.class);
//
//    @Pointcut("execution(* com.winning.hic.controller..*(..))")
//    public void controllerErrorPointcut(){}
//
//    @AfterThrowing(value = "controllerErrorPointcut()",throwing = "e")
//    public void handleThrowing(JoinPoint joinPoint, Exception e) {//controller类抛出的异常在这边捕获
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        logger.error("异常:[{}],异常所在类：[{}],异常所在方法：[{}],异常中的参数:[{}]+\n\r",e.getMessage(),className,methodName,args);
//    }
//
//}
