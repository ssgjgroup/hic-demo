package com.winning.hic.job;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import com.winning.hic.service.impl.*;

/**
 * 入出院记录线程
 */
public class ZybcThread extends Thread {
    private MbzDataCheck entity;

    public ZybcThread(MbzDataCheck entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        HlhtZybcjlCyjlService hlhtZybcjlCyjlService = new HlhtZybcjlCyjlServiceImpl();
        HlhtZybcjlScbcjlService hlhtZybcjlScbcjlService = new HlhtZybcjlScbcjlServiceImpl();
        HlhtZybcjlRcbcjlService hlhtZybcjlRcbcjlService = new HlhtZybcjlRcbcjlServiceImpl();
        HlhtZybcjlJjbjlService hlhtZybcjlJjbjlService = new HlhtZybcjlJjbjlServiceImpl();
        HlhtZybcjlJdxjService hlhtZybcjlJdxjService = new HlhtZybcjlJdxjServiceImpl();
        HlhtZybcjlQjjlService hlhtZybcjlQjjlService = new HlhtZybcjlQjjlServiceImpl();
        HlhtZybcjlShscbcjlService hlhtZybcjlShscbcjlService = new HlhtZybcjlShscbcjlServiceImpl();
        HlhtZybcjlSqxjService hlhtZybcjlSqxjService = new HlhtZybcjlSqxjServiceImpl();
        HlhtZybcjlSqtlService hlhtZybcjlSqtlService = new HlhtZybcjlSqtlServiceImpl();
        HlhtZybcjlSwbltljlService hlhtZybcjlSwbltljlService = new HlhtZybcjlSwbltljlServiceImpl();
        HlhtZybcjlSwjlService hlhtZybcjlSwjlService = new HlhtZybcjlSwjlServiceImpl();
        try {
            //4.出院记录数据集表* --陈枫
            hlhtZybcjlCyjlService.interfaceHlhtZybcjlCyjl(entity);
            //6.首次病程记录表* --陈蒯
            hlhtZybcjlScbcjlService.interfaceHlhtZybcjlScbcjl(entity);
            //7.日常病程记录数据集表*  --陈枫
            hlhtZybcjlRcbcjlService.interfaceHlhtZybcjlRcbcjl(entity);
            //8.交接班记录数据集表(医院一般不在病历里面写交接班记录，CIS有一个交接班的功能)*    --陈蒯（暂时不处理）
            hlhtZybcjlJjbjlService.interfaceHlhtZybcjlJjbjl(entity);
            //9.--阶段小结数据集表*   --陈蒯
            hlhtZybcjlJdxjService.interfaceHlhtZybcjlJdxj(entity);
            //10.抢救记录数据集表*  --陈蒯
            hlhtZybcjlQjjlService.interfaceHlhtZybcjlQjjl(entity);
            //11.术后首次病程记录数据集表* --- 陈世杰
            hlhtZybcjlShscbcjlService.interfaceHlhtZybcjlShscbcjl(entity);
            //12.术前小结数据集表* --- 陈世杰
            hlhtZybcjlSqxjService.interfaceHlhtZybcjlSqxj(entity);
            //13.术前讨论数据集表*   --陈世杰
            hlhtZybcjlSqtlService.interfaceHlhtZybcjlSqtl(entity);
            //14.死亡病历讨论记录数据集表* --陈世杰
            hlhtZybcjlSwbltljlService.interfaceHlhtZybcjlSwbltljl(entity);
            //15.死亡记录数据集表*  --陈枫
            hlhtZybcjlSwjlService.interfaceHlhtZybcjlSwjl(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
