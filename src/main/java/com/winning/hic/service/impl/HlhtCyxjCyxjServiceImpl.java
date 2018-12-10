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
import org.thymeleaf.util.StringUtils;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.HlhtCyxjCyxjDao;
import com.winning.hic.service.HlhtCyxjCyxjService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_CYXJ_CYXJ
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-29-31 16:29:18
 */
@Service
public class HlhtCyxjCyxjServiceImpl implements HlhtCyxjCyxjService {

    private final Logger logger = LoggerFactory.getLogger(HlhtZlczjlYbssjlServiceImpl.class);

    @Autowired
    private HlhtCyxjCyxjDao hlhtCyxjCyxjDao;

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

    public int createHlhtCyxjCyxj(HlhtCyxjCyxj hlhtCyxjCyxj) {
        return this.hlhtCyxjCyxjDao.insertHlhtCyxjCyxj(hlhtCyxjCyxj);
    }

    public int modifyHlhtCyxjCyxj(HlhtCyxjCyxj hlhtCyxjCyxj) {
        return this.hlhtCyxjCyxjDao.updateHlhtCyxjCyxj(hlhtCyxjCyxj);
    }

    public int removeHlhtCyxjCyxj(HlhtCyxjCyxj hlhtCyxjCyxj) {
        return this.hlhtCyxjCyxjDao.deleteHlhtCyxjCyxj(hlhtCyxjCyxj);
    }

    public HlhtCyxjCyxj getHlhtCyxjCyxj(HlhtCyxjCyxj hlhtCyxjCyxj) {
        return this.hlhtCyxjCyxjDao.selectHlhtCyxjCyxj(hlhtCyxjCyxj);
    }

    public int getHlhtCyxjCyxjCount(HlhtCyxjCyxj hlhtCyxjCyxj) {
        return (Integer) this.hlhtCyxjCyxjDao.selectHlhtCyxjCyxjCount(hlhtCyxjCyxj);
    }

    public List<HlhtCyxjCyxj> getHlhtCyxjCyxjList(HlhtCyxjCyxj hlhtCyxjCyxj) {
        return this.hlhtCyxjCyxjDao.selectHlhtCyxjCyxjList(hlhtCyxjCyxj);
    }

    public List<HlhtCyxjCyxj> getHlhtCyxjCyxjPageList(HlhtCyxjCyxj hlhtCyxjCyxj) {
        return this.hlhtCyxjCyxjDao.selectHlhtCyxjCyxjPageList(hlhtCyxjCyxj);
    }

    private HlhtCyxjCyxj getInitialHlhtCyxjCyxj(HlhtCyxjCyxj entity) {
        return this.hlhtCyxjCyxjDao.selectInitialHlhtCyxjCyxj(entity);

    }

    @Override
    public MbzDataCheck interfaceHlhtCyxjCyxj(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_CYXJ_CYXJ_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }

        //执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量        //实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_CYXJ_CYXJ_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_CYXJ_CYXJ_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

