package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.*;
import com.winning.hic.service.MbzDictInfoService;
import com.winning.hic.service.MbzLogService;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.base.utils.Base64Utils;
import com.winning.hic.base.utils.HicHelper;
import com.winning.hic.base.utils.PercentUtil;
import com.winning.hic.base.utils.ReflectUtil;
import com.winning.hic.base.utils.XmlUtil;

import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZqgzxxMzzqtysDao;
import com.winning.hic.service.HlhtZqgzxxMzzqtysService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZQGZXX_MZZQTYS
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-32-31 16:32:23
 */
@Service
public class HlhtZqgzxxMzzqtysServiceImpl implements HlhtZqgzxxMzzqtysService {
    private final Logger logger = LoggerFactory.getLogger(HlhtZqgzxxMzzqtysServiceImpl.class);
    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;

    @Autowired
    private HlhtZqgzxxMzzqtysDao hlhtZqgzxxMzzqtysDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;
    @Autowired
    private MbzLogService mbzLogService;

    public int createHlhtZqgzxxMzzqtys(HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtys) {
        return this.hlhtZqgzxxMzzqtysDao.insertHlhtZqgzxxMzzqtys(hlhtZqgzxxMzzqtys);
    }

    public int modifyHlhtZqgzxxMzzqtys(HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtys) {
        return this.hlhtZqgzxxMzzqtysDao.updateHlhtZqgzxxMzzqtys(hlhtZqgzxxMzzqtys);
    }

    public int removeHlhtZqgzxxMzzqtys(HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtys) {
        return this.hlhtZqgzxxMzzqtysDao.deleteHlhtZqgzxxMzzqtys(hlhtZqgzxxMzzqtys);
    }

    public HlhtZqgzxxMzzqtys getHlhtZqgzxxMzzqtys(HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtys) {
        return this.hlhtZqgzxxMzzqtysDao.selectHlhtZqgzxxMzzqtys(hlhtZqgzxxMzzqtys);
    }

    public int getHlhtZqgzxxMzzqtysCount(HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtys) {
        return (Integer) this.hlhtZqgzxxMzzqtysDao.selectHlhtZqgzxxMzzqtysCount(hlhtZqgzxxMzzqtys);
    }

    public List<HlhtZqgzxxMzzqtys> getHlhtZqgzxxMzzqtysList(HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtys) {
        return this.hlhtZqgzxxMzzqtysDao.selectHlhtZqgzxxMzzqtysList(hlhtZqgzxxMzzqtys);
    }

    public List<HlhtZqgzxxMzzqtys> getHlhtZqgzxxMzzqtysPageList(HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtys) {
        return this.hlhtZqgzxxMzzqtysDao.selectHlhtZqgzxxMzzqtysPageList(hlhtZqgzxxMzzqtys);
    }

    @Override
    public List<HlhtZqgzxxMzzqtys> getHlhtZqgzxxMzzqtysListFromBaseData(EmrQtbljlk emrQtbljlk) throws DataAccessException {
        return this.commonQueryDao.getHlhtZqgzxxMzzqtysListFromBaseData(emrQtbljlk);
    }

    @Override
    public void deleteHlhtZqgzxxMzzqtysByYjlxh(HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtys) {
        this.deleteHlhtZqgzxxMzzqtysByYjlxh(hlhtZqgzxxMzzqtys);
    }

    @Override
    public MbzDataCheck interfaceHlhtZqgzxxMzzqtys(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = this.mbzDataSetDao.selectMbzDataSetList(mbzDataSet);
        HlhtZqgzxxMzzqtys hlhtZqgzxxMzzqtysTemp = new HlhtZqgzxxMzzqtys();
        hlhtZqgzxxMzzqtysTemp.getMap().put("sourceType", Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE);
        hlhtZqgzxxMzzqtysTemp.getMap().put("startDate", t.getMap().get("startDate"));
        hlhtZqgzxxMzzqtysTemp.getMap().put("endDate", t.getMap().get("endDate"));
        hlhtZqgzxxMzzqtysTemp.getMap().put("syxh", t.getMap().get("syxh"));
        hlhtZqgzxxMzzqtysTemp.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        hlhtZqgzxxMzzqtysTemp.getMap().put("regex", t.getMap().get("regex"));
        //2.根据模板代码去找到对应的病人病历
        List<HlhtZqgzxxMzzqtys> hlhtZqgzxxMzzqtysList = this.hlhtZqgzxxMzzqtysDao.selectHlhtZqgzxxMzzqtysListByProc(hlhtZqgzxxMzzqtysTemp);

        if (hlhtZqgzxxMzzqtysList != null) {
            emr_count = emr_count + hlhtZqgzxxMzzqtysList.size();
            for (HlhtZqgzxxMzzqtys obj : hlhtZqgzxxMzzqtysList) {
                //清库
                HlhtZqgzxxMzzqtys temp = new HlhtZqgzxxMzzqtys();
                temp.setYjlxh(obj.getYjlxh());
                this.hlhtZqgzxxMzzqtysDao.deleteHlhtZqgzxxMzzqtysByYjlxh(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE +"||"+getClass().toString()+"||"+"解析病历报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }
                Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZqgzxxMzzqtys.class);
                obj = (HlhtZqgzxxMzzqtys) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                logger.info("Model:{}", obj);
                //this.createHlhtZqgzxxMzzqtys(obj);
                try {
                    this.createHlhtZqgzxxMzzqtys(obj);
                } catch (Exception e) {
                    logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                    continue;
                }
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE +"||"+getClass().toString()+"||"+"病历百分比计算报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }
                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZqgzxxMzzqtysSplitByProc(hlhtZqgzxxMzzqtysTemp);

        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZQGZXX_MZZQTYS_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}