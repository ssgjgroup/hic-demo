package com.winning.hic.base.aspect;

import com.alibaba.fastjson.JSONArray;
import com.winning.hic.base.config.CisTableNameConfig;
import com.winning.hic.base.utils.StringUtil;
import com.winning.hic.model.MbzDataError;
import com.winning.hic.service.MbzDataErrorService;
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
 * @author Eovl
 * @title
 * @package com.winning.hic.base.aspect
 * @date: 2018-11-21 14:11
 */
@Aspect
@Component
public class SplitTableAscept {

    private static final Logger logger = LoggerFactory.getLogger(SplitTableAscept.class);

    @Autowired
    private MbzDataErrorService mbzDataErrorService;

    @Pointcut("execution(* com.winning.hic.dao.hdw.SplitTableDao.selectAnmr*ByProc(..))")
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
        String allName = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();
        // 样例 void com.winning.hic.dao.hdw.SplitTableDao.selectAnmrRyjlRcyjlSplitByProc(HlhtRyjlRcyjl)
        allName = allName.split(" ")[1];
        allName = allName.substring(0, allName.lastIndexOf("."));
        String methodName = joinPoint.getSignature().getName();
        String className = allName + "." + methodName;
        String dataType = StringUtil.HumpToUnderline(methodName)
                .replace("SELECT_", "")
                .replace("_SPLIT_BY_PROC", "");
        StringBuilder msg = new StringBuilder();
        if (dataType.startsWith("HLHT") || dataType.startsWith("AMER")) {
            if(!"AMER_ZCJL_DCJL".equals(dataType)){
                dataType = dataType.replace("AMER","HLHT");
            }
            msg.append(CisTableNameConfig.getDataListName(dataType));
        } else {
            msg.append(dataType);
        }
        try {
            logger.info("拆分存储开始执行>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}", className);
            ((ProceedingJoinPoint) joinPoint).proceed();
            logger.info("拆分存储执行结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}", className);
        } catch (Throwable throwable) {
            logger.info(throwable.getMessage());
            MbzDataError error = new MbzDataError();
            error.setClassName(className);
            error.setMethodName(methodName);
            error.setSourceName(msg.toString());
            error.setArgumentString(JSONArray.toJSON(args).toString());
            error.setErrorMessage(throwable.getMessage());
            error.setErrorTime(new Date());
            mbzDataErrorService.createMbzDataError(error);
        }
    }
}
