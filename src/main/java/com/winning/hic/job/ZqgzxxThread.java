package com.winning.hic.job;

import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.*;
import com.winning.hic.service.impl.*;

/**
 * 入出院记录线程
 */
public class ZqgzxxThread extends Thread {
    private MbzDataCheck entity;

    public ZqgzxxThread(MbzDataCheck entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        HlhtZqgzxxBwztzsService hlhtRyjlRcyjlService = new HlhtZqgzxxBwztzsServiceImpl();
        HlhtZqgzxxMzzqtysService hlhtZqgzxxMzzqtysService = new HlhtZqgzxxMzzqtysServiceImpl();
        HlhtZqgzxxQtzqtysService hlhtZqgzxxQtzqtysService = new HlhtZqgzxxQtzqtysServiceImpl();
        HlhtZqgzxxSstysService hlhtZqgzxxSstysService = new HlhtZqgzxxSstysServiceImpl();
        HlhtZqgzxxSxzltysService hlhtZqgzxxSxzltysService = new HlhtZqgzxxSxzltysServiceImpl();
        HlhtZqgzxxTsjczltysService hlhtZqgzxxTsjczltysService = new HlhtZqgzxxTsjczltysServiceImpl();
        try {
            //3. 病危（重）通知书*  --陈枫
            hlhtRyjlRcyjlService.interfaceHlhtZqgzxxBwztzs(entity);
            //18.麻醉知情同意书表* --陈枫
            hlhtZqgzxxMzzqtysService.interfaceHlhtZqgzxxMzzqtys(entity);
            //19.其他知情告知同意书*  --陈蒯
            hlhtZqgzxxQtzqtysService.interfaceHlhtZqgzxxQtzqtys(entity);
            //24.手术知情同意书表*--陈世杰
            hlhtZqgzxxSstysService.interfaceHlhtZqgzxxSstys(entity);
            //25.输血治疗同意书表* -- 陈枫
            hlhtZqgzxxSxzltysService.interfaceHlhtZqgzxxSxzltys(entity);
            //29.特殊检查及特殊治疗同意书* --陈世杰
            hlhtZqgzxxTsjczltysService.interfaceHlhtZqgzxxTsjczltys(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
