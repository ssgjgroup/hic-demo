package com.winning.hic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winning.hic.base.Constants;
import com.winning.hic.model.MbzAutomateSet;

/**
 * @author chensj
 * @title
 * @email chensj@winning.com.cn
 * @package com.winning.hic.controller
 * @date: 2018-09-14 10:22
 */
@RestController
@RequestMapping(value = "/autoSet")
public class MbzAutomateSetController extends BaseController {

    @PostMapping(value = "/edit")
    public Map<String, Object>  addOrUpdateMbzAutomateSet(String date){
        String cronStr = convertDateStringToCronString(date);
        System.out.println(cronStr);
        int count = getFacade().getMbzAutomateSetService().getMbzAutomateSetCount(null);
        if(count > 0){
            MbzAutomateSet automateSet = getFacade().getMbzAutomateSetService().getMbzAutomateSet(null);
            automateSet.setBatchDate(date);
            automateSet.setCron(cronStr);
            getFacade().getMbzAutomateSetService().modifyMbzAutomateSet(automateSet);
        }else{
            MbzAutomateSet automateSet = new MbzAutomateSet();
            automateSet.setGroupName("HLHT");
            automateSet.setJobName("HLHT-Job");
            automateSet.setTriggerName("HLHT-Trigger");
            automateSet.setBatchDate(date);
            automateSet.setCron(cronStr);
            getFacade().getMbzAutomateSetService().createMbzAutomateSet(automateSet);
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        return result;
    }

    /**
     * 将hh:mm:ss转换为到cron字符串
     * @param dateString
     * @return
     */
    public static String convertDateStringToCronString(String dateString){
        String[] dateArray = dateString.split(":");
        StringBuilder cronString = new StringBuilder();
        //处理秒
        if("00".equals(dateArray[2])){
            cronString.append("0 ");
        }else{
            if(dateArray[2].startsWith("0")){
                cronString.append(dateArray[2].substring(1)+" ");
            }else{
                cronString.append(dateArray[2]+" ");
            }
        }
        //处理分钟
        if("00".equals(dateArray[1])){
            cronString.append("0 ");
        }else{
            if(dateArray[1].startsWith("0")){
                cronString.append(dateArray[1].substring(1)+" ");
            }else{
                cronString.append(dateArray[1]+" ");
            }
        }
        //处理小时
        if("00".equals(dateArray[0])){
            cronString.append("0 ");
        }else{
            if(dateArray[0].startsWith("0")){
                cronString.append(dateArray[0].substring(1)+" ");
            }else{
                cronString.append(dateArray[0]+" ");
            }
        }
        cronString.append("* * ?");
        return  cronString.toString();
    }

    public static void main(String[] args){
       String aa = "02:01:01";
        System.out.println(convertDateStringToCronString(aa));
    }

}