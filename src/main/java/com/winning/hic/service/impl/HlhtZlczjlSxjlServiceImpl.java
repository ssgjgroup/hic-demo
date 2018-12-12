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
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.HlhtZlczjlSxjlDao;
import com.winning.hic.service.HlhtZlczjlSxjlService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZLCZJL_SXJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-31-31 16:31:46
 */
@Service
public class HlhtZlczjlSxjlServiceImpl implements HlhtZlczjlSxjlService {
    private final Logger logger = LoggerFactory.getLogger(HlhtZlczjlSxjlServiceImpl.class);
    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private HlhtZlczjlSxjlDao hlhtZlczjlSxjlDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;
    @Autowired
    private MbzLogService mbzLogService;

    public int createHlhtZlczjlSxjl(HlhtZlczjlSxjl hlhtZlczjlSxjl) {
        return this.hlhtZlczjlSxjlDao.insertHlhtZlczjlSxjl(hlhtZlczjlSxjl);
    }

    public int modifyHlhtZlczjlSxjl(HlhtZlczjlSxjl hlhtZlczjlSxjl) {
        return this.hlhtZlczjlSxjlDao.updateHlhtZlczjlSxjl(hlhtZlczjlSxjl);
    }

    public int removeHlhtZlczjlSxjl(HlhtZlczjlSxjl hlhtZlczjlSxjl) {
        return this.hlhtZlczjlSxjlDao.deleteHlhtZlczjlSxjl(hlhtZlczjlSxjl);
    }

    public HlhtZlczjlSxjl getHlhtZlczjlSxjl(HlhtZlczjlSxjl hlhtZlczjlSxjl) {
        return this.hlhtZlczjlSxjlDao.selectHlhtZlczjlSxjl(hlhtZlczjlSxjl);
    }

    public int getHlhtZlczjlSxjlCount(HlhtZlczjlSxjl hlhtZlczjlSxjl) {
        return (Integer) this.hlhtZlczjlSxjlDao.selectHlhtZlczjlSxjlCount(hlhtZlczjlSxjl);
    }

    public List<HlhtZlczjlSxjl> getHlhtZlczjlSxjlList(HlhtZlczjlSxjl hlhtZlczjlSxjl) {
        return this.hlhtZlczjlSxjlDao.selectHlhtZlczjlSxjlList(hlhtZlczjlSxjl);
    }

    public List<HlhtZlczjlSxjl> getHlhtZlczjlSxjlPageList(HlhtZlczjlSxjl hlhtZlczjlSxjl) {
        return this.hlhtZlczjlSxjlDao.selectHlhtZlczjlSxjlPageList(hlhtZlczjlSxjl);
    }

    @Override
    public List<HlhtZlczjlSxjl> getHlhtZlczjlSxjlListFromBaseData(EmrQtbljlk emrQtbljlk) throws DataAccessException {
        return this.commonQueryDao.getHlhtZlczjlSxjlListFromBaseData(emrQtbljlk);
    }

    @Override
    public void deleteHlhtZlczjlSxjlByYjlxh(HlhtZlczjlSxjl hlhtZlczjlSxjl) {
        this.deleteHlhtZlczjlSxjlByYjlxh(hlhtZlczjlSxjl);
    }

    @Override
    public MbzDataCheck interfaceHlhtZlczjlSxjl(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录

        ;
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = this.mbzDataSetDao.selectMbzDataSetList(mbzDataSet);
        HlhtZlczjlSxjl hlhtZlczjlSxjlTemp = new HlhtZlczjlSxjl();
        hlhtZlczjlSxjlTemp.getMap().put("sourceType", Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE);
        hlhtZlczjlSxjlTemp.getMap().put("startDate", t.getMap().get("startDate"));
        hlhtZlczjlSxjlTemp.getMap().put("endDate", t.getMap().get("endDate"));
        hlhtZlczjlSxjlTemp.getMap().put("syxh", t.getMap().get("syxh"));
        hlhtZlczjlSxjlTemp.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        hlhtZlczjlSxjlTemp.getMap().put("regex", t.getMap().get("regex"));
        //2.根据模板代码去找到对应的病人病历
        List<HlhtZlczjlSxjl> hlhtZlczjlSxjls = this.hlhtZlczjlSxjlDao.selectHlhtZlczjlSxjlListByProc(hlhtZlczjlSxjlTemp);
        if (hlhtZlczjlSxjls != null) {
            emr_count = emr_count + hlhtZlczjlSxjls.size();
            for (HlhtZlczjlSxjl obj : hlhtZlczjlSxjls) {
                //清库
                HlhtZlczjlSxjl temp = new HlhtZlczjlSxjl();
                temp.setYjlxh(obj.getYjlxh());
                this.hlhtZlczjlSxjlDao.deleteHlhtZlczjlSxjlByYjlxh(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE +"||"+getClass().toString()+"||"+"解析病历报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }
                Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZlczjlSxjl.class);

                obj = (HlhtZlczjlSxjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                logger.info("Model:{}", obj);
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZLCZJL_SXJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                //this.createHlhtZlczjlSxjl(obj);
                try {
                    this.createHlhtZlczjlSxjl(obj);
                } catch (Exception e) {
                    logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                    continue;
                }
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE +"||"+getClass().toString()+"||"+"病历百分比计算报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }


                real_count++;

            }
        }
        this.splitTableDao.selectAnmrZlczjlSxjlSplitByProc(hlhtZlczjlSxjlTemp);
        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZLCZJL_SXJL_SOURCE_TYPE), t);

        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}