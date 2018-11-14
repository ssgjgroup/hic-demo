package com.winning.hic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.winning.hic.service.EmrHzsqdjlkService;
import com.winning.hic.service.EmrMbkService;
import com.winning.hic.service.EmrMbmxkService;
import com.winning.hic.service.EmrMxmcmlkService;
import com.winning.hic.service.EmrQtbljlkService;
import com.winning.hic.service.Facade;
import com.winning.hic.service.HlhtBlgyJbjkxxService;
import com.winning.hic.service.HlhtBlgyWssjzyService;
import com.winning.hic.service.HlhtCyxjCyxjService;
import com.winning.hic.service.HlhtMjzblJzlgblService;
import com.winning.hic.service.HlhtMjzblMjzblService;
import com.winning.hic.service.HlhtMjzcfXycfService;
import com.winning.hic.service.HlhtMjzcfZycfService;
import com.winning.hic.service.HlhtRyjlJbxxService;
import com.winning.hic.service.HlhtRyjlRcyjlService;
import com.winning.hic.service.HlhtRyjlRyswjlService;
import com.winning.hic.service.HlhtZcjlPgcService;
import com.winning.hic.service.HlhtZcjlYdfmService;
import com.winning.hic.service.HlhtZlczjlMzshfsjlService;
import com.winning.hic.service.HlhtZlczjlMzsqfsjlService;
import com.winning.hic.service.HlhtZlczjlSxjlService;
import com.winning.hic.service.HlhtZlczjlYbssjlService;
import com.winning.hic.service.HlhtZlczjlZljlService;
import com.winning.hic.service.HlhtZqgzxxBwztzsService;
import com.winning.hic.service.HlhtZqgzxxMzzqtysService;
import com.winning.hic.service.HlhtZqgzxxQtzqtysService;
import com.winning.hic.service.HlhtZqgzxxSstysService;
import com.winning.hic.service.HlhtZqgzxxSxzltysService;
import com.winning.hic.service.HlhtZqgzxxTsjczltysService;
import com.winning.hic.service.HlhtZybcjlCyjlService;
import com.winning.hic.service.HlhtZybcjlHzjlService;
import com.winning.hic.service.HlhtZybcjlJdxjService;
import com.winning.hic.service.HlhtZybcjlJjbjlService;
import com.winning.hic.service.HlhtZybcjlQjjlService;
import com.winning.hic.service.HlhtZybcjlRcbcjlService;
import com.winning.hic.service.HlhtZybcjlScbcjlService;
import com.winning.hic.service.HlhtZybcjlShscbcjlService;
import com.winning.hic.service.HlhtZybcjlSjyscfjlService;
import com.winning.hic.service.HlhtZybcjlSqtlService;
import com.winning.hic.service.HlhtZybcjlSqxjService;
import com.winning.hic.service.HlhtZybcjlSwbltljlService;
import com.winning.hic.service.HlhtZybcjlSwjlService;
import com.winning.hic.service.HlhtZybcjlYnbltljlService;
import com.winning.hic.service.HlhtZybcjlZkjlService;
import com.winning.hic.service.HlhtZzyjlZzyjlService;
import com.winning.hic.service.MbzAutomateSetService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataColumnService;
import com.winning.hic.service.MbzDataErrorService;
import com.winning.hic.service.MbzDataListSetService;
import com.winning.hic.service.MbzDataSetService;
import com.winning.hic.service.MbzDataTemplateConfigService;
import com.winning.hic.service.MbzDatabasesListService;
import com.winning.hic.service.MbzDictInfoService;
import com.winning.hic.service.MbzLoadDataInfoService;
import com.winning.hic.service.MbzLogService;
import com.winning.hic.service.MbzModelCheckService;
import com.winning.hic.service.MbzTemplateNodeDetailInfoService;
import com.winning.hic.service.OutpJzjlkService;
import com.winning.hic.service.OutpOrderService;
import com.winning.hic.service.OutpOrderitemService;

/**
 * @author chensj
 * @title FacadeImpl
 * @email chensj@163.com
 * @package com.winning.hic.service.impl;
 * @date 2018-05-23 09:05:16
 */
@Component
public class FacadeImpl implements Facade {

    @Autowired
    EmrHzsqdjlkService emrHzsqdjlkService;

    @Autowired
    EmrMxmcmlkService emrMxmcmlkService;

