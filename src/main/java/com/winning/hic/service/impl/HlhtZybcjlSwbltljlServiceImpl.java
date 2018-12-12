package com.winning.hic.service.impl;

import java.io.IOException;
import java.util.*;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.*;
import com.winning.hic.service.MbzDictInfoService;
import com.winning.hic.service.MbzLogService;
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
import com.winning.hic.dao.hdw.HlhtZybcjlSwbltljlDao;
import com.winning.hic.service.HlhtZybcjlSwbltljlService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_SWBLTLJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-34-31 16:34:40
 */
@Service
public class HlhtZybcjlSwbltljlServiceImpl implements HlhtZybcjlSwbltljlService {

    private static final Logger logger = LoggerFactory.getLogger(HlhtZybcjlSwbltljlServiceImpl.class);
    @Autowired
    private HlhtZybcjlSwbltljlDao hlhtZybcjlSwbltljlDao;
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
    @Autowired
    private MbzLogService mbzLogService;

    public int createHlhtZybcjlSwbltljl(HlhtZybcjlSwbltljl hlhtZybcjlSwbltljl) {
        return this.hlhtZybcjlSwbltljlDao.insertHlhtZybcjlSwbltljl(hlhtZybcjlSwbltljl);
    }

    public int modifyHlhtZybcjlSwbltljl(HlhtZybcjlSwbltljl hlhtZybcjlSwbltljl) {
        return this.hlhtZybcjlSwbltljlDao.updateHlhtZybcjlSwbltljl(hlhtZybcjlSwbltljl);
    }

    public int removeHlhtZybcjlSwbltljl(HlhtZybcjlSwbltljl hlhtZybcjlSwbltljl) {
        return this.hlhtZybcjlSwbltljlDao.deleteHlhtZybcjlSwbltljl(hlhtZybcjlSwbltljl);
    }

    public HlhtZybcjlSwbltljl getHlhtZybcjlSwbltljl(HlhtZybcjlSwbltljl hlhtZybcjlSwbltljl) {
        return this.hlhtZybcjlSwbltljlDao.selectHlhtZybcjlSwbltljl(hlhtZybcjlSwbltljl);
    }

    public int getHlhtZybcjlSwbltljlCount(HlhtZybcjlSwbltljl hlhtZybcjlSwbltljl) {
        return (Integer) this.hlhtZybcjlSwbltljlDao.selectHlhtZybcjlSwbltljlCount(hlhtZybcjlSwbltljl);
    }

    public List<HlhtZybcjlSwbltljl> getHlhtZybcjlSwbltljlList(HlhtZybcjlSwbltljl hlhtZybcjlSwbltljl) {
        return this.hlhtZybcjlSwbltljlDao.selectHlhtZybcjlSwbltljlList(hlhtZybcjlSwbltljl);
    }

    public List<HlhtZybcjlSwbltljl> getHlhtZybcjlSwbltljlPageList(HlhtZybcjlSwbltljl hlhtZybcjlSwbltljl) {
        return this.hlhtZybcjlSwbltljlDao.selectHlhtZybcjlSwbltljlPageList(hlhtZybcjlSwbltljl);
    }

