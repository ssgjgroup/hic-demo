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
import com.winning.hic.dao.hdw.HlhtZybcjlQjjlDao;
import com.winning.hic.service.HlhtZybcjlQjjlService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_QJJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-33-31 16:33:49
 */
@Service
public class HlhtZybcjlQjjlServiceImpl implements HlhtZybcjlQjjlService {
    private final Logger logger = LoggerFactory.getLogger(HlhtZybcjlQjjlServiceImpl.class);

    @Autowired
    private HlhtZybcjlQjjlDao hlhtZybcjlQjjlDao;
    @Autowired
    private SplitTableDao splitTableDao;

    @Autowired
    private MbzDataSetService mbzDataSetService;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtZybcjlQjjl(HlhtZybcjlQjjl hlhtZybcjlQjjl) {
        return this.hlhtZybcjlQjjlDao.insertHlhtZybcjlQjjl(hlhtZybcjlQjjl);
    }

    public int modifyHlhtZybcjlQjjl(HlhtZybcjlQjjl hlhtZybcjlQjjl) {
        return this.hlhtZybcjlQjjlDao.updateHlhtZybcjlQjjl(hlhtZybcjlQjjl);
    }

    public int removeHlhtZybcjlQjjl(HlhtZybcjlQjjl hlhtZybcjlQjjl) {
        return this.hlhtZybcjlQjjlDao.deleteHlhtZybcjlQjjl(hlhtZybcjlQjjl);
    }

    public HlhtZybcjlQjjl getHlhtZybcjlQjjl(HlhtZybcjlQjjl hlhtZybcjlQjjl) {
        return this.hlhtZybcjlQjjlDao.selectHlhtZybcjlQjjl(hlhtZybcjlQjjl);
    }

    public int getHlhtZybcjlQjjlCount(HlhtZybcjlQjjl hlhtZybcjlQjjl) {
        return (Integer) this.hlhtZybcjlQjjlDao.selectHlhtZybcjlQjjlCount(hlhtZybcjlQjjl);
    }

    public List<HlhtZybcjlQjjl> getHlhtZybcjlQjjlList(HlhtZybcjlQjjl hlhtZybcjlQjjl) {
        return this.hlhtZybcjlQjjlDao.selectHlhtZybcjlQjjlList(hlhtZybcjlQjjl);
    }

    public List<HlhtZybcjlQjjl> getHlhtZybcjlQjjlPageList(HlhtZybcjlQjjl hlhtZybcjlQjjl) {
        return this.hlhtZybcjlQjjlDao.selectHlhtZybcjlQjjlPageList(hlhtZybcjlQjjl);
    }

    public HlhtZybcjlQjjl getInitialHlhtZybcjlQjjl(HlhtZybcjlQjjl t) {
        return this.hlhtZybcjlQjjlDao.selectInitialHlhtZybcjlQjjl(t);
    }

    @Override
    public MbzDataCheck interfaceHlhtZybcjlQjjl(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
//执行过程信息记录

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量        //实际数量

        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

        //获取首次病程的对象集合
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlQjjl.class);
        //for(MbzDataListSet dataListSet :dataListSets) {
        //2.根据首次病程去找到对应的病人病历
        HlhtZybcjlQjjl oneQjjl = new HlhtZybcjlQjjl();
        oneQjjl.getMap().put("startDate", t.getMap().get("startDate"));
        oneQjjl.getMap().put("endDate", t.getMap().get("endDate"));
        oneQjjl.getMap().put("syxh", t.getMap().get("syxh"));
        oneQjjl.getMap().put("sourceType", Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE);
        oneQjjl.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        oneQjjl.getMap().put("regex", t.getMap().get("regex"));

