package com.winning.hic.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.*;
import com.winning.hic.service.MbzDictInfoService;
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
import com.winning.hic.dao.hdw.HlhtZcjlYdfmDao;
import com.winning.hic.service.HlhtZcjlYdfmService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZCJL_YDFM
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-31-31 16:31:19
 */
@Service
public class HlhtZcjlYdfmServiceImpl implements HlhtZcjlYdfmService {
    private final Logger logger = LoggerFactory.getLogger(HlhtZcjlYdfmServiceImpl.class);

    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private HlhtZcjlYdfmDao hlhtZcjlYdfmDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtZcjlYdfm(HlhtZcjlYdfm hlhtZcjlYdfm) {
        return this.hlhtZcjlYdfmDao.insertHlhtZcjlYdfm(hlhtZcjlYdfm);
    }

    public int modifyHlhtZcjlYdfm(HlhtZcjlYdfm hlhtZcjlYdfm) {
        return this.hlhtZcjlYdfmDao.updateHlhtZcjlYdfm(hlhtZcjlYdfm);
    }

    public int removeHlhtZcjlYdfm(HlhtZcjlYdfm hlhtZcjlYdfm) {
        return this.hlhtZcjlYdfmDao.deleteHlhtZcjlYdfm(hlhtZcjlYdfm);
    }

    public HlhtZcjlYdfm getHlhtZcjlYdfm(HlhtZcjlYdfm hlhtZcjlYdfm) {
        return this.hlhtZcjlYdfmDao.selectHlhtZcjlYdfm(hlhtZcjlYdfm);
    }

    public int getHlhtZcjlYdfmCount(HlhtZcjlYdfm hlhtZcjlYdfm) {
        return (Integer) this.hlhtZcjlYdfmDao.selectHlhtZcjlYdfmCount(hlhtZcjlYdfm);
    }

    public List<HlhtZcjlYdfm> getHlhtZcjlYdfmList(HlhtZcjlYdfm hlhtZcjlYdfm) {
        return this.hlhtZcjlYdfmDao.selectHlhtZcjlYdfmList(hlhtZcjlYdfm);
    }

    public List<HlhtZcjlYdfm> getHlhtZcjlYdfmPageList(HlhtZcjlYdfm hlhtZcjlYdfm) {
        return this.hlhtZcjlYdfmDao.selectHlhtZcjlYdfmPageList(hlhtZcjlYdfm);
    }

    @Override
    public List<HlhtZcjlYdfm> getHlhtZcjlYdfmListFromBaseData(EmrQtbljlk emrQtbljlk) throws DataAccessException {
        return this.commonQueryDao.getHlhtZcjlYdfmListFromBaseData(emrQtbljlk);
    }

    @Override
    public void deleteHlhtZcjlYdfmByYjlxh(HlhtZcjlYdfm hlhtZcjlYdfm) {
        this.hlhtZcjlYdfmDao.deleteHlhtZcjlYdfmByYjlxh(hlhtZcjlYdfm);
    }

    @Override
    public MbzDataCheck interfaceHlhtZcjlYdfm(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZCJL_YDFM_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZCJL_YDFM_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZCJL_YDFM_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = this.mbzDataSetDao.selectMbzDataSetList(mbzDataSet);
        HlhtZcjlYdfm hlhtZcjlYdfmTemp = new HlhtZcjlYdfm();
        hlhtZcjlYdfmTemp.getMap().put("sourceType", Constants.WN_ZCJL_YDFM_SOURCE_TYPE);
        hlhtZcjlYdfmTemp.getMap().put("startDate", t.getMap().get("startDate"));
        hlhtZcjlYdfmTemp.getMap().put("endDate", t.getMap().get("endDate"));
        hlhtZcjlYdfmTemp.getMap().put("syxh", t.getMap().get("syxh"));
        hlhtZcjlYdfmTemp.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        hlhtZcjlYdfmTemp.getMap().put("regex", t.getMap().get("regex"));
        List<HlhtZcjlYdfm> hlhtZcjlYdfms = this.hlhtZcjlYdfmDao.selectHlhtZcjlYdfmListByProc(hlhtZcjlYdfmTemp);
        if (hlhtZcjlYdfms != null) {
            emr_count = emr_count + hlhtZcjlYdfms.size();
            for (HlhtZcjlYdfm obj : hlhtZcjlYdfms) {
                //清库
                HlhtZcjlYdfm temp = new HlhtZcjlYdfm();
                temp.setYjlxh(obj.getYjlxh());
                this.hlhtZcjlYdfmDao.deleteHlhtZcjlYdfmByYjlxh(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZCJL_YDFM_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                    continue;
                }
                Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZcjlYdfm.class);
                try {
                    obj = (HlhtZcjlYdfm) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                    logger.info("Model:{}", obj);
                    this.hlhtZcjlYdfmDao.insertHlhtZcjlYdfm(obj);
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZCJL_YDFM_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getCfxm(), "女", "2",
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZCJL_YDFM_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZCJL_YDFM_SOURCE_TYPE), obj, 0)));
                }  catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                    continue;
                }
                real_count++;

            }
        }
        this.splitTableDao.selectAnmrZcjlYdfmSplitByProc(hlhtZcjlYdfmTemp);
        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZCJL_YDFM_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZCJL_YDFM_SOURCE_TYPE), t);

        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }

    @Override
    public List<HlhtZcjlYdfm> selectHlhtZybcjlCyjlPageListByProc(HlhtZcjlYdfm hlhtZcjlYdfm) {
        return this.hlhtZcjlYdfmDao.selectHlhtZcjlYdfmListByProc(hlhtZcjlYdfm);
    }

}