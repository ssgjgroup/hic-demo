package com.winning.hic.job;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.Facade;
import com.winning.hic.service.HlhtRyjlRcyjlService;
import com.winning.hic.service.HlhtRyjlRyswjlService;
import com.winning.hic.service.impl.HlhtRyjlRcyjlServiceImpl;
import com.winning.hic.service.impl.HlhtRyjlRyswjlServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.readers.operation.OperationNotesReader;

/**
 * 入出院记录线程
 */
public class RyjlThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(RyjlThread.class);

    private MbzDataCheck entity;

    private Facade facade;

    public RyjlThread(MbzDataCheck entity, Facade facade) {
        this.entity = entity;
        this.facade = facade;
    }

    @Override
    public void run() {
        logger.info("启动线程>>>>>>>>>>>>>>>>>>>>>>>>>>>>>RyjlThread");

        try {
            //1. 24h内入出院记录  --陈世杰
            facade.getHlhtRyjlRcyjlService().interfaceHlhtRyjlRcyjl(entity);
            //2. 24h内入院死亡记录*  -- 陈世杰
            facade.getHlhtRyjlRyswjlService().interfaceHlhtRyjlRyswjl(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("线程结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>RyjlThread");

    }

}
