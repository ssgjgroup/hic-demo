package com.winning.hic.job.thread;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 入出院记录线程
 */
public class OtherThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(OtherThread.class);
    private MbzDataCheck entity;
    private Facade facade;

    public OtherThread(MbzDataCheck entity, Facade facade) {
        this.entity = entity;
        this.facade = facade;
    }

    @Override
    public void run() {
        logger.info("启动线程>>>>>>>>>>>>>>>>>>>>>>>>>>>>>OtherThread");

        try {
            //20.一般手术记录表(待定）*    --陈蒯
            facade.getHlhtZlczjlYbssjlService().interfaceHlhtZlczjlYbssjl(entity);
            //22.出院小结数据集表*  --陈蒯
            facade.getHlhtCyxjCyxjService().interfaceHlhtCyxjCyxj(entity);
            //28.转诊(院)记录数据集表* --陈蒯  (暂时不处理)
            facade.getHlhtZzyjlZzyjlService().interfaceHlhtZzyjlZzyjl(entity);
            //30.输血记录表* --陈枫
            facade.getHlhtZlczjlSxjlService().interfaceHlhtZlczjlSxjl(entity);
            //33.治疗记录表* --陈枫
            facade.getHlhtZlczjlZljlService().interfaceHlhtZlczjlZljl(entity);
            //34.阴道分娩记录表*  --陈枫（暂时不处理）
            facade.getHlhtZcjlYdfmService().interfaceHlhtZcjlYdfm(entity);
            //35.剖宫产记录表* --陈蒯
            facade.getHlhtZcjlPgcService().interfaceHlhtZcjlPgc(entity);
            //36.基本健康信息表* --陈世杰
            facade.getHlhtBlgyJbjkxxService().interfaceHlhtBlgyJbjkxx(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("线程结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>OtherThread");

    }
}