            //获取首次病程的对象集合
            Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtCyxjCyxj.class);
            //for(MbzDataListSet dataListSet :dataListSets){
            //2.根据首次病程去找到对应的病人病历
            HlhtCyxjCyxj oneCyxj = new HlhtCyxjCyxj();
            oneCyxj.getMap().put("sourceType", Constants.WN_CYXJ_CYXJ_SOURCE_TYPE);
            oneCyxj.getMap().put("startDate", t.getMap().get("startDate"));
            oneCyxj.getMap().put("endDate", t.getMap().get("endDate"));
            oneCyxj.getMap().put("syxh", t.getMap().get("syxh"));
            oneCyxj.getMap().put("yljgdm", t.getMap().get("yljgdm"));
            oneCyxj.getMap().put("regex", t.getMap().get("regex"));
            List<HlhtCyxjCyxj> hlhtCyxjCyxjs = this.hlhtCyxjCyxjDao.selectHlhtCyxjCyxjListByProc(oneCyxj);
            if (hlhtCyxjCyxjs != null) {
                emr_count = emr_count + hlhtCyxjCyxjs.size();
                for (HlhtCyxjCyxj obj : hlhtCyxjCyxjs) {
                    //清库
                    HlhtCyxjCyxj temp = new HlhtCyxjCyxj();
                    temp.setYjlxh(obj.getYjlxh());
                    this.removeHlhtCyxjCyxj(temp);
                    //清除日志
                    Map<String, Object> param = new HashMap<>();
                    param.put("SOURCE_ID", obj.getYjlxh());
                    param.put("SOURCE_TYPE", Constants.WN_CYXJ_CYXJ_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);

                    //3.xml文件解析 获取病历信息
                    Document document = null;
                    try {
                        document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                        obj = (HlhtCyxjCyxj) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                    } catch (Exception e) {
                        //e.printStackTrace();
                        logger.error("解析病历报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                        continue;
                    }
                    //初步诊断-中医病名代码、名称处理
                    if (!"NA".equals(obj.getRzzybmdm())) {
                        String bmdm = "";
                        String bm = "";
                        String[] str = obj.getRzzybmdm().split("  ");
                        String[] str2 = obj.getRzzybm().split("  ");
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
                            obj.setRzzybmdm("NA");
                        } else {
                            obj.setRzzybmdm(bmdm);
                        }
                        if (StringUtils.isEmpty(bm)) {
                            obj.setRzzybm("NA");
                        } else {
                            obj.setRzzybm(bm);
                        }
                    }
                    //初步诊断-中医证候代码
                    if (!"NA".equals(obj.getRzzyzhdm())) {
                        String bmdm = "";
                        String bm = "";
                        String[] str = obj.getRzzyzhdm().split("  ");
                        String[] str2 = obj.getRzzyzh().split("  ");
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
                            obj.setRzzyzhdm("NA");
                        } else {
                            obj.setRzzyzhdm(bmdm);
                        }
                        if (StringUtils.isEmpty(bm)) {
                            obj.setRzzyzh("NA");
                        } else {
                            obj.setRzzyzh(bm);
                        }
                    }

                    //出院诊断-中医病名代码、名称处理
                    if (!"NA".equals(obj.getCzzybmdm())) {
                        String bmdm = "";
                        String bm = "";
                        String[] str = obj.getCzzybmdm().split("  ");
                        String[] str2 = obj.getCzzybm().split("  ");
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
                            obj.setCzzybm("NA");
                        } else {
                            obj.setCzzybm(bm);
                        }
                    }
                    //出院诊断-中医证候代码
                    if (!"NA".equals(obj.getCzzyzhdm())) {
                        String bmdm = "";
                        String bm = "";
                        String[] str = obj.getCzzyzhdm().split("  ");
                        String[] str2 = obj.getCzzyzh().split("  ");
                        Character o = new Character('B');
                        for (int i = 0; str.length > i; i++) {
                            if (!"".equals(str[i].toString())) {
                                if (!o.equals(str[i].charAt(0))) {
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
                            obj.setCzzyzh("NA");
                        } else {
                            obj.setCzzyzh(bm);
                        }
                    }

                    logger.info("Model:{}", obj);
                    ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.CYXJ_CYXJ), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                    try {
                        this.createHlhtCyxjCyxj(obj);
                    } catch (Exception e) {
                        logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                        continue;
                    }
                    //插入日志
                    try {
                        mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                                Long.parseLong(Constants.WN_CYXJ_CYXJ_SOURCE_TYPE),
                                Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                                obj.getFssj(),
                                obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                                obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_CYXJ_CYXJ_SOURCE_TYPE), obj, 1),
                                PercentUtil.getPercent(Long.parseLong(Constants.WN_CYXJ_CYXJ_SOURCE_TYPE), obj, 0)));
                    } catch (Exception e) {
                        logger.error("病历百分比计算报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                        continue;
                    }
                    real_count++;

                }
            }
        this.splitTableDao.selectAnmrCyxjCyxjSplitByProc(oneCyxj);
        t.getMap().put("sourceType",Constants.WN_CYXJ_CYXJ_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_CYXJ_CYXJ_SOURCE_TYPE), t);

        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }


}