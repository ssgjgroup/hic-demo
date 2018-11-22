package com.winning.hic.job.thread;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 入出院记录线程
 */
public class ZybcjlThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(ZybcjlThread.class);

    private MbzDataCheck entity;
    private Facade facade;

    public ZybcjlThread(MbzDataCheck entity, Facade facade) {
        this.entity = entity;
        this.facade = facade;
    }

    @Override
    public void run() {
        logger.info("启动线程>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ZybcjlThread");

        try {
            //21.会诊记录数据集表* --陈蒯
            facade.getHlhtZybcjlHzjlService().interfaceHlhtZybcjlHzjl(entity);
            //23.上级医师查房记录数据集表*  --陈世杰
            facade.getHlhtZybcjlSjyscfjlService().interfaceHlhtZybcjlSjyscfjl(entity);
            //26.疑难病例讨论数据集表* --陈枫
            facade.getHlhtZybcjlYnbltljlService().interfaceHlhtZybcjlYnbltljl(entity);
            //27.转科记录数据集表*  --陈蒯
            facade.getHlhtZybcjlZkjlService().interfaceHlhtZybcjlZkjl(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("线程结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ZybcjlThread");

    }
}
