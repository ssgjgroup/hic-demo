package com.winning.hic.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.*;
import com.winning.hic.service.*;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZybcjlZkjlDao;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_ZKJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-35-31 16:35:02
 */
@Service
public class HlhtZybcjlZkjlServiceImpl implements HlhtZybcjlZkjlService {

    private final Logger logger = LoggerFactory.getLogger(HlhtZybcjlZkjlServiceImpl.class);
    @Autowired
    private HlhtZybcjlZkjlDao hlhtZybcjlZkjlDao;

    @Autowired
    private MbzDataSetService mbzDataSetService;

    @Autowired
    private EmrQtbljlkDao emrQtbljlkDao;

    @Autowired
    private SplitTableDao splitTableDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;
    @Autowired
    private MbzLogService mbzLogService;

    public int createHlhtZybcjlZkjl(HlhtZybcjlZkjl hlhtZybcjlZkjl) {
        return this.hlhtZybcjlZkjlDao.insertHlhtZybcjlZkjl(hlhtZybcjlZkjl);
    }

    public int modifyHlhtZybcjlZkjl(HlhtZybcjlZkjl hlhtZybcjlZkjl) {
        return this.hlhtZybcjlZkjlDao.updateHlhtZybcjlZkjl(hlhtZybcjlZkjl);
    }

    public int removeHlhtZybcjlZkjl(HlhtZybcjlZkjl hlhtZybcjlZkjl) {
        return this.hlhtZybcjlZkjlDao.deleteHlhtZybcjlZkjl(hlhtZybcjlZkjl);
    }

    public HlhtZybcjlZkjl getHlhtZybcjlZkjl(HlhtZybcjlZkjl hlhtZybcjlZkjl) {
        return this.hlhtZybcjlZkjlDao.selectHlhtZybcjlZkjl(hlhtZybcjlZkjl);
    }

    public int getHlhtZybcjlZkjlCount(HlhtZybcjlZkjl hlhtZybcjlZkjl) {
        return (Integer) this.hlhtZybcjlZkjlDao.selectHlhtZybcjlZkjlCount(hlhtZybcjlZkjl);
    }

    public List<HlhtZybcjlZkjl> getHlhtZybcjlZkjlList(HlhtZybcjlZkjl hlhtZybcjlZkjl) {
        return this.hlhtZybcjlZkjlDao.selectHlhtZybcjlZkjlList(hlhtZybcjlZkjl);
    }

    public List<HlhtZybcjlZkjl> getHlhtZybcjlZkjlPageList(HlhtZybcjlZkjl hlhtZybcjlZkjl) {
        return this.hlhtZybcjlZkjlDao.selectHlhtZybcjlZkjlPageList(hlhtZybcjlZkjl);
    }

    private HlhtZybcjlZkjl getInitialHlhtZybcjlZkjl(HlhtZybcjlZkjl entity) {
        return this.hlhtZybcjlZkjlDao.selectInitialHlhtZybcjlZkjl(entity);
    }


    @Override
    public MbzDataCheck interfaceHlhtZybcjlZkjl(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);
        List<MbzDataSet> rDataSetList = new ArrayList<>();
        String[] rCode = {"zrrq", "zrksdm", "zrks", "zrysbm", "zrysqm", "zrzljh"};
        List<MbzDataSet> cDataSetList = new ArrayList<>();
        for (MbzDataSet dataSet : mbzDataSetList) {
            //修正诊断字段配置集合
            for (int i = 0; i < rCode.length; i++) {
                if (rCode[i].equals(dataSet.getPyCode())) {
                    rDataSetList.add(dataSet);
                } else {
                    cDataSetList.add(dataSet);
                }
            }
        }


