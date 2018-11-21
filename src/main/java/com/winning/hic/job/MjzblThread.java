package com.winning.hic.job;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import com.winning.hic.service.impl.*;

/**
 * 入出院记录线程
 */
public class MjzblThread extends Thread {
    private MbzDataCheck entity;

    public MjzblThread(MbzDataCheck entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        HlhtRyjlJbxxService hlhtRyjlJbxxService = new HlhtRyjlJbxxServiceImpl();
        HlhtMjzblMjzblService hlhtMjzblMjzblService = new HlhtMjzblMjzblServiceImpl();
        HlhtMjzblJzlgblService hlhtMjzblJzlgblService = new HlhtMjzblJzlgblServiceImpl();
        try {
            //5.入院记录* --陈枫
            hlhtRyjlJbxxService.interfaceHlhtRyjlJbxx(entity);
            //31.门急诊病历记录表* --陈蒯
            hlhtMjzblMjzblService.interfaceHlhtMjzblMjzbl(entity);
            //32.急诊留观病历记录表*   --陈世杰
            hlhtMjzblJzlgblService.interfaceHlhtMjzblJzlgbl(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