    @Override
    public MbzDataCheck interfaceHlhtZybcjlSwbltljl(MbzDataCheck entity) throws Exception {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        MbzDataCheck dataChecks = null;
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量
        //加载需要抽取的数据的字段信息
        MbzDataSet dataSet = new MbzDataSet();
        dataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE));
        dataSet.setSourceType(Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE);
        List<MbzDataSet> mbzDataSetList = mbzDataSetDao.selectMbzDataSetList(dataSet);
        //查询
        dataSet = new MbzDataSet();
        dataSet.setPId(0L);
        dataSet.setSourceType(Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE);
        dataSet = mbzDataSetDao.selectMbzDataSet(dataSet);

        //加载实体类中字段(变量信息)
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlSwbltljl.class);

        HlhtZybcjlSwbltljl hlht = new HlhtZybcjlSwbltljl();
        hlht.getMap().put("sourceType", Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE);
        hlht.getMap().put("startDate", entity.getMap().get("startDate"));
        hlht.getMap().put("endDate", entity.getMap().get("endDate"));
        hlht.getMap().put("syxh", entity.getMap().get("syxh"));
        hlht.getMap().put("yljgdm", entity.getMap().get("yljgdm"));
        hlht.getMap().put("regex", entity.getMap().get("regex"));
        List<HlhtZybcjlSwbltljl> list = this.hlhtZybcjlSwbltljlDao.selectHlhtZybcjlSwbltljlListByProc(hlht);
        if (list != null && list.size() > 0) {
            emr_count = emr_count + list.size();
            for (HlhtZybcjlSwbltljl obj : list) {
                //获取接口数据
                HlhtZybcjlSwbltljl oldObj = new HlhtZybcjlSwbltljl();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getHlhtZybcjlSwbltljl(oldObj);
                //解析病历xml
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                } catch (IOException e) {
                    // e.printStackTrace();
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE +"||"+getClass().toString()+"||"+"解析病历报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }
                //判断是否存在重复,存在则删除，重新新增
                if (oldObj != null) {
                    //初始化数据
                    HlhtZybcjlSwbltljl oldRcyjl = new HlhtZybcjlSwbltljl();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeHlhtZybcjlSwbltljl(oldRcyjl);
                    //清除日志
                    Map<String, Object> param = new HashMap<>();
                    param.put("SOURCE_ID", obj.getYjlxh());
                    param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (HlhtZybcjlSwbltljl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                String zcrxm = obj.getZcrxm();
                if(zcrxm !=null){
                    zcrxm = zcrxm.replace(" ", "");
                    zcrxm = zcrxm.replace("副主任医师", "");
                    zcrxm = zcrxm.replace("副主治医师", "");
                    zcrxm = zcrxm.replace("主任医师", "");
                    zcrxm = zcrxm.replace("主治医师", "");
                }
                obj.setZcrxm(zcrxm);
                obj.setZcrbm(zcrxm);
                String cjtlmd = obj.getCjtlmd();
                if(cjtlmd!=null){
                    cjtlmd = cjtlmd.replace("副主任医师", "");
                    cjtlmd = cjtlmd.replace("副主治医师", "");
                    cjtlmd = cjtlmd.replace("副住院医师", "");
                    cjtlmd = cjtlmd.replace("住院医师", "");
                    cjtlmd = cjtlmd.replace("主任医师", "");
                    cjtlmd = cjtlmd.replace("主治医师", "");
                    cjtlmd = cjtlmd.replace("规培医师", "");
                    cjtlmd = cjtlmd.replace("护士长", "");
                    cjtlmd = cjtlmd.replace("实习医师", "");
                    cjtlmd = cjtlmd.replace("基地医师及研究生", "");
                    cjtlmd = cjtlmd.replace("、全体基地与全体", "");
                    cjtlmd = cjtlmd.replace("及各位基地医生", "");
                    cjtlmd = cjtlmd.replace("，全体及研究生", "");
                    cjtlmd = cjtlmd.replace("全体及研究生", "");
                    cjtlmd = cjtlmd.replace("等基地", "");
                    cjtlmd = cjtlmd.replace("基地医生：", "");
                    cjtlmd = cjtlmd.replace("及规培基地医生。", "");
                    cjtlmd = cjtlmd.replace("，全体基地及", "");
                    cjtlmd = cjtlmd.replace("，基地医师等 ", "");
                    cjtlmd = cjtlmd.replace("、基地医师、", "");
                    cjtlmd = cjtlmd.replace("住院医生", "");
                    cjtlmd = cjtlmd.replace("主任医生", "");
                    cjtlmd = cjtlmd.replace("主治医生", "");
                    cjtlmd = cjtlmd.replace("规培医生", "");

                    cjtlmd = cjtlmd.replace("责任护士", "");
                    cjtlmd = cjtlmd.replace("护士长", "");
                    cjtlmd = cjtlmd.replace("实习医师", "");
                    cjtlmd = cjtlmd.replace(",基地和全体", "");
                    cjtlmd = cjtlmd.replace(",全体基地,及研究生", "");
                    cjtlmd = cjtlmd.replace(",基地医师等", "");
                    cjtlmd = cjtlmd.replace("及全体实习生", ",");
                    cjtlmd = cjtlmd.replace(",全体进修及基地医师", ",");
                    cjtlmd = cjtlmd.replace("管护师", ",");
                    cjtlmd = cjtlmd.replace("及全体规培及研究生。", ",");/**/
                    cjtlmd = cjtlmd.replace(",全体进修及基地医师", ",");
                    cjtlmd = cjtlmd.replace("及全体规培及研究生。", ",");
                    cjtlmd = cjtlmd.replace(",全体基地和实习同学", ",");
                    cjtlmd = cjtlmd.replace("医师", "");
                    cjtlmd = cjtlmd.replace("副主任", "");
                    cjtlmd = cjtlmd.replace("副主治", "");
                    cjtlmd = cjtlmd.replace("副住院", "");
                    cjtlmd = cjtlmd.replace("主任", "");
                    cjtlmd = cjtlmd.replace("主治", "");
                    cjtlmd = cjtlmd.replace("住院", "");
                    cjtlmd = cjtlmd.replace("规培", "");
                    cjtlmd = cjtlmd.replace("、", ",");
                    cjtlmd = cjtlmd.replace("，", ",");
                    cjtlmd = cjtlmd.replace(",,", ",");
                    cjtlmd = cjtlmd.replace(",", " ");
                    obj.setCjtlmd(cjtlmd);
                    obj.setTlrybm(cjtlmd);
                }
                obj.setCjtlmd("NA");
                obj.setTlrybm("NA");
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_SWBLTLJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                //this.createHlhtZybcjlSwbltljl(obj);
                try {
                    this.createHlhtZybcjlSwbltljl(obj);
                } catch (Exception e) {
                    logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                    continue;
                }
                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    //e.printStackTrace();
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    String log = Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE +"||"+getClass().toString()+"||"+"病历百分比计算报错,病历名称：{"+obj.getBlmc()+"},源记录序号{"+obj.getYjlxh()+"}"+"||错误原因:{"+e.getMessage()+"}";
                    mbzLogService.createMbzLog(log);
                    continue;
                }
                real_count++;
            }
        } else {
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集", dataSet.getRecordName());
        }
        this.splitTableDao.selectAnmrZybcjlSwbltljlSplitByProc(hlht);

        //更新dc表
        entity.getMap().put("sourceType",Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(entity);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZYBCJL_SWBLTLJL_SOURCE_TYPE), entity);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}