package com.winning.hic.job.thread;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 入出院记录线程
 */
public class ZybcThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(ZybcThread.class);
    private MbzDataCheck entity;
    private Facade facade;

    public ZybcThread(MbzDataCheck entity, Facade facade) {
        this.entity = entity;
        this.facade = facade;
    }

    @Override
    public void run() {
        logger.info("ZybcThread 数据抽取开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        try {
            //4.出院记录数据集表* --陈枫
            facade.getHlhtZybcjlCyjlService().interfaceHlhtZybcjlCyjl(entity);
            //6.首次病程记录表* --陈蒯
            facade.getHlhtZybcjlScbcjlService().interfaceHlhtZybcjlScbcjl(entity);
            //7.日常病程记录数据集表*  --陈枫
            facade.getHlhtZybcjlRcbcjlService().interfaceHlhtZybcjlRcbcjl(entity);
            //8.交接班记录数据集表(医院一般不在病历里面写交接班记录，CIS有一个交接班的功能)*    --陈蒯（暂时不处理）
            facade.getHlhtZybcjlJjbjlService().interfaceHlhtZybcjlJjbjl(entity);
            //9.--阶段小结数据集表*   --陈蒯
            facade.getHlhtZybcjlJdxjService().interfaceHlhtZybcjlJdxj(entity);
            //10.抢救记录数据集表*  --陈蒯
            facade.getHlhtZybcjlQjjlService().interfaceHlhtZybcjlQjjl(entity);
            //11.术后首次病程记录数据集表* --- 陈世杰
            facade.getHlhtZybcjlShscbcjlService().interfaceHlhtZybcjlShscbcjl(entity);
            //12.术前小结数据集表* --- 陈世杰
            facade.getHlhtZybcjlSqxjService().interfaceHlhtZybcjlSqxj(entity);
            //13.术前讨论数据集表*   --陈世杰
            facade.getHlhtZybcjlSqtlService().interfaceHlhtZybcjlSqtl(entity);
            //14.死亡病历讨论记录数据集表* --陈世杰
            facade.getHlhtZybcjlSwbltljlService().interfaceHlhtZybcjlSwbltljl(entity);
            //15.死亡记录数据集表*  --陈枫
            facade.getHlhtZybcjlSwjlService().interfaceHlhtZybcjlSwjl(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("ZybcThread 数据抽取结束<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
