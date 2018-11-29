package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.dao.hdw.SplitTableDao;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.base.utils.Base64Utils;
import com.winning.hic.base.utils.HicHelper;
import com.winning.hic.base.utils.PercentUtil;
import com.winning.hic.base.utils.ReflectUtil;
import com.winning.hic.base.utils.XmlUtil;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.HlhtZlczjlYbssjlDao;
import com.winning.hic.model.HlhtZlczjlYbssjl;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataListSet;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtZlczjlYbssjlService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_ZLCZJL_YBSSJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-31-31 16:31:59
 */
@Service
public class HlhtZlczjlYbssjlServiceImpl implements HlhtZlczjlYbssjlService {

    private final Logger logger = LoggerFactory.getLogger(HlhtZlczjlYbssjlServiceImpl.class);

    @Autowired
    private HlhtZlczjlYbssjlDao hlhtZlczjlYbssjlDao;

    @Autowired
    private MbzDataSetService mbzDataSetService;

    @Autowired
    private SplitTableDao splitTableDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    public int createHlhtZlczjlYbssjl(HlhtZlczjlYbssjl hlhtZlczjlYbssjl) {
        return this.hlhtZlczjlYbssjlDao.insertHlhtZlczjlYbssjl(hlhtZlczjlYbssjl);
    }

    public int modifyHlhtZlczjlYbssjl(HlhtZlczjlYbssjl hlhtZlczjlYbssjl) {
        return this.hlhtZlczjlYbssjlDao.updateHlhtZlczjlYbssjl(hlhtZlczjlYbssjl);
    }

    public int removeHlhtZlczjlYbssjl(HlhtZlczjlYbssjl hlhtZlczjlYbssjl) {
        return this.hlhtZlczjlYbssjlDao.deleteHlhtZlczjlYbssjl(hlhtZlczjlYbssjl);
    }

    public HlhtZlczjlYbssjl getHlhtZlczjlYbssjl(HlhtZlczjlYbssjl hlhtZlczjlYbssjl) {
        return this.hlhtZlczjlYbssjlDao.selectHlhtZlczjlYbssjl(hlhtZlczjlYbssjl);
    }

    public int getHlhtZlczjlYbssjlCount(HlhtZlczjlYbssjl hlhtZlczjlYbssjl) {
        return (Integer) this.hlhtZlczjlYbssjlDao.selectHlhtZlczjlYbssjlCount(hlhtZlczjlYbssjl);
    }

    public List<HlhtZlczjlYbssjl> getHlhtZlczjlYbssjlList(HlhtZlczjlYbssjl hlhtZlczjlYbssjl) {
        return this.hlhtZlczjlYbssjlDao.selectHlhtZlczjlYbssjlList(hlhtZlczjlYbssjl);
    }

    public List<HlhtZlczjlYbssjl> getHlhtZlczjlYbssjlPageList(HlhtZlczjlYbssjl hlhtZlczjlYbssjl) {
        return this.hlhtZlczjlYbssjlDao.selectHlhtZlczjlYbssjlPageList(hlhtZlczjlYbssjl);
    }

    private HlhtZlczjlYbssjl getInitialHlhtZlczjlYbssjl(HlhtZlczjlYbssjl entity) {
        return this.hlhtZlczjlYbssjlDao.selectInitialHlhtZlczjlYbssjl(entity);
    }

    @Override
    public MbzDataCheck interfaceHlhtZlczjlYbssjl(MbzDataCheck t) {
        //执行过程信息记录
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZLCZJL_YBSSJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZLCZJL_YBSSJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);


        //获取首次病程的对象集合
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZlczjlYbssjl.class);
        //for(MbzDataListSet dataListSet :dataListSets){
        //2.根据首次病程去找到对应的病人病历
        HlhtZlczjlYbssjl oneYbssjl = new HlhtZlczjlYbssjl();
        oneYbssjl.getMap().put("sourceType", Constants.WN_ZLCZJL_YBSSJL_SOURCE_TYPE);
        oneYbssjl.getMap().put("startDate", t.getMap().get("startDate"));
        oneYbssjl.getMap().put("endDate", t.getMap().get("endDate"));
        oneYbssjl.getMap().put("syxh", t.getMap().get("syxh"));
        oneYbssjl.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        oneYbssjl.getMap().put("regex", t.getMap().get("regex"));
        List<HlhtZlczjlYbssjl> hlhtZlczjlYbssjls = this.hlhtZlczjlYbssjlDao.selectHlhtZlczjlYbssjlListByProc(oneYbssjl);

        if (hlhtZlczjlYbssjls != null) {
            emr_count = emr_count + hlhtZlczjlYbssjls.size();
            for (HlhtZlczjlYbssjl obj : hlhtZlczjlYbssjls) {
                //清库
                HlhtZlczjlYbssjl temp = new HlhtZlczjlYbssjl();
                temp.setYjlxh(obj.getYjlxh());
                this.removeHlhtZlczjlYbssjl(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZLCZJL_YBSSJL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);

                //3.xml文件解析 获取病历信息
                Document document = null;

                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                obj = (HlhtZlczjlYbssjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                //手术史标志
                if ("NA".equals(obj.getSssbz()) || "F".equals(obj.getSssbz())) {
                    obj.setSssbz("F");
                } else {
                    obj.setSssbz("T");
                }
                //引流标志
                if ("NA".equals(obj.getYlbz()) || "F".equals(obj.getYlbz())) {
                    obj.setYlbz("F");
                } else {
                    obj.setYlbz("T");
                }
                //输血反应标志
                if ("NA".equals(obj.getSxfybz()) || "F".equals(obj.getSxfybz())) {
                    obj.setSxfybz("F");
                } else {
                    obj.setSxfybz("T");
                }

                this.createHlhtZlczjlYbssjl(obj);

                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZLCZJL_YBSSJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_ZLCZJL_YBSSJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZLCZJL_YBSSJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZlczjlYbssjlSplitByProc(oneYbssjl);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZLCZJL_YBSSJL_SOURCE_TYPE), t);

        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }


}