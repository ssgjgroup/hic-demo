package com.winning.hic.job.thread;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 入出院记录线程
 */
public class ZqgzxxThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(ZqgzxxThread.class);
    private MbzDataCheck entity;
    private Facade facade;

    public ZqgzxxThread(MbzDataCheck entity, Facade facade) {
        this.entity = entity;
        this.facade = facade;
    }

    @Override
    public void run() {
        logger.info("ZqgzxxThread 数据抽取开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        try {
            //3. 病危（重）通知书*  --陈枫
            facade.getHlhtZqgzxxBwztzsService().interfaceHlhtZqgzxxBwztzs(entity);
            //18.麻醉知情同意书表* --陈枫
            facade.getHlhtZqgzxxMzzqtysService().interfaceHlhtZqgzxxMzzqtys(entity);
            //19.其他知情告知同意书*  --陈蒯
            facade.getHlhtZqgzxxQtzqtysService().interfaceHlhtZqgzxxQtzqtys(entity);
            //24.手术知情同意书表*--陈世杰
            facade.getHlhtZqgzxxSstysService().interfaceHlhtZqgzxxSstys(entity);
            //25.输血治疗同意书表* -- 陈枫
            facade.getHlhtZqgzxxSxzltysService().interfaceHlhtZqgzxxSxzltys(entity);
            //29.特殊检查及特殊治疗同意书* --陈世杰
            facade.getHlhtZqgzxxTsjczltysService().interfaceHlhtZqgzxxTsjczltys(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("ZqgzxxThread 数据抽取结束<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
