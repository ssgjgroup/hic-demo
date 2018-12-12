package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.winning.hic.dao.cmdatacenter.MbzDictInfoDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZlczjlMzshfsjlDao;
import com.winning.hic.model.EmrQtbljlk;
import com.winning.hic.model.HlhtZlczjlMzshfsjl;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzDictInfo;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtZlczjlMzshfsjlService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZLCZJL_MZSHFSJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-31-31 16:31:27
 */
@Service
public class HlhtZlczjlMzshfsjlServiceImpl implements HlhtZlczjlMzshfsjlService {
    private static final Logger logger = LoggerFactory.getLogger(HlhtZlczjlMzshfsjlServiceImpl.class);
    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private EmrQtbljlkDao emrQtbljlkDao;
    @Autowired
    private MbzDictInfoDao mbzDictInfoDao;
    @Autowired
    private HlhtZlczjlMzshfsjlDao hlhtZlczjlMzshfsjlDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzDictInfoService mbzDictInfoService;
    @Autowired
    private MbzLogService mbzLogService;

    public int createHlhtZlczjlMzshfsjl(HlhtZlczjlMzshfsjl hlhtZlczjlMzshfsjl) {
        return this.hlhtZlczjlMzshfsjlDao.insertHlhtZlczjlMzshfsjl(hlhtZlczjlMzshfsjl);
    }

    public int modifyHlhtZlczjlMzshfsjl(HlhtZlczjlMzshfsjl hlhtZlczjlMzshfsjl) {
        return this.hlhtZlczjlMzshfsjlDao.updateHlhtZlczjlMzshfsjl(hlhtZlczjlMzshfsjl);
    }

    public int removeHlhtZlczjlMzshfsjl(HlhtZlczjlMzshfsjl hlhtZlczjlMzshfsjl) {
        return this.hlhtZlczjlMzshfsjlDao.deleteHlhtZlczjlMzshfsjl(hlhtZlczjlMzshfsjl);
    }

    public HlhtZlczjlMzshfsjl getHlhtZlczjlMzshfsjl(HlhtZlczjlMzshfsjl hlhtZlczjlMzshfsjl) {
        return this.hlhtZlczjlMzshfsjlDao.selectHlhtZlczjlMzshfsjl(hlhtZlczjlMzshfsjl);
    }

    public int getHlhtZlczjlMzshfsjlCount(HlhtZlczjlMzshfsjl hlhtZlczjlMzshfsjl) {
        return (Integer) this.hlhtZlczjlMzshfsjlDao.selectHlhtZlczjlMzshfsjlCount(hlhtZlczjlMzshfsjl);
    }

    public List<HlhtZlczjlMzshfsjl> getHlhtZlczjlMzshfsjlList(HlhtZlczjlMzshfsjl hlhtZlczjlMzshfsjl) {
        return this.hlhtZlczjlMzshfsjlDao.selectHlhtZlczjlMzshfsjlList(hlhtZlczjlMzshfsjl);
    }

    public List<HlhtZlczjlMzshfsjl> getHlhtZlczjlMzshfsjlPageList(HlhtZlczjlMzshfsjl hlhtZlczjlMzshfsjl) {
        return this.hlhtZlczjlMzshfsjlDao.selectHlhtZlczjlMzshfsjlPageList(hlhtZlczjlMzshfsjl);
    }

    @Override
    public List<HlhtZlczjlMzshfsjl> getHlhtZlczjlMzshfsjlListFromBaseData(EmrQtbljlk emrQtbljlk) throws DataAccessException {
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
        return this.commonQueryDao.getHlhtZlczjlMzshfsjlListFromBaseData(emrQtbljlk);
    }

    @Override
    public void deleteHlhtZlczjlMzshfsjlByYjlxh(HlhtZlczjlMzshfsjl hlhtZlczjlMzsqfsjl) {
        this.hlhtZlczjlMzshfsjlDao.deleteHlhtZlczjlMzshfsjlByYjlxh(hlhtZlczjlMzsqfsjl);
    }

    @Override
    public MbzDataCheck interfaceHlhtZlczjlMzshfsjl(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = this.mbzDataSetDao.selectMbzDataSetList(mbzDataSet);
        HlhtZlczjlMzshfsjl hlhtZlczjlMzshfsjlTemp = new HlhtZlczjlMzshfsjl();
        hlhtZlczjlMzshfsjlTemp.getMap().put("sourceType", Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE);
        hlhtZlczjlMzshfsjlTemp.getMap().put("startDate", t.getMap().get("startDate"));
        hlhtZlczjlMzshfsjlTemp.getMap().put("endDate", t.getMap().get("endDate"));
        hlhtZlczjlMzshfsjlTemp.getMap().put("syxh", t.getMap().get("syxh"));
        //2.根据模板代码去找到对应的病人病历
        List<HlhtZlczjlMzshfsjl> hlhtZlczjlMzshfsjlList = this.hlhtZlczjlMzshfsjlDao.selectHlhtZlczjlMzshfsjlListByProc(hlhtZlczjlMzshfsjlTemp);
        if (hlhtZlczjlMzshfsjlList != null) {
            emr_count = emr_count + hlhtZlczjlMzshfsjlList.size();
            for (HlhtZlczjlMzshfsjl obj : hlhtZlczjlMzshfsjlList) {
                //清库
                HlhtZlczjlMzshfsjl temp = new HlhtZlczjlMzshfsjl();
                temp.setYjlxh(obj.getYjlxh());
                this.hlhtZlczjlMzshfsjlDao.deleteHlhtZlczjlMzshfsjlByYjlxh(temp);

                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE +"||"+getClass().toString()+"||"+"解析病历报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }
                Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZlczjlMzshfsjl.class);
                obj = (HlhtZlczjlMzshfsjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                //this.createHlhtZlczjlMzshfsjl(obj);
                try {
                    this.createHlhtZlczjlMzshfsjl(obj);
                } catch (Exception e) {
                    logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(), e.getMessage());
                    continue;
                }
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE +"||"+getClass().toString()+"||"+"病历百分比计算报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }

                real_count++;
            }
        }
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZLCZJL_MZSHFSJL_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }

    @Override
    public List<HlhtZlczjlMzshfsjl> selectHlhtZlczjlMzshfsjlListByProc(HlhtZlczjlMzshfsjl hlhtZlczjlMzsqfsjl) {
        return this.hlhtZlczjlMzshfsjlDao.selectHlhtZlczjlMzshfsjlListByProc(hlhtZlczjlMzsqfsjl);
    }
}