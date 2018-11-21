package com.winning.hic.job;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.model.MbzDictInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.winning.hic.base.utils.DateUtil;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.service.Facade;

/**
 * @author chensj
 * @title 数据抽取任务
 * @email chensj@winning.com.cn
 * @package com.winning.hic.job
 * @date: 2018-09-13 11:08
 */
@Configuration
@Component
@EnableScheduling
public class DataExtraJob {


    @Autowired
    private Facade facade;

    private static final Logger logger = LoggerFactory.getLogger(DataExtraJob.class);

    public void extraData() {
        logger.info("数据抽取开始时间为：[{}]", DateUtil.format(new Date(), DateUtil.PATTERN_19));
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 1); //抽取前一天数据 注释则抽取当前数据
        String beforeToday = DateUtil.format(c.getTime());
        //System.out.println(beforeToday);
        String startDate = beforeToday + " 00:00:00";
        String endDate = beforeToday + " 23:59:59";
        dataLoad(startDate, endDate);
        logger.info("数据抽取结束时间为：[{}]", DateUtil.format(new Date(), DateUtil.PATTERN_19));
    }


    private void dataLoad(String startDate, String endDate) {
        MbzDictInfo temp = new MbzDictInfo();
        temp.setDictCode("hospitalInfoNo");
        temp = facade.getMbzDictInfoService().getMbzDictInfo(temp);
        MbzDataCheck entity = new MbzDataCheck();
        entity.getMap().put("startDate", startDate);
        entity.getMap().put("endDate", endDate);
        entity.setIsAutomate(1);
        entity.getMap().put("yljgdm", temp.getDictLabel());
        entity.getMap().put("regex", SplitParamsConstants.SPECIAL_SPLIT_FLAG);
        //抽取线程
        new MjzblThread(entity).start();
        new OtherThread(entity).start();
        new RyjlThread(entity).start();
        new ZqgzxxThread(entity).start();
        new ZybcjlThread(entity).start();
        new ZybcThread(entity).start();

    }
}
