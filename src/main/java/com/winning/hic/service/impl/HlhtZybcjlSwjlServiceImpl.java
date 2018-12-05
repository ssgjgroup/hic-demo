package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.*;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.service.MbzDictInfoService;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;

import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzDictInfoDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZybcjlSwjlDao;
import com.winning.hic.model.EmrQtbljlk;
import com.winning.hic.model.HlhtZybcjlSwjl;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzDictInfo;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtZybcjlSwjlService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_SWJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-34-31 16:34:47
 */
@Service
public class HlhtZybcjlSwjlServiceImpl implements HlhtZybcjlSwjlService {
    private static final Logger logger = LoggerFactory.getLogger(HlhtZybcjlSwjlServiceImpl.class);

    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private MbzDictInfoDao mbzDictInfoDao;
    @Autowired
    private HlhtZybcjlSwjlDao hlhtZybcjlSwjlDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtZybcjlSwjl(HlhtZybcjlSwjl hlhtZybcjlSwjl) {
        return this.hlhtZybcjlSwjlDao.insertHlhtZybcjlSwjl(hlhtZybcjlSwjl);
    }

    public int modifyHlhtZybcjlSwjl(HlhtZybcjlSwjl hlhtZybcjlSwjl) {
        return this.hlhtZybcjlSwjlDao.updateHlhtZybcjlSwjl(hlhtZybcjlSwjl);
    }

    public int removeHlhtZybcjlSwjl(HlhtZybcjlSwjl hlhtZybcjlSwjl) {
        return this.hlhtZybcjlSwjlDao.deleteHlhtZybcjlSwjl(hlhtZybcjlSwjl);
    }

    public HlhtZybcjlSwjl getHlhtZybcjlSwjl(HlhtZybcjlSwjl hlhtZybcjlSwjl) {
        return this.hlhtZybcjlSwjlDao.selectHlhtZybcjlSwjl(hlhtZybcjlSwjl);
    }

    public int getHlhtZybcjlSwjlCount(HlhtZybcjlSwjl hlhtZybcjlSwjl) {
        return (Integer) this.hlhtZybcjlSwjlDao.selectHlhtZybcjlSwjlCount(hlhtZybcjlSwjl);
    }

    public List<HlhtZybcjlSwjl> getHlhtZybcjlSwjlList(HlhtZybcjlSwjl hlhtZybcjlSwjl) {
        return this.hlhtZybcjlSwjlDao.selectHlhtZybcjlSwjlList(hlhtZybcjlSwjl);
    }

    public List<HlhtZybcjlSwjl> getHlhtZybcjlSwjlPageList(HlhtZybcjlSwjl hlhtZybcjlSwjl) {
        return this.hlhtZybcjlSwjlDao.selectHlhtZybcjlSwjlPageList(hlhtZybcjlSwjl);
    }

    @Override
    public List<HlhtZybcjlSwjl> getHlhtZybcjlSwjlListFromBaseData(EmrQtbljlk emrQtbljlk) throws DataAccessException {
        MbzDictInfo nameTemp = new MbzDictInfo();
        nameTemp.setDictCode("hospitalInfoName");
        nameTemp.setDictValue("1");
        nameTemp = this.mbzDictInfoDao.selectMbzDictInfo(nameTemp);
        MbzDictInfo codeTemp = new MbzDictInfo();
        codeTemp.setDictCode("hospitalInfoNo");
        codeTemp.setDictValue("1");
        codeTemp = this.mbzDictInfoDao.selectMbzDictInfo(codeTemp);
        emrQtbljlk.getMap().put("zzjgdm", codeTemp.getDictLabel());
        emrQtbljlk.getMap().put("zzjgmc", nameTemp.getDictLabel());
        return this.commonQueryDao.getHlhtZybcjlSwjlListFromBaseData(emrQtbljlk);
    }

    @Override
    public void deleteHlhtZybcjlSwjlByYjlxh(HlhtZybcjlSwjl hlhtZybcjlSwjl) {

    }

    @Override
    public MbzDataCheck interfaceHlhtZybcjlSwjl(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = this.mbzDataSetDao.selectMbzDataSetList(mbzDataSet);
        HlhtZybcjlSwjl hlhtZybcjlSwjlTemp = new HlhtZybcjlSwjl();
        hlhtZybcjlSwjlTemp.getMap().put("sourceType", Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE);
        hlhtZybcjlSwjlTemp.getMap().put("startDate", t.getMap().get("startDate"));
        hlhtZybcjlSwjlTemp.getMap().put("endDate", t.getMap().get("endDate"));
        hlhtZybcjlSwjlTemp.getMap().put("syxh", t.getMap().get("syxh"));
        hlhtZybcjlSwjlTemp.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        hlhtZybcjlSwjlTemp.getMap().put("regex", t.getMap().get("regex"));
        //2.根据模板代码去找到对应的病人病历
        List<HlhtZybcjlSwjl> hlhtZybcjlSwjlList = this.hlhtZybcjlSwjlDao.selectHlhtZybcjlSwjlListByProc(hlhtZybcjlSwjlTemp);
        if (hlhtZybcjlSwjlList != null) {
            emr_count = emr_count + hlhtZybcjlSwjlList.size();
            for (HlhtZybcjlSwjl obj : hlhtZybcjlSwjlList) {
                //清库
                HlhtZybcjlSwjl temp = new HlhtZybcjlSwjl();
                temp.setYjlxh(obj.getYjlxh());
                this.hlhtZybcjlSwjlDao.deleteHlhtZybcjlSwjlByYjlxh(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlSwjl.class);
                obj = (HlhtZybcjlSwjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                logger.info("Model:{}", obj);
                obj.setRyzdbm(obj.getRyzdbm() == null ? "NA" : obj.getRyzdbm().replace("西医诊断：", "").trim());
                obj.setRyzdbm(obj.getRyzdbm() == null ? "NA" : obj.getRyzdbm().replace("中医诊断：", "").trim());
                obj.setRyzdmc(obj.getRyzdmc() == null ? "NA" : obj.getRyzdmc().replace("西医诊断：", "").trim());
                obj.setRyzdmc(obj.getRyzdmc() == null ? "NA" : obj.getRyzdmc().replace("中医诊断：", "").trim());
                obj.setSwzdbm(obj.getSwzdbm() == null ? "NA" : obj.getSwzdbm().replace("西医诊断：", "").trim());
                obj.setSwzdbm(obj.getSwzdbm() == null ? "NA" : obj.getSwzdbm().replace("中医诊断：", "").trim());
                obj.setSwzdmc(obj.getSwzdmc() == null ? "NA" : obj.getSwzdmc().replace("西医诊断：", "").trim());
                obj.setSwzdmc(obj.getSwzdmc() == null ? "NA" : obj.getSwzdmc().replace("中医诊断：", "").trim());
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_SWJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.hlhtZybcjlSwjlDao.insertHlhtZybcjlSwjl(obj);
                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;

            }
        }
        this.splitTableDao.selectAnmrZybcjlSwjlSplitByProc(hlhtZybcjlSwjlTemp);

        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZYBCJL_SWJL_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }


}