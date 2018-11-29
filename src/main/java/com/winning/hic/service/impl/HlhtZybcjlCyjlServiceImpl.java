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
import org.thymeleaf.util.StringUtils;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.HlhtZybcjlCyjlDao;
import com.winning.hic.model.EmrQtbljlk;
import com.winning.hic.model.HlhtZybcjlCyjl;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtZybcjlCyjlService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_CYJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-33-31 16:33:08
 */
@Service
public class HlhtZybcjlCyjlServiceImpl implements HlhtZybcjlCyjlService {

    private final Logger logger = LoggerFactory.getLogger(HlhtZybcjlCyjlServiceImpl.class);

    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;

    @Autowired
    private HlhtZybcjlCyjlDao hlhtZybcjlCyjlDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    public int createHlhtZybcjlCyjl(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        return this.hlhtZybcjlCyjlDao.insertHlhtZybcjlCyjl(hlhtZybcjlCyjl);
    }

    public int modifyHlhtZybcjlCyjl(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        return this.hlhtZybcjlCyjlDao.updateHlhtZybcjlCyjl(hlhtZybcjlCyjl);
    }

    public int removeHlhtZybcjlCyjl(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        return this.hlhtZybcjlCyjlDao.deleteHlhtZybcjlCyjl(hlhtZybcjlCyjl);
    }

    public HlhtZybcjlCyjl getHlhtZybcjlCyjl(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        return this.hlhtZybcjlCyjlDao.selectHlhtZybcjlCyjl(hlhtZybcjlCyjl);
    }

    public int getHlhtZybcjlCyjlCount(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        return (Integer) this.hlhtZybcjlCyjlDao.selectHlhtZybcjlCyjlCount(hlhtZybcjlCyjl);
    }

    public List<HlhtZybcjlCyjl> getHlhtZybcjlCyjlList(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        return this.hlhtZybcjlCyjlDao.selectHlhtZybcjlCyjlList(hlhtZybcjlCyjl);
    }

    public List<HlhtZybcjlCyjl> getHlhtZybcjlCyjlPageList(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        return this.hlhtZybcjlCyjlDao.selectHlhtZybcjlCyjlPageList(hlhtZybcjlCyjl);
    }

    @Override
    public MbzDataCheck interfaceHlhtZybcjlCyjl(MbzDataCheck t) {
        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = this.mbzDataSetDao.selectMbzDataSetList(mbzDataSet);
        HlhtZybcjlCyjl hlhtZybcjlCyjlTemp = new HlhtZybcjlCyjl();
        hlhtZybcjlCyjlTemp.getMap().put("sourceType", Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE);
        hlhtZybcjlCyjlTemp.getMap().put("startDate", t.getMap().get("startDate"));
        hlhtZybcjlCyjlTemp.getMap().put("endDate", t.getMap().get("endDate"));
        hlhtZybcjlCyjlTemp.getMap().put("syxh", t.getMap().get("syxh"));
        hlhtZybcjlCyjlTemp.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        hlhtZybcjlCyjlTemp.getMap().put("regex", t.getMap().get("regex"));

        List<HlhtZybcjlCyjl> hlhtZybcjlCyjls = this.hlhtZybcjlCyjlDao.selectHlhtZybcjlCyjlListByProc(hlhtZybcjlCyjlTemp);
        if (hlhtZybcjlCyjls != null) {
            emr_count = emr_count + hlhtZybcjlCyjls.size();
            for (HlhtZybcjlCyjl obj : hlhtZybcjlCyjls) {
                //清库
                HlhtZybcjlCyjl temp = new HlhtZybcjlCyjl();
                temp.setYjlxh(obj.getYjlxh());
                this.hlhtZybcjlCyjlDao.deleteHlhtZybcjlCyjlByYjlxh(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlCyjl.class);

                obj = (HlhtZybcjlCyjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                logger.info("Model:{}", obj);
                //初步诊断-中医病名代码、名称处理
                if (!"NA".equals(obj.getCzzybmdm())) {
                    String bmdm = "";
                    String bm = "";
                    String[] str = obj.getCzzybmdm().split("  ");
                    String[] str2 = obj.getCzzybmmc().split("  ");
                    Character o = new Character('B');
                    for (int i = 0; str.length > i; i++) {
                        if (!"".equals(str[i].toString())) {
                            if (o.equals(str[i].trim().charAt(0))) {
                                bmdm = bmdm + str[i] + "  ";
                                bm = bm + str2[i] + "  ";
                            }
                        }
                    }
                    if (StringUtils.isEmpty(bmdm)) {
                        obj.setCzzybmdm("NA");
                    } else {
                        obj.setCzzybmdm(bmdm);
                    }
                    if (StringUtils.isEmpty(bm)) {
                        obj.setCzzybmmc("NA");
                    } else {
                        obj.setCzzybmmc(bm);
                    }
                }
                //初步诊断-中医证候代码
                if (!"NA".equals(obj.getCzzyzhdm())) {
                    String bmdm = "";
                    String bm = "";
                    String[] str = obj.getCzzyzhdm().split("  ");
                    String[] str2 = obj.getCzzyzhmc().split("  ");
                    Character o = new Character('B');
                    for (int i = 0; str.length > i; i++) {
                        if (!"".equals(str[i].toString())) {
                            if (!o.equals(str[i].trim().charAt(0))) {
                                bmdm = bmdm + str[i] + "  ";
                                bm = bm + str2[i] + "  ";
                            }
                        }
                    }
                    if (StringUtils.isEmpty(bmdm)) {
                        obj.setCzzyzhdm("NA");
                    } else {
                        obj.setCzzyzhdm(bmdm);
                    }
                    if (StringUtils.isEmpty(bm)) {
                        obj.setCzzyzhmc("NA");
                    } else {
                        obj.setCzzyzhmc(bm);
                    }
                }


                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_CYJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.hlhtZybcjlCyjlDao.insertHlhtZybcjlCyjl(obj);
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }

                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZybcjlCyjlSplitByProc(hlhtZybcjlCyjlTemp);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE), t);

        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }

    @Override
    public void deleteHlhtZybcjlCyjlByYjlxh(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        this.hlhtZybcjlCyjlDao.deleteHlhtZybcjlCyjl(hlhtZybcjlCyjl);
    }

    @Override
    public List<HlhtZybcjlCyjl> getHlhtZybcjlCyjlListFromBaseData(EmrQtbljlk emrQtbljlk) {
        return this.commonQueryDao.getHlhtZybcjlCyjlListFromBaseData(emrQtbljlk);
    }

    @Override
    public List<HlhtZybcjlCyjl> selectHlhtZybcjlCyjlListByProc(HlhtZybcjlCyjl hlhtZybcjlCyjl) {
        return this.hlhtZybcjlCyjlDao.selectHlhtZybcjlCyjlListByProc(hlhtZybcjlCyjl);
    }


}