    @Autowired
    EmrMbkService emrMbkService;

    @Autowired
    MbzAutomateSetService mbzAutomateSetService;

    @Autowired
    MbzDatabasesListService mbzDatabasesListService;

    @Autowired
    MbzDataCheckService mbzDataCheckService;

    @Autowired
    MbzDataListSetService mbzDataListSetService;

    @Autowired
    MbzDataSetService mbzDataSetService;

    @Autowired
    MbzDictInfoService mbzDictInfoService;

    @Autowired
    MbzLogService mbzLogService;

    @Autowired
    MbzModelCheckService mbzModelCheckService;

    @Autowired
    MbzDataTemplateConfigService mbzDataTemplateConfigService;

    @Autowired
    EmrQtbljlkService emrQtbljlkService;

    @Autowired
    HlhtBlgyJbjkxxService hlhtBlgyJbjkxxService;

    @Autowired
    HlhtBlgyWssjzyService hlhtBlgyWssjzyService;

    @Autowired
    HlhtCyxjCyxjService hlhtCyxjCyxjService;

    @Autowired
    HlhtMjzblJzlgblService hlhtMjzblJzlgblService;

    @Autowired
    HlhtMjzblMjzblService hlhtMjzblMjzblService;

    @Autowired
    HlhtMjzcfXycfService hlhtMjzcfXycfService;

    @Autowired
    HlhtMjzcfZycfService hlhtMjzcfZycfService;

    @Autowired
    HlhtRyjlJbxxService hlhtRyjlJbxxService;

    @Autowired
    HlhtRyjlRcyjlService hlhtRyjlRcyjlService;

    @Autowired
    HlhtRyjlRyswjlService hlhtRyjlRyswjlService;

    @Autowired
    HlhtZcjlPgcService hlhtZcjlPgcService;

    @Autowired
    HlhtZcjlYdfmService hlhtZcjlYdfmService;

    @Autowired
    HlhtZlczjlMzshfsjlService hlhtZlczjlMzshfsjlService;

    @Autowired
    HlhtZlczjlMzsqfsjlService hlhtZlczjlMzsqfsjlService;

    @Autowired
    HlhtZlczjlSxjlService hlhtZlczjlSxjlService;

    @Autowired
    HlhtZlczjlYbssjlService hlhtZlczjlYbssjlService;

    @Autowired
    HlhtZlczjlZljlService hlhtZlczjlZljlService;

    @Autowired
    HlhtZqgzxxBwztzsService hlhtZqgzxxBwztzsService;

    @Autowired
    HlhtZqgzxxMzzqtysService hlhtZqgzxxMzzqtysService;

    @Autowired
    HlhtZqgzxxQtzqtysService hlhtZqgzxxQtzqtysService;

    @Autowired
    HlhtZqgzxxSstysService hlhtZqgzxxSstysService;

    @Autowired
    HlhtZqgzxxSxzltysService hlhtZqgzxxSxzltysService;

    @Autowired
    HlhtZqgzxxTsjczltysService hlhtZqgzxxTsjczltysService;

    @Autowired
    HlhtZybcjlCyjlService hlhtZybcjlCyjlService;

    @Autowired
    HlhtZybcjlHzjlService hlhtZybcjlHzjlService;

    @Autowired
    HlhtZybcjlJdxjService hlhtZybcjlJdxjService;

    @Autowired
    HlhtZybcjlJjbjlService hlhtZybcjlJjbjlService;

    @Autowired
    HlhtZybcjlQjjlService hlhtZybcjlQjjlService;

    @Autowired
    HlhtZybcjlRcbcjlService hlhtZybcjlRcbcjlService;

    @Autowired
    HlhtZybcjlScbcjlService hlhtZybcjlScbcjlService;

    @Autowired
    HlhtZybcjlShscbcjlService hlhtZybcjlShscbcjlService;

    @Autowired
    HlhtZybcjlSjyscfjlService hlhtZybcjlSjyscfjlService;

    @Autowired
    HlhtZybcjlSqtlService hlhtZybcjlSqtlService;

    @Autowired
    HlhtZybcjlSqxjService hlhtZybcjlSqxjService;

    @Autowired
    HlhtZybcjlSwbltljlService hlhtZybcjlSwbltljlService;

    @Autowired
    HlhtZybcjlSwjlService hlhtZybcjlSwjlService;

