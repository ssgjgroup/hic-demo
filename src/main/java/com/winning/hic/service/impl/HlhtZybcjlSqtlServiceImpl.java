package com.winning.hic.service.impl;

import java.io.IOException;
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

import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZybcjlSqtlDao;
import com.winning.hic.service.HlhtZybcjlSqtlService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_SQTL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-34-31 16:34:26
 */
@Service
public class HlhtZybcjlSqtlServiceImpl implements HlhtZybcjlSqtlService {

    private static final Logger logger = LoggerFactory.getLogger(HlhtZybcjlSqtlServiceImpl.class);
    @Autowired
    private HlhtZybcjlSqtlDao hlhtZybcjlSqtlDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtZybcjlSqtl(HlhtZybcjlSqtl hlhtZybcjlSqtl) {
        return this.hlhtZybcjlSqtlDao.insertHlhtZybcjlSqtl(hlhtZybcjlSqtl);
    }

    public int modifyHlhtZybcjlSqtl(HlhtZybcjlSqtl hlhtZybcjlSqtl) {
        return this.hlhtZybcjlSqtlDao.updateHlhtZybcjlSqtl(hlhtZybcjlSqtl);
    }

    public int removeHlhtZybcjlSqtl(HlhtZybcjlSqtl hlhtZybcjlSqtl) {
        return this.hlhtZybcjlSqtlDao.deleteHlhtZybcjlSqtl(hlhtZybcjlSqtl);
    }

    public HlhtZybcjlSqtl getHlhtZybcjlSqtl(HlhtZybcjlSqtl hlhtZybcjlSqtl) {
        return this.hlhtZybcjlSqtlDao.selectHlhtZybcjlSqtl(hlhtZybcjlSqtl);
    }

    public int getHlhtZybcjlSqtlCount(HlhtZybcjlSqtl hlhtZybcjlSqtl) {
        return (Integer) this.hlhtZybcjlSqtlDao.selectHlhtZybcjlSqtlCount(hlhtZybcjlSqtl);
    }

    public List<HlhtZybcjlSqtl> getHlhtZybcjlSqtlList(HlhtZybcjlSqtl hlhtZybcjlSqtl) {
        return this.hlhtZybcjlSqtlDao.selectHlhtZybcjlSqtlList(hlhtZybcjlSqtl);
    }

    public List<HlhtZybcjlSqtl> getHlhtZybcjlSqtlPageList(HlhtZybcjlSqtl hlhtZybcjlSqtl) {
        return this.hlhtZybcjlSqtlDao.selectHlhtZybcjlSqtlPageList(hlhtZybcjlSqtl);
    }