        //获取首次病程的对象集合
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlZkjl.class);
        //for(MbzDataListSet dataListSet :dataListSets){
        //2.根据首次病程去找到对应的病人病历
        HlhtZybcjlZkjl oneZkjl = new HlhtZybcjlZkjl();
        oneZkjl.getMap().put("sourceType", Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE);
        oneZkjl.getMap().put("startDate", t.getMap().get("startDate"));
        oneZkjl.getMap().put("endDate", t.getMap().get("endDate"));
        oneZkjl.getMap().put("syxh", t.getMap().get("syxh"));
        oneZkjl.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        oneZkjl.getMap().put("regex", t.getMap().get("regex"));
        List<HlhtZybcjlZkjl> hlhtZybcjlZkjls = this.hlhtZybcjlZkjlDao.selectHlhtZybcjlZkjlListByProc(oneZkjl);

        if (hlhtZybcjlZkjls != null) {
            emr_count = emr_count + hlhtZybcjlZkjls.size();
            for (HlhtZybcjlZkjl obj : hlhtZybcjlZkjls) {
                if (obj.getMxfldm().equals("B-8405")) { //转出记录
                    HlhtZybcjlZkjl zkjl = new HlhtZybcjlZkjl();
                    zkjl.setYjlxh(obj.getYjlxh());
                    zkjl = this.getHlhtZybcjlZkjl(zkjl);

                    if (zkjl != null) {
                        //初始化数据
                        HlhtZybcjlZkjl oldRcyjl = new HlhtZybcjlZkjl();
                        oldRcyjl.setYjlxh(obj.getYjlxh());
                        this.removeHlhtZybcjlZkjl(oldRcyjl);
                        //清除日志
                        Map<String, Object> param = new HashMap<>();
                        param.put("SOURCE_ID", obj.getYjlxh());
                        param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE);
                        mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                    }
                    Document document = null;
                    try {
                        document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                    } catch (IOException e) {
                        logger.error("解析病历报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                        String log = Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE +"||"+getClass().toString()+"||"+"解析病历报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                        mbzLogService.createMbzLog(log);
                        continue;
                    }
                    obj = (HlhtZybcjlZkjl) HicHelper.initModelValue(cDataSetList, document, obj, paramTypeMap);
                    obj.setZkjllx("1");
                    obj.setZkjllxmc("转入记录");
                    ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_ZKJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                    //this.createHlhtZybcjlZkjl(obj);
                    try {
                        this.createHlhtZybcjlZkjl(obj);
                    } catch (Exception e) {
                        logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                        continue;
                    }
                    //插入日志
                    try {
                        mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                                Long.parseLong(Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE),
                                Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                                obj.getFssj(),
                                obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                                obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE), obj, 1),
                                PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE), obj, 0)));
                    } catch (Exception e) {
                        logger.error("病历百分比计算报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                        continue;
                    }


                } else { //转入记录
                    //找出对应的转出记录，update它的值
                    EmrQtbljlk qt = new EmrQtbljlk();
                    qt.setCjsj(obj.getCjsj());
                    qt.setSyxh(Integer.parseInt(obj.getSyxh()));
                    String yjlxh = emrQtbljlkDao.selectEmrQtbljlkId(qt);
                    HlhtZybcjlZkjl zkjl = new HlhtZybcjlZkjl();
                    zkjl.setYjlxh(yjlxh);
                    List<HlhtZybcjlZkjl> zkjls = this.getHlhtZybcjlZkjlList(zkjl);
                    //System.out.println("奇葩==" + zkjls.size());
                    if (zkjls.size() > 0) {
                        zkjl = zkjls.get(0);
                        zkjl.setZrrq(null);
                        zkjl.setZrysbm(null);
                        zkjl.setZrysqm(null);
                        Document document = null;
                        try {
                            document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                        } catch (IOException e) {
                            logger.error("解析病历报错,病历名称：{},源记录序号{}",  obj.getBlmc(),obj.getYjlxh());
                            String log = Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE +"||"+getClass().toString()+"||"+"病历百分比计算报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                            mbzLogService.createMbzLog(log);
                            continue;
                        }
                        zkjl = (HlhtZybcjlZkjl) HicHelper.initModelValue(rDataSetList, document, zkjl, paramTypeMap);
                        ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_ZKJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                        this.modifyHlhtZybcjlZkjl(zkjl);

                    }
                }
                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZybcjlZkjlSplitByProc(oneZkjl);


        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(hlhtZybcjlZkjls.size(), real_count, Integer.parseInt(Constants.WN_ZYBCJL_ZKJL_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }


}