    @Autowired
    HlhtZybcjlYnbltljlService hlhtZybcjlYnbltljlService;

    @Autowired
    HlhtZybcjlZkjlService hlhtZybcjlZkjlService;

    @Autowired
    HlhtZzyjlZzyjlService hlhtZzyjlZzyjlService;

    @Autowired
    MbzDataErrorService mbzDataErrorService;

    @Override
    public EmrHzsqdjlkService getEmrHzsqdjlkService() {
        return emrHzsqdjlkService;
    }

    public HlhtBlgyJbjkxxService getHlhtBlgyJbjkxxService() {
        return hlhtBlgyJbjkxxService;
    }

    public HlhtBlgyWssjzyService getHlhtBlgyWssjzyService() {
        return hlhtBlgyWssjzyService;
    }

    public HlhtCyxjCyxjService getHlhtCyxjCyxjService() {
        return hlhtCyxjCyxjService;
    }

    public HlhtMjzblJzlgblService getHlhtMjzblJzlgblService() {
        return hlhtMjzblJzlgblService;
    }

    public HlhtMjzblMjzblService getHlhtMjzblMjzblService() {
        return hlhtMjzblMjzblService;
    }

    public HlhtMjzcfXycfService getHlhtMjzcfXycfService() {
        return hlhtMjzcfXycfService;
    }

    public HlhtMjzcfZycfService getHlhtMjzcfZycfService() {
        return hlhtMjzcfZycfService;
    }

    public HlhtRyjlJbxxService getHlhtRyjlJbxxService() {
        return hlhtRyjlJbxxService;
    }

    public HlhtRyjlRcyjlService getHlhtRyjlRcyjlService() {
        return hlhtRyjlRcyjlService;
    }

    public HlhtRyjlRyswjlService getHlhtRyjlRyswjlService() {
        return hlhtRyjlRyswjlService;
    }

    public HlhtZcjlPgcService getHlhtZcjlPgcService() {
        return hlhtZcjlPgcService;
    }

    public HlhtZcjlYdfmService getHlhtZcjlYdfmService() {
        return hlhtZcjlYdfmService;
    }

    public HlhtZlczjlMzshfsjlService getHlhtZlczjlMzshfsjlService() {
        return hlhtZlczjlMzshfsjlService;
    }

    public HlhtZlczjlMzsqfsjlService getHlhtZlczjlMzsqfsjlService() {
        return hlhtZlczjlMzsqfsjlService;
    }

    public HlhtZlczjlSxjlService getHlhtZlczjlSxjlService() {
        return hlhtZlczjlSxjlService;
    }

    public HlhtZlczjlYbssjlService getHlhtZlczjlYbssjlService() {
        return hlhtZlczjlYbssjlService;
    }

    public HlhtZlczjlZljlService getHlhtZlczjlZljlService() {
        return hlhtZlczjlZljlService;
    }

    public HlhtZqgzxxBwztzsService getHlhtZqgzxxBwztzsService() {
        return hlhtZqgzxxBwztzsService;
    }

    public HlhtZqgzxxMzzqtysService getHlhtZqgzxxMzzqtysService() {
        return hlhtZqgzxxMzzqtysService;
    }

    public HlhtZqgzxxQtzqtysService getHlhtZqgzxxQtzqtysService() {
        return hlhtZqgzxxQtzqtysService;
    }

    public HlhtZqgzxxSstysService getHlhtZqgzxxSstysService() {
        return hlhtZqgzxxSstysService;
    }

    public HlhtZqgzxxSxzltysService getHlhtZqgzxxSxzltysService() {
        return hlhtZqgzxxSxzltysService;
    }

    public HlhtZqgzxxTsjczltysService getHlhtZqgzxxTsjczltysService() {
        return hlhtZqgzxxTsjczltysService;
    }

    public HlhtZybcjlCyjlService getHlhtZybcjlCyjlService() {
        return hlhtZybcjlCyjlService;
    }

    public HlhtZybcjlHzjlService getHlhtZybcjlHzjlService() {
        return hlhtZybcjlHzjlService;
    }

    public HlhtZybcjlJdxjService getHlhtZybcjlJdxjService() {
        return hlhtZybcjlJdxjService;
    }

    public HlhtZybcjlJjbjlService getHlhtZybcjlJjbjlService() {
        return hlhtZybcjlJjbjlService;
    }