    @Override
    public MbzDataCheck interfaceHlhtZybcjlSqtl(MbzDataCheck entity) throws Exception {

        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量
        //加载需要抽取的数据的字段信息
        MbzDataSet dataSet = new MbzDataSet();
        dataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE));
        dataSet.setSourceType(Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE);
        List<MbzDataSet> mbzDataSetList = mbzDataSetDao.selectMbzDataSetList(dataSet);
        //查询
        dataSet = new MbzDataSet();
        dataSet.setPId(0L);
        dataSet.setSourceType(Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE);
        dataSet = mbzDataSetDao.selectMbzDataSet(dataSet);
        //加载实体类中字段(变量信息)
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlSqtl.class);

        HlhtZybcjlSqtl hlht = new HlhtZybcjlSqtl();
        hlht.getMap().put("sourceType", Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE);
        hlht.getMap().put("startDate", entity.getMap().get("startDate"));
        hlht.getMap().put("endDate", entity.getMap().get("endDate"));
        hlht.getMap().put("syxh", entity.getMap().get("syxh"));
        hlht.getMap().put("yljgdm", entity.getMap().get("yljgdm"));
        hlht.getMap().put("regex", entity.getMap().get("regex"));

        List<HlhtZybcjlSqtl> list = this.hlhtZybcjlSqtlDao.selectHlhtZybcjlSqtlListByProc(hlht);
        if (list != null && list.size() > 0) {
            emr_count = emr_count + list.size();
            for (HlhtZybcjlSqtl obj : list) {
                //获取接口数据
                HlhtZybcjlSqtl oldObj = new HlhtZybcjlSqtl();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getHlhtZybcjlSqtl(oldObj);
                //解析病历xml
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    // e.printStackTrace();
                    logger.error("解析病历报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                    continue;
                }
                //判断是否存在重复,存在则删除，重新新增
                if (oldObj != null) {
                    //初始化数据
                    HlhtZybcjlSqtl oldRcyjl = new HlhtZybcjlSqtl();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeHlhtZybcjlSqtl(oldRcyjl);
                    //清除日志
                    Map<String, Object> param = new HashMap<>();
                    param.put("SOURCE_ID", obj.getYjlxh());
                    param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (HlhtZybcjlSqtl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                String zcrxm = obj.getZcrxm();
                zcrxm = zcrxm.replace(" ", "");
                zcrxm = zcrxm.replace("副主任医师", "");
                zcrxm = zcrxm.replace("副主治医师", "");
                zcrxm = zcrxm.replace("主任医师", "");
                zcrxm = zcrxm.replace("主治医师", "");
                zcrxm = zcrxm.replace("住院医师", "");
                obj.setZcrxm(zcrxm);
                obj.setZcrbm(zcrxm);
                String cjtlmd = obj.getCjtlmd();
                cjtlmd = cjtlmd.replace(" ", "");
                cjtlmd = cjtlmd.replace("副主任医师", "");
                cjtlmd = cjtlmd.replace("副主治医师", "");
                cjtlmd = cjtlmd.replace("副住院医师", "");
                cjtlmd = cjtlmd.replace("住院医师", "");
                cjtlmd = cjtlmd.replace("主任医师", "");
                cjtlmd = cjtlmd.replace("主治医师", "");
                cjtlmd = cjtlmd.replace("规培医师", "");

                cjtlmd = cjtlmd.replace("住院医生", "");
                cjtlmd = cjtlmd.replace("主任医生", "");
                cjtlmd = cjtlmd.replace("主治医生", "");
                cjtlmd = cjtlmd.replace("规培医生", "");

                cjtlmd = cjtlmd.replace("责任护士", "");
                cjtlmd = cjtlmd.replace("护士长", "");
                cjtlmd = cjtlmd.replace("实习医师", "");

                cjtlmd = cjtlmd.replace("及基地住院医师，", "");
                cjtlmd = cjtlmd.replace("及基地住院医师", "");
                cjtlmd = cjtlmd.replace("规培基地住院医师及研究生，", "");
                cjtlmd = cjtlmd.replace("规培基地住院医师及研究生", "");
                cjtlmd = cjtlmd.replace("规培基地及研究生，", "");
                cjtlmd = cjtlmd.replace("全体基地医师", "");
                cjtlmd = cjtlmd.replace("全体基地，", "");
                cjtlmd = cjtlmd.replace("基地医师", "");
                cjtlmd = cjtlmd.replace("等", "");
                cjtlmd = cjtlmd.replace("本科实习生", "");
                cjtlmd = cjtlmd.replace("护士长", "");
                cjtlmd = cjtlmd.replace("护士", "");
                cjtlmd = cjtlmd.replace("等", "");
                cjtlmd = cjtlmd.replace("规培基地", "");
                cjtlmd = cjtlmd.replace("主任", "");
                cjtlmd = cjtlmd.replace("，，", "");
                cjtlmd = cjtlmd.replace("、", "，");
                obj.setCjtlmd(cjtlmd);
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_SQTL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtZybcjlSqtl(obj);

                //插入日志
                try {
                mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                        Long.parseLong(Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE),
                        Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                        obj.getFssj(),
                        obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                        "NA", "NA", "NA", "NA", obj.getSfzhm(),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE), obj, 1),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    //e.printStackTrace();
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                    continue;
                }
                real_count++;
            }
        } else {
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集", dataSet.getRecordName());
        }
        this.splitTableDao.selectAnmrZybcjlSqtlSplitByProc(hlht);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZYBCJL_SQTL_SOURCE_TYPE), entity);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}