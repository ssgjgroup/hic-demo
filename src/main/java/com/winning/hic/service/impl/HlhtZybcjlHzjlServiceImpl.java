package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.*;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.*;
import com.winning.hic.model.*;
import com.winning.hic.service.MbzDictInfoService;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.service.HlhtZybcjlHzjlService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_HZJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-33-31 16:33:23
 */
@Service
public class HlhtZybcjlHzjlServiceImpl implements HlhtZybcjlHzjlService {

    private final Logger logger = LoggerFactory.getLogger(HlhtZybcjlHzjlServiceImpl.class);
    @Autowired
    private HlhtZybcjlHzjlDao hlhtZybcjlHzjlDao;

    @Autowired
    private MbzDataSetService mbzDataSetService;

    @Autowired
    private EmrHzsqdjlkDao emrHzsqdjlkDao;

    @Autowired
    private SplitTableDao splitTableDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtZybcjlHzjl(HlhtZybcjlHzjl hlhtZybcjlHzjl) {
        return this.hlhtZybcjlHzjlDao.insertHlhtZybcjlHzjl(hlhtZybcjlHzjl);
    }

    public int modifyHlhtZybcjlHzjl(HlhtZybcjlHzjl hlhtZybcjlHzjl) {
        return this.hlhtZybcjlHzjlDao.updateHlhtZybcjlHzjl(hlhtZybcjlHzjl);
    }

    public int removeHlhtZybcjlHzjl(HlhtZybcjlHzjl hlhtZybcjlHzjl) {
        return this.hlhtZybcjlHzjlDao.deleteHlhtZybcjlHzjl(hlhtZybcjlHzjl);
    }

    public HlhtZybcjlHzjl getHlhtZybcjlHzjl(HlhtZybcjlHzjl hlhtZybcjlHzjl) {
        return this.hlhtZybcjlHzjlDao.selectHlhtZybcjlHzjl(hlhtZybcjlHzjl);
    }

    public int getHlhtZybcjlHzjlCount(HlhtZybcjlHzjl hlhtZybcjlHzjl) {
        return (Integer) this.hlhtZybcjlHzjlDao.selectHlhtZybcjlHzjlCount(hlhtZybcjlHzjl);
    }

    public List<HlhtZybcjlHzjl> getHlhtZybcjlHzjlList(HlhtZybcjlHzjl hlhtZybcjlHzjl) {
        return this.hlhtZybcjlHzjlDao.selectHlhtZybcjlHzjlList(hlhtZybcjlHzjl);
    }

    public List<HlhtZybcjlHzjl> getHlhtZybcjlHzjlPageList(HlhtZybcjlHzjl hlhtZybcjlHzjl) {
        return this.hlhtZybcjlHzjlDao.selectHlhtZybcjlHzjlPageList(hlhtZybcjlHzjl);
    }

    private HlhtZybcjlHzjl getInitialHlhtZybcjlHzjl(HlhtZybcjlHzjl entity) {
        return this.hlhtZybcjlHzjlDao.selectInitialHlhtZybcjlHzjl(entity);
    }

    @Override
    public MbzDataCheck interfaceHlhtZybcjlHzjl(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量        //实际数量
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

        //获取首次病程的对象集合
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlHzjl.class);
        //for(MbzDataListSet dataListSet :dataListSets){
        //2.根据首次病程去找到对应的病人病历
        HlhtZybcjlHzjl oneHzjl = new HlhtZybcjlHzjl();
        oneHzjl.getMap().put("sourceType", Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE);
        oneHzjl.getMap().put("startDate", t.getMap().get("startDate"));
        oneHzjl.getMap().put("endDate", t.getMap().get("endDate"));
        oneHzjl.getMap().put("syxh", t.getMap().get("syxh"));
        oneHzjl.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        oneHzjl.getMap().put("regex", t.getMap().get("regex"));

        List<HlhtZybcjlHzjl> hlhtZybcjlHzjls = this.hlhtZybcjlHzjlDao.selecthlhtZybcjlHzjlListByProc(oneHzjl);
        if (hlhtZybcjlHzjls != null) {
            for (HlhtZybcjlHzjl obj : hlhtZybcjlHzjls) {
                //判断属于哪一种单据（1.申请单 2.答复单）
                EmrHzsqdjlk s_hzsqdjlk = new EmrHzsqdjlk();
                s_hzsqdjlk.getMap().put("entity_param", obj.getYjlxh());
                List<EmrHzsqdjlk> hzsqdjlk_list = emrHzsqdjlkDao.selectEmrHzsqdjlkList2(s_hzsqdjlk);
                if (hzsqdjlk_list.size() > 0 && hzsqdjlk_list != null) {
                    if (String.valueOf(hzsqdjlk_list.get(0).getQtbljlxh()).equals(obj.getYjlxh())) { //会诊申请单 insert
                        emr_count++;
                        HlhtZybcjlHzjl scbcjl = new HlhtZybcjlHzjl();
                        scbcjl.setYjlxh(obj.getYjlxh());
                        scbcjl = this.getHlhtZybcjlHzjl(scbcjl);

                        if (scbcjl != null) {
                            //初始化数据
                            HlhtZybcjlHzjl oldRcyjl = new HlhtZybcjlHzjl();
                            oldRcyjl.setYjlxh(obj.getYjlxh());
                            this.removeHlhtZybcjlHzjl(oldRcyjl);
                            //清除日志
                            Map<String, Object> param = new HashMap<>();
                            param.put("SOURCE_ID", obj.getYjlxh());
                            param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE);
                            mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                        }

                        try {
                            Document document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                            obj = (HlhtZybcjlHzjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                            ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_HZJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                        } catch (Exception e) {
                            logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                            continue;
                        }

                        this.createHlhtZybcjlHzjl(obj);
                        real_count++;
                    } else { //会诊答复单 update
                        Document document = null;
                        try {
                            document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                        } catch (IOException e) {
                            // e.printStackTrace();
                            logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                            continue;
                        }
                        HlhtZybcjlHzjl entity = new HlhtZybcjlHzjl();
                        entity.setYjlxh(String.valueOf(hzsqdjlk_list.get(0).getQtbljlxh()));
                        entity = this.getHlhtZybcjlHzjl(entity);
                        if (entity != null) {
                            entity = (HlhtZybcjlHzjl) HicHelper.initModelValue(mbzDataSetList, document, entity, paramTypeMap);
                            ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_HZJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);

                            this.modifyHlhtZybcjlHzjl(entity);
                        }
                        try {
                            mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                                    Long.parseLong(Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE),
                                    Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                                    obj.getFssj(),
                                    obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                                    obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE), obj, 1),
                                    PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE), obj, 0)));
                        } catch (Exception e) {
                            logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                            continue;
                        }
                    }

                }
            }
        }
        this.splitTableDao.selectAnmrZybcjlHzjlSplitByProc(oneHzjl);

        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZYBCJL_HZJL_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }


}