    public HlhtZybcjlQjjlService getHlhtZybcjlQjjlService() {
        return hlhtZybcjlQjjlService;
    }

    public HlhtZybcjlRcbcjlService getHlhtZybcjlRcbcjlService() {
        return hlhtZybcjlRcbcjlService;
    }

    public HlhtZybcjlScbcjlService getHlhtZybcjlScbcjlService() {
        return hlhtZybcjlScbcjlService;
    }

    public HlhtZybcjlShscbcjlService getHlhtZybcjlShscbcjlService() {
        return hlhtZybcjlShscbcjlService;
    }

    public HlhtZybcjlSjyscfjlService getHlhtZybcjlSjyscfjlService() {
        return hlhtZybcjlSjyscfjlService;
    }

    public HlhtZybcjlSqtlService getHlhtZybcjlSqtlService() {
        return hlhtZybcjlSqtlService;
    }

    public HlhtZybcjlSqxjService getHlhtZybcjlSqxjService() {
        return hlhtZybcjlSqxjService;
    }

    public HlhtZybcjlSwbltljlService getHlhtZybcjlSwbltljlService() {
        return hlhtZybcjlSwbltljlService;
    }

    public HlhtZybcjlSwjlService getHlhtZybcjlSwjlService() {
        return hlhtZybcjlSwjlService;
    }

    public HlhtZybcjlYnbltljlService getHlhtZybcjlYnbltljlService() {
        return hlhtZybcjlYnbltljlService;
    }

    public HlhtZybcjlZkjlService getHlhtZybcjlZkjlService() {
        return hlhtZybcjlZkjlService;
    }

    public HlhtZzyjlZzyjlService getHlhtZzyjlZzyjlService() {
        return hlhtZzyjlZzyjlService;
    }


    public EmrQtbljlkService getEmrQtbljlkService() {
        return emrQtbljlkService;
    }


    public EmrMxmcmlkService getEmrMxmcmlkService() {
        return emrMxmcmlkService;
    }

    public EmrMbkService getEmrMbkService() {
        return emrMbkService;
    }


    public MbzAutomateSetService getMbzAutomateSetService() {
        return mbzAutomateSetService;
    }

    public MbzDatabasesListService getMbzDatabasesListService() {
        return mbzDatabasesListService;
    }

    public MbzDataCheckService getMbzDataCheckService() {
        return mbzDataCheckService;
    }

    public MbzDataListSetService getMbzDataListSetService() {
        return mbzDataListSetService;
    }

    public MbzDictInfoService getMbzDictInfoService() {
        return mbzDictInfoService;
    }

    public MbzLogService getMbzLogService() {
        return mbzLogService;
    }

    public MbzModelCheckService getMbzModelCheckService() {
        return mbzModelCheckService;
    }

    public MbzDataTemplateConfigService getMbzDataTemplateConfigService() {
        return mbzDataTemplateConfigService;
    }

    public MbzDataSetService getMbzDataSetService() {
        return mbzDataSetService;
    }

    public MbzDataErrorService getMbzDataErrorService() {
        return mbzDataErrorService;
    }

    @Autowired
    OutpJzjlkService outpJzjlkService;

    @Autowired
    OutpOrderService outpOrderService;

    @Autowired
    OutpOrderitemService outpOrderitemService;


    public OutpJzjlkService getOutpJzjlkService(){
        return outpJzjlkService;
    }

    public OutpOrderService getOutpOrderService(){
        return outpOrderService;
    }

    public OutpOrderitemService getOutpOrderitemService(){
        return outpOrderitemService;
    }

    @Autowired
    EmrMbmxkService emrMbmxkService;

    public EmrMbmxkService getEmrMbmxkService(){
        return emrMbmxkService;
    }
    @Autowired
    MbzDataColumnService mbzDataColumnService;

    public MbzDataColumnService getMbzDataColumnService(){
        return mbzDataColumnService;
    }

    @Autowired
    MbzLoadDataInfoService mbzLoadDataInfoService;

    public MbzLoadDataInfoService getMbzLoadDataInfoService(){
        return mbzLoadDataInfoService;
    }

    @Autowired
    MbzTemplateNodeDetailInfoService mbzTemplateNodeDetailInfoService;

    public MbzTemplateNodeDetailInfoService getMbzTemplateNodeDetailInfoService(){
        return mbzTemplateNodeDetailInfoService;
    }
}