        List<HlhtZybcjlQjjl> hlhtZybcjlQjjls = this.hlhtZybcjlQjjlDao.selectHlhtZybcjlQjjlListByProc(oneQjjl);
        if (hlhtZybcjlQjjls != null) {
            emr_count = emr_count + hlhtZybcjlQjjls.size();
            for (HlhtZybcjlQjjl obj : hlhtZybcjlQjjls) {
                //清库
                HlhtZybcjlQjjl temp = new HlhtZybcjlQjjl();
                temp.setYjlxh(obj.getYjlxh());
                this.removeHlhtZybcjlQjjl(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                try {
                    document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));

                } catch (Exception e) {
                    logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                obj = (HlhtZybcjlQjjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                //处理参加抢救人员数据
                String cjtlmd = obj.getCjqjrymd();
                String cjtldm = obj.getCjqjrydm();
                if(cjtldm.equals(cjtlmd)){
                    cjtlmd = cjtlmd.replace(" ", "");
                    cjtlmd = cjtlmd.replace("副主任医师", "");
                    cjtlmd = cjtlmd.replace("副主治医师", "");
                    cjtlmd = cjtlmd.replace("副住院医师", "");
                    cjtlmd = cjtlmd.replace("住院医师", "");
                    cjtlmd = cjtlmd.replace("主任医师", "");
                    cjtlmd = cjtlmd.replace("主治医师", "");
                    cjtlmd = cjtlmd.replace("规培医师", "");
                    cjtlmd = cjtlmd.replace("实习医师", "");
                    cjtlmd = cjtlmd.replace("基地医师", "");
                    cjtlmd = cjtlmd.replace("医师", "");
                    cjtlmd = cjtlmd.replace("护士长", "");
                    cjtlmd = cjtlmd.replace("护士", "");
                    cjtlmd = cjtlmd.replace("护师", "");
                    cjtlmd = cjtlmd.replace("研究生", "");
                    cjtlmd = cjtlmd.replace("及", "");
                    cjtlmd = cjtlmd.replace("。", "");
                    obj.setCjqjrymd(cjtlmd);
                    obj.setCjqjrydm(cjtlmd);
                }
                //参加讨论人员的数据
                cjtlmd = obj.getCjtlrymd();
                cjtlmd = cjtlmd.replace(" ", "");
                cjtlmd = cjtlmd.replace("副主任医师", "");
                cjtlmd = cjtlmd.replace("副主治医师", "");
                cjtlmd = cjtlmd.replace("副住院医师", "");
                cjtlmd = cjtlmd.replace("住院医师", "");
                cjtlmd = cjtlmd.replace("主任医师", "");
                cjtlmd = cjtlmd.replace("主治医师", "");
                cjtlmd = cjtlmd.replace("规培医师", "");
                cjtlmd = cjtlmd.replace("实习医师", "");
                cjtlmd = cjtlmd.replace("基地医师", "");
                cjtlmd = cjtlmd.replace("医师", "");
                cjtlmd = cjtlmd.replace("护士长", "");
                cjtlmd = cjtlmd.replace("护士", "");
                cjtlmd = cjtlmd.replace("护师", "");
                cjtlmd = cjtlmd.replace("研究生", "");
                cjtlmd = cjtlmd.replace("及", "");
                cjtlmd = cjtlmd.replace("。", "");
                obj.setCjtlrymd(cjtlmd);

                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_QJJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                //this.createHlhtZybcjlQjjl(obj);
                try {
                    this.createHlhtZybcjlQjjl(obj);
                } catch (Exception e) {
                    logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                    continue;
                }
                //插入日志
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh() + "",
                            obj.getFssj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            obj.getKsmc(), obj.getKsdm(), obj.getBqmc(), obj.getBqdm(), obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    //e.printStackTrace();
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;

            }

        }
        this.splitTableDao.selectAnmrZybcjlQjjlSplitByProc(oneQjjl);

        //更新dc表
        t.getMap().put("sourceType",Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(t);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(hlhtZybcjlQjjls.size(), real_count, Integer.parseInt(Constants.WN_ZYBCJL_QJJL_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}