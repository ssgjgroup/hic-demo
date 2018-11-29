package com.winning.hic.service.impl;

import java.io.IOException;
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
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.HlhtMjzblMjzblDao;
import com.winning.hic.model.HlhtMjzblMjzbl;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataListSet;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtMjzblMjzblService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_MJZBL_MJZBL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-29-31 16:29:44
 */
@Service
public class HlhtMjzblMjzblServiceImpl implements HlhtMjzblMjzblService {

    private final Logger logger = LoggerFactory.getLogger(HlhtMjzblMjzblServiceImpl.class);

    @Autowired
    private HlhtMjzblMjzblDao hlhtMjzblMjzblDao;

    @Autowired
    private SplitTableDao SplitTableDao;

    @Autowired
    private MbzDataSetService mbzDataSetService;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    public int createHlhtMjzblMjzbl(HlhtMjzblMjzbl hlhtMjzblMjzbl) {
        return this.hlhtMjzblMjzblDao.insertHlhtMjzblMjzbl(hlhtMjzblMjzbl);
    }

    public int modifyHlhtMjzblMjzbl(HlhtMjzblMjzbl hlhtMjzblMjzbl) {
        return this.hlhtMjzblMjzblDao.updateHlhtMjzblMjzbl(hlhtMjzblMjzbl);
    }

    public int removeHlhtMjzblMjzbl(HlhtMjzblMjzbl hlhtMjzblMjzbl) {
        return this.hlhtMjzblMjzblDao.deleteHlhtMjzblMjzbl(hlhtMjzblMjzbl);
    }

    public HlhtMjzblMjzbl getHlhtMjzblMjzbl(HlhtMjzblMjzbl hlhtMjzblMjzbl) {
        return this.hlhtMjzblMjzblDao.selectHlhtMjzblMjzbl(hlhtMjzblMjzbl);
    }

    public int getHlhtMjzblMjzblCount(HlhtMjzblMjzbl hlhtMjzblMjzbl) {
        return (Integer) this.hlhtMjzblMjzblDao.selectHlhtMjzblMjzblCount(hlhtMjzblMjzbl);
    }

    public List<HlhtMjzblMjzbl> getHlhtMjzblMjzblList(HlhtMjzblMjzbl hlhtMjzblMjzbl) {
        return this.hlhtMjzblMjzblDao.selectHlhtMjzblMjzblList(hlhtMjzblMjzbl);
    }

    public List<HlhtMjzblMjzbl> getHlhtMjzblMjzblPageList(HlhtMjzblMjzbl hlhtMjzblMjzbl) {
        return this.hlhtMjzblMjzblDao.selectHlhtMjzblMjzblPageList(hlhtMjzblMjzbl);
    }

    private HlhtMjzblMjzbl getInitialHlhtMjzblMjzbl(HlhtMjzblMjzbl entity) {
        return this.hlhtMjzblMjzblDao.selectInitialHlhtMjzblMjzbl(entity);
    }

    @Override
    public MbzDataCheck interfaceHlhtMjzblMjzbl(MbzDataCheck t) {
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量        //实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_MJZBL_MJZBL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_MJZBL_MJZBL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

        //获取首次病程的对象集合
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtMjzblMjzbl.class);
        //for(MbzDataListSet dataListSet :dataListSets){
        //2.根据首次病程去找到对应的病人病历
        HlhtMjzblMjzbl oneMjzbl = new HlhtMjzblMjzbl();
        oneMjzbl.getMap().put("sourceType", Constants.WN_MJZBL_MJZBL_SOURCE_TYPE);
        oneMjzbl.getMap().put("startDate", t.getMap().get("startDate"));
        oneMjzbl.getMap().put("endDate", t.getMap().get("endDate"));
        oneMjzbl.getMap().put("syxh", t.getMap().get("syxh"));
        oneMjzbl.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        oneMjzbl.getMap().put("regex", t.getMap().get("regex"));
        List<HlhtMjzblMjzbl> hlhtMjzblMjzbls = this.hlhtMjzblMjzblDao.selectHlhtMjzblMjzblListByProc(oneMjzbl);
        if (hlhtMjzblMjzbls != null) {
            emr_count = emr_count + hlhtMjzblMjzbls.size();
            for (HlhtMjzblMjzbl obj : hlhtMjzblMjzbls) {
                //清库
                HlhtMjzblMjzbl temp = new HlhtMjzblMjzbl();
                temp.setYjlxh(obj.getYjlxh());
                this.removeHlhtMjzblMjzbl(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_MJZBL_MJZBL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    // e.printStackTrace();
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                obj = (HlhtMjzblMjzbl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                obj.setGmsbz(StringUtil.isEmptyOrNull(obj.getGms()) ? "F" : "T");
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.MJZBL_MJZBL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtMjzblMjzbl(obj);
                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_MJZBL_MJZBL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), "NA",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), "NA", "NA", obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_MJZBL_MJZBL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_MJZBL_MJZBL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    //e.printStackTrace();
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;
            }

        }
        this.SplitTableDao.selectAnmrMjzblMjzblSplitByProc(oneMjzbl);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_MJZBL_MJZBL_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }


}