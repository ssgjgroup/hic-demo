package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.*;

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
import com.winning.hic.dao.cmdatacenter.MbzDictInfoDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.HlhtCommonQueryDao;
import com.winning.hic.dao.hdw.HlhtMjzblJzlgblDao;
import com.winning.hic.model.EmrQtbljlk;
import com.winning.hic.model.HlhtMjzblJzlgbl;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzDictInfo;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtMjzblJzlgblService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_MJZBL_JZLGBL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-29-31 16:29:33
 */
@Service
public class HlhtMjzblJzlgblServiceImpl implements HlhtMjzblJzlgblService {

    private static final Logger logger = LoggerFactory.getLogger(HlhtMjzblJzlgblServiceImpl.class);
    @Autowired
    private HlhtMjzblJzlgblDao hlhtMjzblJzlgblDao;
    @Autowired
    private HlhtCommonQueryDao hlhtCommonQueryDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDictInfoDao mbzDictInfoDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    public int createHlhtMjzblJzlgbl(HlhtMjzblJzlgbl hlhtMjzblJzlgbl) {
        return this.hlhtMjzblJzlgblDao.insertHlhtMjzblJzlgbl(hlhtMjzblJzlgbl);
    }

    public int modifyHlhtMjzblJzlgbl(HlhtMjzblJzlgbl hlhtMjzblJzlgbl) {
        return this.hlhtMjzblJzlgblDao.updateHlhtMjzblJzlgbl(hlhtMjzblJzlgbl);
    }

    public int removeHlhtMjzblJzlgbl(HlhtMjzblJzlgbl hlhtMjzblJzlgbl) {
        return this.hlhtMjzblJzlgblDao.deleteHlhtMjzblJzlgbl(hlhtMjzblJzlgbl);
    }

    public HlhtMjzblJzlgbl getHlhtMjzblJzlgbl(HlhtMjzblJzlgbl hlhtMjzblJzlgbl) {
        return this.hlhtMjzblJzlgblDao.selectHlhtMjzblJzlgbl(hlhtMjzblJzlgbl);
    }

    public int getHlhtMjzblJzlgblCount(HlhtMjzblJzlgbl hlhtMjzblJzlgbl) {
        return (Integer) this.hlhtMjzblJzlgblDao.selectHlhtMjzblJzlgblCount(hlhtMjzblJzlgbl);
    }

    public List<HlhtMjzblJzlgbl> getHlhtMjzblJzlgblList(HlhtMjzblJzlgbl hlhtMjzblJzlgbl) {
        return this.hlhtMjzblJzlgblDao.selectHlhtMjzblJzlgblList(hlhtMjzblJzlgbl);
    }

    public List<HlhtMjzblJzlgbl> getHlhtMjzblJzlgblPageList(HlhtMjzblJzlgbl hlhtMjzblJzlgbl) {
        return this.hlhtMjzblJzlgblDao.selectHlhtMjzblJzlgblPageList(hlhtMjzblJzlgbl);
    }

    @Override
    public MbzDataCheck interfaceHlhtMjzblJzlgbl(MbzDataCheck entity){

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量         //实际数量

        MbzDictInfo nameDict = new MbzDictInfo();
        nameDict.setDictCode("hospitalInfoName");
        nameDict.setDictValue("1");
        nameDict = mbzDictInfoDao.selectMbzDictInfo(nameDict);
        MbzDictInfo codeDict = new MbzDictInfo();
        codeDict.setDictCode("hospitalInfoNo");
        codeDict.setDictValue("1");
        codeDict = mbzDictInfoDao.selectMbzDictInfo(codeDict);


        //配置接口表字段配置信息
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetDao.selectMbzDataSetList(mbzDataSet);

        //获取接口表名称
        mbzDataSet = new MbzDataSet();
        mbzDataSet.setPId(0L);
        mbzDataSet.setSourceType(Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE);
        mbzDataSet = mbzDataSetDao.selectMbzDataSet(mbzDataSet);

        //获取接口对象字段集合信息
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtMjzblJzlgbl.class);

        String[] bcCode = {"jzlgbcjl"};
        String[] syCode = {"hzqxdm", "hzqxmc"};
        List<MbzDataSet> bcDataSetList = new ArrayList<>();
        List<MbzDataSet> syDataSetList = new ArrayList<>();
        for (MbzDataSet dataSet : mbzDataSetList) {
            for (int i = 0; i < bcCode.length; i++) {
                if (bcCode[i].equals(dataSet.getPyCode())) {
                    bcDataSetList.add(dataSet);
                }
            }

            for (int i = 0; i < syCode.length; i++) {
                if (syCode[i].equals(dataSet.getPyCode())) {
                    syDataSetList.add(dataSet);
                }
            }
        }

        HlhtMjzblJzlgbl hlht = new HlhtMjzblJzlgbl();
        hlht.getMap().put("sourceType", Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE);
        hlht.getMap().put("startDate", entity.getMap().get("startDate"));
        hlht.getMap().put("endDate", entity.getMap().get("endDate"));
        hlht.getMap().put("syxh", entity.getMap().get("syxh"));
        hlht.getMap().put("yljgdm", entity.getMap().get("yljgdm"));
        hlht.getMap().put("regex", entity.getMap().get("regex"));

