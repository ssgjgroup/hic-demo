package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.*;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.*;
import com.winning.hic.service.MbzDictInfoService;
import com.winning.hic.service.MbzLogService;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;

import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZqgzxxBwztzsDao;
import com.winning.hic.service.HlhtZqgzxxBwztzsService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZQGZXX_BWZTZS
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-32-31 16:32:15
 */
@Service
public class HlhtZqgzxxBwztzsServiceImpl implements HlhtZqgzxxBwztzsService {
    private final Logger logger = LoggerFactory.getLogger(HlhtZqgzxxBwztzsServiceImpl.class);

    @Autowired
    private CommonQueryDao commonQueryDao;

    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;

    @Autowired
    private HlhtZqgzxxBwztzsDao hlhtZqgzxxBwztzsDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;
    @Autowired
    private MbzLogService mbzLogService;
    public int createHlhtZqgzxxBwztzs(HlhtZqgzxxBwztzs hlhtZqgzxxBwztzs) {
        return this.hlhtZqgzxxBwztzsDao.insertHlhtZqgzxxBwztzs(hlhtZqgzxxBwztzs);
    }

    public int modifyHlhtZqgzxxBwztzs(HlhtZqgzxxBwztzs hlhtZqgzxxBwztzs) {
        return this.hlhtZqgzxxBwztzsDao.updateHlhtZqgzxxBwztzs(hlhtZqgzxxBwztzs);
    }

    public int removeHlhtZqgzxxBwztzs(HlhtZqgzxxBwztzs hlhtZqgzxxBwztzs) {
        return this.hlhtZqgzxxBwztzsDao.deleteHlhtZqgzxxBwztzs(hlhtZqgzxxBwztzs);
    }

    public HlhtZqgzxxBwztzs getHlhtZqgzxxBwztzs(HlhtZqgzxxBwztzs hlhtZqgzxxBwztzs) {
        return this.hlhtZqgzxxBwztzsDao.selectHlhtZqgzxxBwztzs(hlhtZqgzxxBwztzs);
    }

    public int getHlhtZqgzxxBwztzsCount(HlhtZqgzxxBwztzs hlhtZqgzxxBwztzs) {
        return (Integer) this.hlhtZqgzxxBwztzsDao.selectHlhtZqgzxxBwztzsCount(hlhtZqgzxxBwztzs);
    }

    public List<HlhtZqgzxxBwztzs> getHlhtZqgzxxBwztzsList(HlhtZqgzxxBwztzs hlhtZqgzxxBwztzs) {
        return this.hlhtZqgzxxBwztzsDao.selectHlhtZqgzxxBwztzsList(hlhtZqgzxxBwztzs);
    }

    public List<HlhtZqgzxxBwztzs> getHlhtZqgzxxBwztzsPageList(HlhtZqgzxxBwztzs hlhtZqgzxxBwztzs) {
        return this.hlhtZqgzxxBwztzsDao.selectHlhtZqgzxxBwztzsPageList(hlhtZqgzxxBwztzs);
    }

    public List<HlhtZqgzxxBwztzs> getHlhtZqgzxxBwztzsListFromBaseData(EmrQtbljlk emrQtbljlk) {
        return this.commonQueryDao.getHlhtZqgzxxBwztzsListFromBaseData(emrQtbljlk);
    }

    @Override
    public MbzDataCheck interfaceHlhtZqgzxxBwztzs(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = this.mbzDataSetDao.selectMbzDataSetList(mbzDataSet);
        HlhtZqgzxxBwztzs hlhtZqgzxxBwztzsTemp = new HlhtZqgzxxBwztzs();
        hlhtZqgzxxBwztzsTemp.getMap().put("sourceType", Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE);
        hlhtZqgzxxBwztzsTemp.getMap().put("startDate", t.getMap().get("startDate"));
        hlhtZqgzxxBwztzsTemp.getMap().put("endDate", t.getMap().get("endDate"));
        hlhtZqgzxxBwztzsTemp.getMap().put("syxh", t.getMap().get("syxh"));
        hlhtZqgzxxBwztzsTemp.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        hlhtZqgzxxBwztzsTemp.getMap().put("regex", t.getMap().get("regex"));

        //2.根据模板代码去找到对应的病人病历
        List<HlhtZqgzxxBwztzs> hlhtZqgzxxBwztzsList = this.hlhtZqgzxxBwztzsDao.selectHlhtZqgzxxBwztzsListByProc(hlhtZqgzxxBwztzsTemp);
        if (hlhtZqgzxxBwztzsList != null) {
            emr_count = emr_count + hlhtZqgzxxBwztzsList.size();
            for (HlhtZqgzxxBwztzs obj : hlhtZqgzxxBwztzsList) {
                //删除库中已存在数据
                HlhtZqgzxxBwztzs temp = new HlhtZqgzxxBwztzs();
                temp.setYjlxh(obj.getYjlxh());
                this.hlhtZqgzxxBwztzsDao.deleteHlhtZqgzxxBwztzsByYjlxh(temp);

                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE +"||"+getClass().toString()+"||"+"解析病历报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }
                Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZqgzxxBwztzs.class);
                obj = (HlhtZqgzxxBwztzs) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                logger.info("Model:{}", obj);
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZQGZXX_BWZTZS), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                //this.createHlhtZqgzxxBwztzs(obj);
                try {
                    this.createHlhtZqgzxxBwztzs(obj);
                } catch (Exception e) {
                    logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                    continue;
                }
                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE +"||"+getClass().toString()+"||"+"病历百分比计算报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }

                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZqgzxxBwztzsSplitByProc(hlhtZqgzxxBwztzsTemp);

        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZQGZXX_BWZTZS_SOURCE_TYPE), t);

        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }

    @Override
    public void deleteHlhtZqgzxxBwztzsByYjlxh(HlhtZqgzxxBwztzs hlhtZqgzxxBwztzs) {
        this.hlhtZqgzxxBwztzsDao.deleteHlhtZqgzxxBwztzsByYjlxh(hlhtZqgzxxBwztzs);
    }
}