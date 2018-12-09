package com.winning.hic.service.impl;

import com.winning.hic.base.Constants;
import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzDictInfoDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.*;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;
import com.winning.hic.service.MbzDictInfoService;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.dao.hdw.AmerZcjlDcjlDao;

import com.winning.hic.service.AmerZcjlDcjlService;  


/**
* @author HLHT
* @title AMER_ZCJL_DCJL
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-13-08 20:13:23
*/
@Service
public class AmerZcjlDcjlServiceImpl implements  AmerZcjlDcjlService {

    private static final Logger logger = LoggerFactory.getLogger(AmerZcjlDcjlServiceImpl.class);
    @Autowired
    private AmerZcjlDcjlDao amerZcjlDcjlDao;
    @Autowired
    private MbzDataSetService mbzDataSetService;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDictInfoDao mbzDictInfoDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl){
        return this.amerZcjlDcjlDao.insertAmerZcjlDcjl(amerZcjlDcjl);
    }

    public int modifyAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl){
        return this.amerZcjlDcjlDao.updateAmerZcjlDcjl(amerZcjlDcjl);
    }

    public int removeAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl){
        return this.amerZcjlDcjlDao.deleteAmerZcjlDcjl(amerZcjlDcjl);
    }

    public AmerZcjlDcjl getAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl){
        return this.amerZcjlDcjlDao.selectAmerZcjlDcjl(amerZcjlDcjl);
    }

    public int getAmerZcjlDcjlCount(AmerZcjlDcjl amerZcjlDcjl){
        return (Integer)this.amerZcjlDcjlDao.selectAmerZcjlDcjlCount(amerZcjlDcjl);
    }

    public List<AmerZcjlDcjl> getAmerZcjlDcjlList(AmerZcjlDcjl amerZcjlDcjl){
        return this.amerZcjlDcjlDao.selectAmerZcjlDcjlList(amerZcjlDcjl);
    }

    public List<AmerZcjlDcjl> getAmerZcjlDcjlPageList(AmerZcjlDcjl amerZcjlDcjl){
        return this.amerZcjlDcjlDao.selectAmerZcjlDcjlPageList(amerZcjlDcjl);
    }

    @Override
    public MbzDataCheck interfaceAmerZcjlDcjl(MbzDataCheck entity) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZCJL_DCJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录
        //MbzDataCheck mbzDataCheck = new MbzDataCheck();
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量
        //实际数量
        //配置接口表字段配置信息
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZCJL_DCJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZCJL_DCJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

        mbzDataSet = new MbzDataSet();
        mbzDataSet.setPId(0L);
        mbzDataSet.setSourceType(Constants.WN_ZCJL_DCJL_SOURCE_TYPE);
        mbzDataSet = mbzDataSetService.getMbzDataSet(mbzDataSet);


        //获取接口对象字段集合信息
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtRyjlRcyjl.class);

        AmerZcjlDcjl hlht = new AmerZcjlDcjl();
        hlht.getMap().put("sourceType", Constants.WN_ZCJL_DCJL_SOURCE_TYPE);
        hlht.getMap().put("startDate", entity.getMap().get("startDate"));
        hlht.getMap().put("endDate", entity.getMap().get("endDate"));
        hlht.getMap().put("syxh", entity.getMap().get("syxh"));
        hlht.getMap().put("yljgdm", entity.getMap().get("yljgdm"));
        hlht.getMap().put("regex", entity.getMap().get("regex"));
        List<AmerZcjlDcjl> anmrZcjlDcjlList = this.amerZcjlDcjlDao.selectAmerZcjlDcjlListByProc(hlht);

        if (anmrZcjlDcjlList != null && anmrZcjlDcjlList.size() > 0) {
            emr_count = emr_count + anmrZcjlDcjlList.size();
            for (AmerZcjlDcjl obj : anmrZcjlDcjlList) {
                //获取接口数据
                AmerZcjlDcjl oldObj = new AmerZcjlDcjl();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getAmerZcjlDcjl(oldObj);
                //解析病历xml
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    // e.printStackTrace();
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                //System.out.println(Base64Utils.unzipEmrXml(emrQtbljlk.getBlnr()));
                //判断是否存在重复,存在则删除，重新新增
                if (oldObj != null) {
                    //初始化数据
                    AmerZcjlDcjl oldRcyjl = new AmerZcjlDcjl();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeAmerZcjlDcjl(oldRcyjl);
                    //清除日志
                    Map<String, Object> param = new HashMap<>();
                    param.put("SOURCE_ID", obj.getYjlxh());
                    param.put("SOURCE_TYPE", Constants.WN_RYJL_RCYJL_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (AmerZcjlDcjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);


                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZCJL_DCJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createAmerZcjlDcjl(obj);
                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZCJL_DCJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "", obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getCfxm(), "2", "女",
                            "NA", "NA", "NA", "NA", obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZCJL_DCJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZCJL_DCJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;
            }

        } else {
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集", mbzDataSet.getRecordName());
        }
        splitTableDao.selectAmerZcjlDcjlSplitByProc(hlht);
        entity.getMap().put("sourceType",Constants.WN_ZCJL_DCJL_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(entity);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZCJL_DCJL_SOURCE_TYPE), entity);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}