        List<HlhtMjzblJzlgbl> list = this.hlhtMjzblJzlgblDao.selectHlhtMjzblJzlgblListByProc(hlht);
        if (list != null && list.size() > 0) {
            emr_count = emr_count + list.size();
            for (HlhtMjzblJzlgbl obj : list) {
                //获取接口数据
                HlhtMjzblJzlgbl oldObj = new HlhtMjzblJzlgbl();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getHlhtMjzblJzlgbl(oldObj);
                //解析病历xml
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                   // e.printStackTrace();
                    logger.error("解析病历报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                    continue;
                }
                Document bcDocument = null;
                Document syDocument = null;
                //判断是否存在重复,存在则删除，重新新增
                if (oldObj != null) {
                    //初始化数据
                    HlhtMjzblJzlgbl oldRcyjl = new HlhtMjzblJzlgbl();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeHlhtMjzblJzlgbl(oldRcyjl);
                    //清除日志
                    Map<String, Object> param = new HashMap<>();
                    param.put("SOURCE_ID", obj.getYjlxh());
                    param.put("SOURCE_TYPE", Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (HlhtMjzblJzlgbl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);


                new ArrayList<>();
                Map<String, Object> param = new HashMap<>();
                param.put("syxh", obj.getSyxh());
                param.put("keyWord", "急诊留观病程记录");
                //病程记录
                List<EmrQtbljlk> bcEmrQtbljlks = this.hlhtCommonQueryDao.selectEmrQtbljlkListByProcForMZ(param);
                if (bcEmrQtbljlks.size() >= 1) {
                    try {
                        bcDocument = XmlUtil.getDocument(Base64Utils.unzipEmrXml(bcEmrQtbljlks.get(0).getBlnr()));
                    } catch (IOException e) {
                        //e.printStackTrace();
                        logger.error("解析病历报错,病历名称：{},源记录序号{}",  bcEmrQtbljlks.get(0).getBlmc(),bcEmrQtbljlks.get(0).getQtbljlxh());
                    }
                }
                if (bcDataSetList != null) {
                    obj = (HlhtMjzblJzlgbl) HicHelper.initModelValue(bcDataSetList, bcDocument, obj, paramTypeMap);
                }

                //留观首页
                param.put("syxh", obj.getSyxh());
                param.put("keyWord", "急诊留观病历首页");
                List<EmrQtbljlk> syEmrQtbljlks = this.hlhtCommonQueryDao.selectEmrQtbljlkListByProcForMZ(param);
                if (syEmrQtbljlks.size() >= 1) {
                    try {
                        syDocument = XmlUtil.getDocument(Base64Utils.unzipEmrXml(syEmrQtbljlks.get(0).getBlnr()));
                    } catch (IOException e) {
                        //e.printStackTrace();
                        logger.error("解析病历报错,病历名称：{},源记录序号{}",  syEmrQtbljlks.get(0).getBlmc(),syEmrQtbljlks.get(0).getQtbljlxh());
                    }
                }
                if (syDataSetList != null) {
                    obj = (HlhtMjzblJzlgbl) HicHelper.initModelValue(syDataSetList, syDocument, obj, paramTypeMap);
                }
                obj.setZzjgdm(codeDict.getDictLabel());
                obj.setZzjgmc(nameDict.getDictLabel());
                if (obj.getGms().contains("否认") || obj.getGms().contains("不详") || obj.getGms().contains("NA")) {
                    String value = "";
                    if (obj.getGms().contains("否认") || obj.getGms().contains("不详")) {
                        value = obj.getGms() + "药物过敏史";
                    } else {
                        value = "否认药物过敏史";
                    }
                    obj.setGms(value);
                    obj.setGmsbz("F");
                } else {
                    String value = obj.getGms() + "药物过敏史";
                    obj.setGms(value);
                    obj.setGmsbz("T");
                }
                String hzqx = obj.getHzqxmc();
                if (!"NA".equals(hzqx)) {
                    if (hzqx.startsWith("出观去向： ")) {
                        hzqx = hzqx.substring("出观去向： ".length());
                    }
                    hzqx = hzqx.replaceAll(" +", "");
                    Map<String, String> hzqxMap = StringUtil.resolveStringToMap(hzqx);
                    if (hzqxMap.size() > 0) {
                        StringBuilder code = new StringBuilder();
                        StringBuilder value = new StringBuilder();
                        for (String s : hzqxMap.keySet()) {
                            if (s.startsWith("1")) {
                                code.append(s.substring(1) + ",");
                                value.append(hzqxMap.get(s) + ",");
                            }
                        }
                        obj.setHzqxmc(value.toString().substring(0, value.length() - 1));
                        obj.setHzqxdm(code.toString().substring(0, code.length() - 1));
                    }
                }
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.MJZBL_JZLGB),SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtMjzblJzlgbl(obj);

                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), "NA", "NA", obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    //e.printStackTrace();
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                    continue;
                }
                real_count++;
            }
        } else {
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集", mbzDataSet.getRecordName());
        }
        this.splitTableDao.selectAnmrMjzblJzlgblSplitByProc(hlht);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_MJZBL_JZLGBL_SOURCE_TYPE), entity);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}