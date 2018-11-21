package com.winning.hic.job;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import com.winning.hic.service.impl.*;

/**
 * 入出院记录线程
 */
public class OtherThread extends Thread {
    private MbzDataCheck entity;

    public OtherThread(MbzDataCheck entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        HlhtZlczjlYbssjlService hlhtZlczjlYbssjlService = new HlhtZlczjlYbssjlServiceImpl();
        HlhtCyxjCyxjService hlhtCyxjCyxjService = new HlhtCyxjCyxjServiceImpl();
        HlhtZzyjlZzyjlService hlhtZzyjlZzyjlService = new HlhtZzyjlZzyjlServiceImpl();
        HlhtZlczjlSxjlService hlhtZlczjlSxjlService = new HlhtZlczjlSxjlServiceImpl();
        HlhtZlczjlZljlService hlhtZlczjlZljlService = new HlhtZlczjlZljlServiceImpl();
        HlhtZcjlYdfmService hlhtZcjlYdfmService = new HlhtZcjlYdfmServiceImpl();
        HlhtZcjlPgcService hlhtZcjlPgcService = new HlhtZcjlPgcServiceImpl();
        HlhtBlgyJbjkxxService hlhtBlgyJbjkxxService = new HlhtBlgyJbjkxxServiceImpl();
        try {
            //20.一般手术记录表(待定）*    --陈蒯
            hlhtZlczjlYbssjlService.interfaceHlhtZlczjlYbssjl(entity);
            //22.出院小结数据集表*  --陈蒯
            hlhtCyxjCyxjService.interfaceHlhtCyxjCyxj(entity);
            //28.转诊(院)记录数据集表* --陈蒯  (暂时不处理)
            hlhtZzyjlZzyjlService.interfaceHlhtZzyjlZzyjl(entity);
            //30.输血记录表* --陈枫
            hlhtZlczjlSxjlService.interfaceHlhtZlczjlSxjl(entity);
            //33.治疗记录表* --陈枫
            hlhtZlczjlZljlService.interfaceHlhtZlczjlZljl(entity);
            //34.阴道分娩记录表*  --陈枫（暂时不处理）
            hlhtZcjlYdfmService.interfaceHlhtZcjlYdfm(entity);
            //35.剖宫产记录表* --陈蒯
            hlhtZcjlPgcService.interfaceHlhtZcjlPgc(entity);
            //36.基本健康信息表* --陈世杰
            hlhtBlgyJbjkxxService.interfaceHlhtBlgyJbjkxx(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
