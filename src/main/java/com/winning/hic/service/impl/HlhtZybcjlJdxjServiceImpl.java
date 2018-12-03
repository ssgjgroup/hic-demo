package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.*;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.*;
import com.winning.hic.service.MbzDictInfoService;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.HlhtZybcjlJdxjDao;
import com.winning.hic.service.HlhtZybcjlJdxjService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_JDXJ
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-33-31 16:33:32
 */
@Service
public class HlhtZybcjlJdxjServiceImpl implements HlhtZybcjlJdxjService {
    private final Logger logger = LoggerFactory.getLogger(HlhtZybcjlJdxjServiceImpl.class);

    @Autowired
    private HlhtZybcjlJdxjDao hlhtZybcjlJdxjDao;

    @Autowired
    private MbzDataSetService mbzDataSetService;

    @Autowired
    private SplitTableDao splitTableDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtZybcjlJdxj(HlhtZybcjlJdxj hlhtZybcjlJdxj) {
        return this.hlhtZybcjlJdxjDao.insertHlhtZybcjlJdxj(hlhtZybcjlJdxj);
    }

    public int modifyHlhtZybcjlJdxj(HlhtZybcjlJdxj hlhtZybcjlJdxj) {
        return this.hlhtZybcjlJdxjDao.updateHlhtZybcjlJdxj(hlhtZybcjlJdxj);
    }

    public int removeHlhtZybcjlJdxj(HlhtZybcjlJdxj hlhtZybcjlJdxj) {
        return this.hlhtZybcjlJdxjDao.deleteHlhtZybcjlJdxj(hlhtZybcjlJdxj);
    }

    public HlhtZybcjlJdxj getHlhtZybcjlJdxj(HlhtZybcjlJdxj hlhtZybcjlJdxj) {
        return this.hlhtZybcjlJdxjDao.selectHlhtZybcjlJdxj(hlhtZybcjlJdxj);
    }

    public int getHlhtZybcjlJdxjCount(HlhtZybcjlJdxj hlhtZybcjlJdxj) {
        return (Integer) this.hlhtZybcjlJdxjDao.selectHlhtZybcjlJdxjCount(hlhtZybcjlJdxj);
    }

    public List<HlhtZybcjlJdxj> getHlhtZybcjlJdxjList(HlhtZybcjlJdxj hlhtZybcjlJdxj) {
        return this.hlhtZybcjlJdxjDao.selectHlhtZybcjlJdxjList(hlhtZybcjlJdxj);
    }

    public List<HlhtZybcjlJdxj> getHlhtZybcjlJdxjPageList(HlhtZybcjlJdxj hlhtZybcjlJdxj) {
        return this.hlhtZybcjlJdxjDao.selectHlhtZybcjlJdxjPageList(hlhtZybcjlJdxj);
    }

    public HlhtZybcjlJdxj getInitialHlhtZybcjlJdxj(HlhtZybcjlJdxj t) {
        return this.hlhtZybcjlJdxjDao.selectInitialHlhtZybcjlJdxj(t);
    }

    @Override
    public MbzDataCheck
    interfaceHlhtZybcjlJdxj(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }

        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量        //实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

        HlhtZybcjlJdxj jdxj = new HlhtZybcjlJdxj();
        jdxj.getMap().put("sourceType", Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE);
        jdxj.getMap().put("startDate", t.getMap().get("startDate"));
        jdxj.getMap().put("endDate", t.getMap().get("endDate"));
        jdxj.getMap().put("syxh", t.getMap().get("syxh"));
        jdxj.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        jdxj.getMap().put("regex", t.getMap().get("regex"));

        List<HlhtZybcjlJdxj> hlhtZybcjlJdxjs = this.hlhtZybcjlJdxjDao.selectHlhtZybcjlJdxjListByProc(jdxj);

        if (hlhtZybcjlJdxjs != null) {
            emr_count = emr_count + hlhtZybcjlJdxjs.size();
            for (HlhtZybcjlJdxj obj : hlhtZybcjlJdxjs) {
                //清库
                HlhtZybcjlJdxj temp = new HlhtZybcjlJdxj();
                temp.setYjlxh(obj.getYjlxh());
                this.removeHlhtZybcjlJdxj(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlJdxj.class);
                obj = (HlhtZybcjlJdxj) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                logger.info("Model:{}", obj);
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_JDXJ), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtZybcjlJdxj(obj);
                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    //e.printStackTrace();
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZybcjlJdxjSplitByProc(jdxj);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZYBCJL_JDXJ_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }

}