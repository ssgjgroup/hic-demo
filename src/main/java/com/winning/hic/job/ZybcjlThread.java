package com.winning.hic.job;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import com.winning.hic.service.impl.*;

/**
 * 入出院记录线程
 */
public class ZybcjlThread extends Thread {
    private MbzDataCheck entity;

    public ZybcjlThread(MbzDataCheck entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        HlhtZybcjlHzjlService hlhtZybcjlHzjlService = new HlhtZybcjlHzjlServiceImpl();
        HlhtZybcjlSjyscfjlService hlhtZybcjlSjyscfjlService = new HlhtZybcjlSjyscfjlServiceImpl();
        HlhtZybcjlYnbltljlService hlhtZybcjlYnbltljlService = new HlhtZybcjlYnbltljlServiceImpl();
        HlhtZybcjlZkjlService hlhtZybcjlZkjlService = new HlhtZybcjlZkjlServiceImpl();
        try {
            //21.会诊记录数据集表* --陈蒯
            hlhtZybcjlHzjlService.interfaceHlhtZybcjlHzjl(entity);
            //23.上级医师查房记录数据集表*  --陈世杰
            hlhtZybcjlSjyscfjlService.interfaceHlhtZybcjlSjyscfjl(entity);
            //26.疑难病例讨论数据集表* --陈枫
            hlhtZybcjlYnbltljlService.interfaceHlhtZybcjlYnbltljl(entity);
            //27.转科记录数据集表*  --陈蒯
            hlhtZybcjlZkjlService.interfaceHlhtZybcjlZkjl(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
