package com.winning.hic.service.impl;

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
import com.winning.hic.dao.hdw.HlhtZqgzxxQtzqtysDao;
import com.winning.hic.service.HlhtZqgzxxQtzqtysService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_ZQGZXX_QTZQTYS
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-32-31 16:32:29
 */
@Service
public class HlhtZqgzxxQtzqtysServiceImpl implements HlhtZqgzxxQtzqtysService {
    private final Logger logger = LoggerFactory.getLogger(HlhtZqgzxxQtzqtysServiceImpl.class);

    @Autowired
    private HlhtZqgzxxQtzqtysDao hlhtZqgzxxQtzqtysDao;

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


    public int createHlhtZqgzxxQtzqtys(HlhtZqgzxxQtzqtys hlhtZqgzxxQtzqtys) {
        return this.hlhtZqgzxxQtzqtysDao.insertHlhtZqgzxxQtzqtys(hlhtZqgzxxQtzqtys);
    }

    public int modifyHlhtZqgzxxQtzqtys(HlhtZqgzxxQtzqtys hlhtZqgzxxQtzqtys) {
        return this.hlhtZqgzxxQtzqtysDao.updateHlhtZqgzxxQtzqtys(hlhtZqgzxxQtzqtys);
    }

    public int removeHlhtZqgzxxQtzqtys(HlhtZqgzxxQtzqtys hlhtZqgzxxQtzqtys) {
        return this.hlhtZqgzxxQtzqtysDao.deleteHlhtZqgzxxQtzqtys(hlhtZqgzxxQtzqtys);
    }

    public HlhtZqgzxxQtzqtys getHlhtZqgzxxQtzqtys(HlhtZqgzxxQtzqtys hlhtZqgzxxQtzqtys) {
        return this.hlhtZqgzxxQtzqtysDao.selectHlhtZqgzxxQtzqtys(hlhtZqgzxxQtzqtys);
    }

    public int getHlhtZqgzxxQtzqtysCount(HlhtZqgzxxQtzqtys hlhtZqgzxxQtzqtys) {
        return (Integer) this.hlhtZqgzxxQtzqtysDao.selectHlhtZqgzxxQtzqtysCount(hlhtZqgzxxQtzqtys);
    }

    public List<HlhtZqgzxxQtzqtys> getHlhtZqgzxxQtzqtysList(HlhtZqgzxxQtzqtys hlhtZqgzxxQtzqtys) {
        return this.hlhtZqgzxxQtzqtysDao.selectHlhtZqgzxxQtzqtysList(hlhtZqgzxxQtzqtys);
    }

    public List<HlhtZqgzxxQtzqtys> getHlhtZqgzxxQtzqtysPageList(HlhtZqgzxxQtzqtys hlhtZqgzxxQtzqtys) {
        return this.hlhtZqgzxxQtzqtysDao.selectHlhtZqgzxxQtzqtysPageList(hlhtZqgzxxQtzqtys);
    }

    private HlhtZqgzxxQtzqtys getInitialHlhtZqgzxxQtzqtys(HlhtZqgzxxQtzqtys hlhtZqgzxxQtzqtys) {
        return this.hlhtZqgzxxQtzqtysDao.selectInitialHlhtZqgzxxQtzqtys(hlhtZqgzxxQtzqtys);
    }

    @Override
    public MbzDataCheck interfaceHlhtZqgzxxQtzqtys(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

        //获取首次病程的对象集合
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZqgzxxQtzqtys.class);
        //for(MbzDataListSet dataListSet :dataListSets){
        HlhtZqgzxxQtzqtys oneQtzqtys = new HlhtZqgzxxQtzqtys();
        oneQtzqtys.getMap().put("sourceType", Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE);
        oneQtzqtys.getMap().put("startDate", t.getMap().get("startDate"));
        oneQtzqtys.getMap().put("endDate", t.getMap().get("endDate"));
        oneQtzqtys.getMap().put("syxh", t.getMap().get("syxh"));
        oneQtzqtys.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        oneQtzqtys.getMap().put("regex", t.getMap().get("regex"));
        List<HlhtZqgzxxQtzqtys> hlhtZqgzxxQtzqtyss = this.hlhtZqgzxxQtzqtysDao.selectHlhtZqgzxxQtzqtysListByProc(oneQtzqtys);
        if (hlhtZqgzxxQtzqtyss != null) {
            emr_count = emr_count + hlhtZqgzxxQtzqtyss.size();
            for (HlhtZqgzxxQtzqtys obj : hlhtZqgzxxQtzqtyss) {
                //清库
                HlhtZqgzxxQtzqtys temp = new HlhtZqgzxxQtzqtys();
                temp.setYjlxh(obj.getYjlxh());
                this.removeHlhtZqgzxxQtzqtys(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);

                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                    obj = (HlhtZqgzxxQtzqtys) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                } catch (Exception e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }

                logger.info("Model:{}", obj);
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZQGZXX_QTZQTYS), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtZqgzxxQtzqtys(obj);

                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZqgzxxQtzqtysSplitByProc(oneQtzqtys);

        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE), t);

        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }


}