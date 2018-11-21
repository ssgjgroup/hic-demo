package com.winning.hic.job;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.Facade;
import com.winning.hic.service.HlhtRyjlRcyjlService;
import com.winning.hic.service.HlhtRyjlRyswjlService;
import com.winning.hic.service.impl.HlhtRyjlRcyjlServiceImpl;
import com.winning.hic.service.impl.HlhtRyjlRyswjlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.readers.operation.OperationNotesReader;

/**
 * 入出院记录线程
 */
public class RyjlThread extends Thread {
    private MbzDataCheck entity;

    public RyjlThread(MbzDataCheck entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        HlhtRyjlRcyjlService hlhtRyjlRcyjlService = new HlhtRyjlRcyjlServiceImpl();
        HlhtRyjlRyswjlService hlhtRyjlRyswjlService = new HlhtRyjlRyswjlServiceImpl();
        try {
            //1. 24h内入出院记录  --陈世杰
            hlhtRyjlRcyjlService.interfaceHlhtRyjlRcyjl(entity);
            //2. 24h内入院死亡记录*  -- 陈世杰
            hlhtRyjlRyswjlService.interfaceHlhtRyjlRyswjl(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
