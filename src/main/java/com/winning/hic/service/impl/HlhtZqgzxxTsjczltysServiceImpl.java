package com.winning.hic.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.SplitTableDao;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.HlhtZqgzxxTsjczltysDao;
import com.winning.hic.model.HlhtZqgzxxTsjczltys;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtZqgzxxTsjczltysService;
import com.winning.hic.service.MbzDataCheckService;


/**
* @author HLHT
* @title HLHT_ZQGZXX_TSJCZLTYS 特殊检查及特殊治疗同意书
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-32-31 16:32:57
*/
@Service
public class HlhtZqgzxxTsjczltysServiceImpl implements  HlhtZqgzxxTsjczltysService {

    private static final Logger logger = LoggerFactory.getLogger(HlhtZqgzxxTsjczltysServiceImpl.class);
    @Autowired
    private HlhtZqgzxxTsjczltysDao hlhtZqgzxxTsjczltysDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;


    public int createHlhtZqgzxxTsjczltys(HlhtZqgzxxTsjczltys hlhtZqgzxxTsjczltys){
        return this.hlhtZqgzxxTsjczltysDao.insertHlhtZqgzxxTsjczltys(hlhtZqgzxxTsjczltys);
    }

    public int modifyHlhtZqgzxxTsjczltys(HlhtZqgzxxTsjczltys hlhtZqgzxxTsjczltys){
        return this.hlhtZqgzxxTsjczltysDao.updateHlhtZqgzxxTsjczltys(hlhtZqgzxxTsjczltys);
    }

    public int removeHlhtZqgzxxTsjczltys(HlhtZqgzxxTsjczltys hlhtZqgzxxTsjczltys){
        return this.hlhtZqgzxxTsjczltysDao.deleteHlhtZqgzxxTsjczltys(hlhtZqgzxxTsjczltys);
    }

    public HlhtZqgzxxTsjczltys getHlhtZqgzxxTsjczltys(HlhtZqgzxxTsjczltys hlhtZqgzxxTsjczltys){
        return this.hlhtZqgzxxTsjczltysDao.selectHlhtZqgzxxTsjczltys(hlhtZqgzxxTsjczltys);
    }

    public int getHlhtZqgzxxTsjczltysCount(HlhtZqgzxxTsjczltys hlhtZqgzxxTsjczltys){
        return (Integer)this.hlhtZqgzxxTsjczltysDao.selectHlhtZqgzxxTsjczltysCount(hlhtZqgzxxTsjczltys);
    }

    public List<HlhtZqgzxxTsjczltys> getHlhtZqgzxxTsjczltysList(HlhtZqgzxxTsjczltys hlhtZqgzxxTsjczltys){
        return this.hlhtZqgzxxTsjczltysDao.selectHlhtZqgzxxTsjczltysList(hlhtZqgzxxTsjczltys);
    }

    public List<HlhtZqgzxxTsjczltys> getHlhtZqgzxxTsjczltysPageList(HlhtZqgzxxTsjczltys hlhtZqgzxxTsjczltys){
        return this.hlhtZqgzxxTsjczltysDao.selectHlhtZqgzxxTsjczltysPageList(hlhtZqgzxxTsjczltys);
    }

    @Override
    public List<MbzDataCheck> interfaceHlhtZqgzxxTsjczltys(MbzDataCheck entity) throws Exception {
        List<MbzDataCheck> dataChecks = null;
        int emr_count =0;//病历数量
        int real_count=0;//实际数量
        //配置接口表字段配置信息
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetDao.selectMbzDataSetList(mbzDataSet);

        //获取接口表名称
        mbzDataSet = new MbzDataSet();
        mbzDataSet.setPId(0L);
        mbzDataSet.setSourceType(Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE);
        mbzDataSet = mbzDataSetDao.selectMbzDataSet(mbzDataSet);

        //获取接口对象字段集合信息
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZqgzxxTsjczltys.class);

        HlhtZqgzxxTsjczltys hlht = new HlhtZqgzxxTsjczltys();
        hlht.getMap().put("sourceType",Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE);
        hlht.getMap().put("startDate",entity.getMap().get("startDate"));
        hlht.getMap().put("endDate",entity.getMap().get("endDate"));
        hlht.getMap().put("syxh",entity.getMap().get("syxh"));
        hlht.getMap().put("yljgdm", entity.getMap().get("yljgdm"));
        hlht.getMap().put("regex", entity.getMap().get("regex"));

        List<HlhtZqgzxxTsjczltys> list = this.hlhtZqgzxxTsjczltysDao.selectHlhtZqgzxxTsjczltysListByProc(hlht);
        if(list != null && list.size() > 0) {
            emr_count = emr_count + list.size();
            for (HlhtZqgzxxTsjczltys obj : list) {
                //获取接口数据
                HlhtZqgzxxTsjczltys oldObj = new HlhtZqgzxxTsjczltys();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getHlhtZqgzxxTsjczltys(obj);
                //解析病历xml
                Document document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                //判断是否存在重复,存在则删除，重新新增
                if (oldObj != null) {
                    //初始化数据
                    HlhtZqgzxxTsjczltys oldRcyjl = new HlhtZqgzxxTsjczltys();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeHlhtZqgzxxTsjczltys(oldObj);

                    //清除日志
                    Map<String,Object> param = new HashMap<>();
                    param.put("SOURCE_ID",obj.getYjlxh());
                    param.put("SOURCE_TYPE",Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (HlhtZqgzxxTsjczltys) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                obj.setJczlxmmc(obj.getBlmc().replace("知情同意书",""));
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZQGZXX_TSJCZLTYS),SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtZqgzxxTsjczltys(obj);
                this.splitTableDao.selectAnmrZqgzxxTsjczltysSplitByProc(hlht);
                //插入日志
                mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                        Long.parseLong(Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE),
                        Long.parseLong(obj.getYjlxh()),obj.getBlmc(),obj.getSyxh()+"",
                        obj.getFssj(),
                        obj.getPatid(),obj.getZyh(),obj.getHzxm(),obj.getXbmc(),obj.getXbdm(),
                        obj.getKsmc(),obj.getKsdm(), obj.getBqmc(),obj.getBqdm(), obj.getSfzhm(),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE), obj, 1),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE), obj, 0)));
                real_count++;
            }

        }else{
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集",mbzDataSet.getRecordName());
        }
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count,real_count,Integer.parseInt(Constants.WN_ZQGZXX_TSJCZLTYS_SOURCE_TYPE),entity);


        return dataChecks;
    }
}