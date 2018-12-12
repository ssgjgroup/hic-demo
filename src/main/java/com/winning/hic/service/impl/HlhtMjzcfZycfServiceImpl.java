package com.winning.hic.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.model.*;
import com.winning.hic.service.MbzDictInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.base.utils.PercentUtil;
import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtMjzcfZycfDao;
import com.winning.hic.service.HlhtMjzcfZycfService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_MJZCF_ZYCF
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-30-31 16:30:02
 */
@Service
public class HlhtMjzcfZycfServiceImpl implements HlhtMjzcfZycfService {
    private final Logger logger = LoggerFactory.getLogger(HlhtMjzcfZycfServiceImpl.class);

    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private EmrQtbljlkDao emrQtbljlkDao;
    @Autowired
    private HlhtMjzcfZycfDao hlhtMjzcfZycfDao;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtMjzcfZycf(HlhtMjzcfZycf hlhtMjzcfZycf) {
        return this.hlhtMjzcfZycfDao.insertHlhtMjzcfZycf(hlhtMjzcfZycf);
    }

    public int modifyHlhtMjzcfZycf(HlhtMjzcfZycf hlhtMjzcfZycf) {
        return this.hlhtMjzcfZycfDao.updateHlhtMjzcfZycf(hlhtMjzcfZycf);
    }

    public int removeHlhtMjzcfZycf(HlhtMjzcfZycf hlhtMjzcfZycf) {
        return this.hlhtMjzcfZycfDao.deleteHlhtMjzcfZycf(hlhtMjzcfZycf);
    }

    public HlhtMjzcfZycf getHlhtMjzcfZycf(HlhtMjzcfZycf hlhtMjzcfZycf) {
        return this.hlhtMjzcfZycfDao.selectHlhtMjzcfZycf(hlhtMjzcfZycf);
    }

    public int getHlhtMjzcfZycfCount(HlhtMjzcfZycf hlhtMjzcfZycf) {
        return (Integer) this.hlhtMjzcfZycfDao.selectHlhtMjzcfZycfCount(hlhtMjzcfZycf);
    }

    public List<HlhtMjzcfZycf> getHlhtMjzcfZycfList(HlhtMjzcfZycf hlhtMjzcfZycf) {
        return this.hlhtMjzcfZycfDao.selectHlhtMjzcfZycfList(hlhtMjzcfZycf);
    }

    public List<HlhtMjzcfZycf> getHlhtMjzcfZycfPageList(HlhtMjzcfZycf hlhtMjzcfZycf) {
        return this.hlhtMjzcfZycfDao.selectHlhtMjzcfZycfPageList(hlhtMjzcfZycf);
    }

    @Override
    public List<HlhtMjzcfZycf> getHlhtMjzcfZycfListFromBaseData(EmrQtbljlk emrQtbljlk) throws DataAccessException {
        return this.commonQueryDao.getHlhtMjzcfZycfListFromBaseData(emrQtbljlk);
    }

    @Override
    public void deleteHlhtMjzcfZycfByYjlxh(HlhtMjzcfZycf hlhtMjzcfZycf) {
        this.hlhtMjzcfZycfDao.deleteHlhtMjzcfZycfByYjlxh(hlhtMjzcfZycf);
    }

    @Override
    public MbzDataCheck interfaceHlhtMjzcfZycf(MbzDataCheck entity) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_MJZCF_ZYCF_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量        //实际数量
        String startDate = (String) entity.getMap().get("startDate");
        startDate = startDate.replaceAll("-", "");
        startDate = startDate.replaceAll(" ", "");
        String endDate = (String) entity.getMap().get("endDate");
        endDate = endDate.replaceAll("-", "");
        endDate = endDate.replaceAll(" ", "");

        HlhtMjzcfZycf zycf = new HlhtMjzcfZycf();
        zycf.getMap().put("startDate", startDate);
        zycf.getMap().put("endDate", endDate);
        zycf.getMap().put("syxh", entity.getMap().get("syxh"));

        //日库
        List<HlhtMjzcfZycf> mjzcfZycfList = this.hlhtMjzcfZycfDao.selectHlhtMjzcfZycfListByProc(zycf);
        //年库
        List<HlhtMjzcfZycf> lsmjzcfZycfList = this.hlhtMjzcfZycfDao.selectHlhtMjzcfZycfListProcForYear(zycf);

        mjzcfZycfList.addAll(lsmjzcfZycfList);
        emr_count = mjzcfZycfList.size();
        if (mjzcfZycfList != null) {
            for (HlhtMjzcfZycf obj : mjzcfZycfList) {
                //清库
                HlhtMjzcfZycf temp = new HlhtMjzcfZycf();
                temp.setYjlxh(obj.getYjlxh());
                this.hlhtMjzcfZycfDao.deleteHlhtMjzcfZycfByYjlxh(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_MJZCF_ZYCF_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                logger.info("Model:{}", obj);
                try {
                    this.createHlhtMjzcfZycf(obj);
                } catch (Exception e) {
                    logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                    continue;
                }
                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_MJZCF_ZYCF_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), "中药处方", "NA", new Timestamp(obj.getCfklrq().getTime()),
                            obj.getPatid(), obj.getMjzh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            "NA", "NA", "NA", "NA", obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_MJZCF_ZYCF_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_MJZCF_ZYCF_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;
            }
        }
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_MJZCF_ZYCF_SOURCE_TYPE), entity);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}