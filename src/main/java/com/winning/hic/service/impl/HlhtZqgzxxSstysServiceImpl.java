package com.winning.hic.service.impl;

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
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZqgzxxSstysDao;
import com.winning.hic.model.HlhtZqgzxxSstys;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtZqgzxxSstysService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZQGZXX_SSTYS
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-32-31 16:32:38
 */
@Service
public class HlhtZqgzxxSstysServiceImpl implements HlhtZqgzxxSstysService {

    private static final Logger logger = LoggerFactory.getLogger(HlhtZqgzxxSstysServiceImpl.class);

    @Autowired
    private HlhtZqgzxxSstysDao hlhtZqgzxxSstysDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    public int createHlhtZqgzxxSstys(HlhtZqgzxxSstys hlhtZqgzxxSstys) {
        return this.hlhtZqgzxxSstysDao.insertHlhtZqgzxxSstys(hlhtZqgzxxSstys);
    }

    public int modifyHlhtZqgzxxSstys(HlhtZqgzxxSstys hlhtZqgzxxSstys) {
        return this.hlhtZqgzxxSstysDao.updateHlhtZqgzxxSstys(hlhtZqgzxxSstys);
    }

    public int removeHlhtZqgzxxSstys(HlhtZqgzxxSstys hlhtZqgzxxSstys) {
        return this.hlhtZqgzxxSstysDao.deleteHlhtZqgzxxSstys(hlhtZqgzxxSstys);
    }

    public HlhtZqgzxxSstys getHlhtZqgzxxSstys(HlhtZqgzxxSstys hlhtZqgzxxSstys) {
        return this.hlhtZqgzxxSstysDao.selectHlhtZqgzxxSstys(hlhtZqgzxxSstys);
    }

    public int getHlhtZqgzxxSstysCount(HlhtZqgzxxSstys hlhtZqgzxxSstys) {
        return (Integer) this.hlhtZqgzxxSstysDao.selectHlhtZqgzxxSstysCount(hlhtZqgzxxSstys);
    }

    public List<HlhtZqgzxxSstys> getHlhtZqgzxxSstysList(HlhtZqgzxxSstys hlhtZqgzxxSstys) {
        return this.hlhtZqgzxxSstysDao.selectHlhtZqgzxxSstysList(hlhtZqgzxxSstys);
    }

    public List<HlhtZqgzxxSstys> getHlhtZqgzxxSstysPageList(HlhtZqgzxxSstys hlhtZqgzxxSstys) {
        return this.hlhtZqgzxxSstysDao.selectHlhtZqgzxxSstysPageList(hlhtZqgzxxSstys);
    }

    /**
     * 数据抽取接口
     *
     * @param entity
     * @return
     */
    @Override
    public MbzDataCheck interfaceHlhtZqgzxxSstys(MbzDataCheck entity) throws Exception {
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量
       //实际数量

        //配置接口表字段配置信息
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetDao.selectMbzDataSetList(mbzDataSet);

        //获取接口表名称
        mbzDataSet = new MbzDataSet();
        mbzDataSet.setPId(0L);
        mbzDataSet.setSourceType(Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE);
        mbzDataSet = mbzDataSetDao.selectMbzDataSet(mbzDataSet);

        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZqgzxxSstys.class);

        HlhtZqgzxxSstys hlht = new HlhtZqgzxxSstys();
        hlht.getMap().put("sourceType", Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE);
        hlht.getMap().put("startDate", entity.getMap().get("startDate"));
        hlht.getMap().put("endDate", entity.getMap().get("endDate"));
        hlht.getMap().put("syxh", entity.getMap().get("syxh"));
        hlht.getMap().put("yljgdm", entity.getMap().get("yljgdm"));
        hlht.getMap().put("regex", entity.getMap().get("regex"));
        List<HlhtZqgzxxSstys> list = this.hlhtZqgzxxSstysDao.selectHlhtZqgzxxSstysListByProc(hlht);
        if (list != null && list.size() > 0) {
            emr_count = emr_count + list.size();
            for (HlhtZqgzxxSstys obj : list) {
                //获取接口数据
                HlhtZqgzxxSstys oldObj = new HlhtZqgzxxSstys();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getHlhtZqgzxxSstys(oldObj);
                //解析病历xml
                Document document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                //System.out.println(Base64Utils.unzipEmrXml(emrQtbljlk.getBlnr()));
                //判断是否存在重复,存在则删除，重新新增
                if (oldObj != null) {
                    //初始化数据
                    HlhtZqgzxxSstys oldRcyjl = new HlhtZqgzxxSstys();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeHlhtZqgzxxSstys(oldRcyjl);
                    //清除日志
                    Map<String, Object> param = new HashMap<>();
                    param.put("SOURCE_ID", obj.getYjlxh());
                    param.put("SOURCE_TYPE", Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (HlhtZqgzxxSstys) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);

                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZQGZXX_SSTYS), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtZqgzxxSstys(obj);
                this.splitTableDao.selectAnmrZqgzxxSstysSplitByProc(hlht);
                //插入日志
                mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                        Long.parseLong(Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE),
                        Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                        obj.getFssj(),
                        obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                        obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE), obj, 1),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE), obj, 0)));
                real_count++;
            }
        } else {
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集", mbzDataSet.getRecordName());
        }
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZQGZXX_SSTYS_SOURCE_TYPE), entity);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}