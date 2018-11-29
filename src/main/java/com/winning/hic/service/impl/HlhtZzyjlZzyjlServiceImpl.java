package com.winning.hic.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.*;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;

import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZzyjlZzyjlDao;
import com.winning.hic.service.HlhtZzyjlZzyjlService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_ZZYJL_ZZYJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-35-31 16:35:09
 */
@Service
public class HlhtZzyjlZzyjlServiceImpl implements HlhtZzyjlZzyjlService {

    private final Logger logger = LoggerFactory.getLogger(HlhtZzyjlZzyjlServiceImpl.class);
    @Autowired
    private HlhtZzyjlZzyjlDao HlhtZzyjlZzyjlDao;

    @Autowired
    private MbzDataSetService mbzDataSetService;

    @Autowired
    private CommonQueryDao commonQueryDao;

    @Autowired
    private EmrQtbljlkDao emrQtbljlkDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private SplitTableDao splitTableDao;

    public int createHlhtZzyjlZzyjl(HlhtZzyjlZzyjl HlhtZzyjlZzyjl) {
        return this.HlhtZzyjlZzyjlDao.insertHlhtZzyjlZzyjl(HlhtZzyjlZzyjl);
    }

    public int modifyHlhtZzyjlZzyjl(HlhtZzyjlZzyjl HlhtZzyjlZzyjl) {
        return this.HlhtZzyjlZzyjlDao.updateHlhtZzyjlZzyjl(HlhtZzyjlZzyjl);
    }

    public int removeHlhtZzyjlZzyjl(HlhtZzyjlZzyjl HlhtZzyjlZzyjl) {
        return this.HlhtZzyjlZzyjlDao.deleteHlhtZzyjlZzyjl(HlhtZzyjlZzyjl);
    }

    public HlhtZzyjlZzyjl getHlhtZzyjlZzyjl(HlhtZzyjlZzyjl HlhtZzyjlZzyjl) {
        return this.HlhtZzyjlZzyjlDao.selectHlhtZzyjlZzyjl(HlhtZzyjlZzyjl);
    }

    public int getHlhtZzyjlZzyjlCount(HlhtZzyjlZzyjl HlhtZzyjlZzyjl) {
        return (Integer) this.HlhtZzyjlZzyjlDao.selectHlhtZzyjlZzyjlCount(HlhtZzyjlZzyjl);
    }

    public List<HlhtZzyjlZzyjl> getHlhtZzyjlZzyjlList(HlhtZzyjlZzyjl HlhtZzyjlZzyjl) {
        return this.HlhtZzyjlZzyjlDao.selectHlhtZzyjlZzyjlList(HlhtZzyjlZzyjl);
    }

    public List<HlhtZzyjlZzyjl> getHlhtZzyjlZzyjlPageList(HlhtZzyjlZzyjl HlhtZzyjlZzyjl) {
        return this.HlhtZzyjlZzyjlDao.selectHlhtZzyjlZzyjlPageList(HlhtZzyjlZzyjl);
    }

    private HlhtZzyjlZzyjl getInitialHlhtZzyjlZzyjl(HlhtZzyjlZzyjl entity) {
        return this.HlhtZzyjlZzyjlDao.selectInitialHlhtZzyjlZzyjl(entity);
    }

    @Override
    public MbzDataCheck interfaceHlhtZzyjlZzyjl(MbzDataCheck t) {
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量        //实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZZYJL_ZZYJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZZYJL_ZZYJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);


        //获取首次病程的对象集合
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZzyjlZzyjl.class);
        HlhtZzyjlZzyjl hlht = new HlhtZzyjlZzyjl();
        hlht.getMap().put("sourceType", Constants.WN_ZZYJL_ZZYJL_SOURCE_TYPE);
        hlht.getMap().put("startDate", t.getMap().get("startDate"));
        hlht.getMap().put("endDate", t.getMap().get("endDate"));
        hlht.getMap().put("syxh", t.getMap().get("syxh"));
        hlht.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        hlht.getMap().put("regex", t.getMap().get("regex"));

        List<HlhtZzyjlZzyjl> hlhtZzyjlZzyjls = this.HlhtZzyjlZzyjlDao.selectHlhtZzyjlZzyjlListByProc(hlht);
        if (hlhtZzyjlZzyjls != null) {
            emr_count = emr_count + hlhtZzyjlZzyjls.size();
            for (HlhtZzyjlZzyjl obj : hlhtZzyjlZzyjls) {
                //清库
                HlhtZzyjlZzyjl temp = new HlhtZzyjlZzyjl();
                temp.setYjlxh(obj.getYjlxh());
                this.removeHlhtZzyjlZzyjl(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZZYJL_ZZYJL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);

                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                    obj = (HlhtZzyjlZzyjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                } catch (Exception e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZZYJL_ZZYJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtZzyjlZzyjl(obj);

                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            "NA", "NA", "NA", "NA", obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_ZQGZXX_QTZQTYS_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZZYJL_ZZYJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    //e.printStackTrace();
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZzyjlZzyjlSplitByProc(hlht);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZZYJL_ZZYJL_SOURCE_TYPE), t);

        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }


}