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
import com.winning.hic.dao.hdw.HlhtZybcjlJjbjlDao;
import com.winning.hic.service.HlhtZybcjlJjbjlService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataSetService;


/**
 * @author HLHT
 * @title HLHT_ZYBCJL_JJBJL
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-33-31 16:33:41
 */
@Service
public class HlhtZybcjlJjbjlServiceImpl implements HlhtZybcjlJjbjlService {
    private final Logger logger = LoggerFactory.getLogger(HlhtZybcjlJjbjlServiceImpl.class);

    @Autowired
    private HlhtZybcjlJjbjlDao hlhtZybcjlJjbjlDao;

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

    public int createHlhtZybcjlJjbjl(HlhtZybcjlJjbjl hlhtZybcjlJjbjl) {
        return this.hlhtZybcjlJjbjlDao.insertHlhtZybcjlJjbjl(hlhtZybcjlJjbjl);
    }

    public int modifyHlhtZybcjlJjbjl(HlhtZybcjlJjbjl hlhtZybcjlJjbjl) {
        return this.hlhtZybcjlJjbjlDao.updateHlhtZybcjlJjbjl(hlhtZybcjlJjbjl);
    }

    public int removeHlhtZybcjlJjbjl(HlhtZybcjlJjbjl hlhtZybcjlJjbjl) {
        return this.hlhtZybcjlJjbjlDao.deleteHlhtZybcjlJjbjl(hlhtZybcjlJjbjl);
    }

    public HlhtZybcjlJjbjl getHlhtZybcjlJjbjl(HlhtZybcjlJjbjl hlhtZybcjlJjbjl) {
        return this.hlhtZybcjlJjbjlDao.selectHlhtZybcjlJjbjl(hlhtZybcjlJjbjl);
    }

    public int getHlhtZybcjlJjbjlCount(HlhtZybcjlJjbjl hlhtZybcjlJjbjl) {
        return (Integer) this.hlhtZybcjlJjbjlDao.selectHlhtZybcjlJjbjlCount(hlhtZybcjlJjbjl);
    }

    public List<HlhtZybcjlJjbjl> getHlhtZybcjlJjbjlList(HlhtZybcjlJjbjl hlhtZybcjlJjbjl) {
        return this.hlhtZybcjlJjbjlDao.selectHlhtZybcjlJjbjlList(hlhtZybcjlJjbjl);
    }

    public List<HlhtZybcjlJjbjl> getHlhtZybcjlJjbjlPageList(HlhtZybcjlJjbjl hlhtZybcjlJjbjl) {
        return this.hlhtZybcjlJjbjlDao.selectHlhtZybcjlJjbjlPageList(hlhtZybcjlJjbjl);
    }

    public HlhtZybcjlJjbjl getInitialHlhtZybcjlJjbjl(HlhtZybcjlJjbjl hlhtZybcjlJjbjl) {
        return this.hlhtZybcjlJjbjlDao.selectInitialHlhtZybcjlJjbjl(hlhtZybcjlJjbjl);
    }

    @Override
    public MbzDataCheck interfaceHlhtZybcjlJjbjl(MbzDataCheck t) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        //执行过程信息记录
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量         MbzDataCheck dataCheckList = new ArrayList<>();//实际数量
        //数据抽取
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlJjbjl.class);
        //获取首次病程的对象集合
        HlhtZybcjlJjbjl oneJjbjl = new HlhtZybcjlJjbjl();
        oneJjbjl.getMap().put("sourceType", Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE);
        oneJjbjl.getMap().put("startDate", t.getMap().get("startDate"));
        oneJjbjl.getMap().put("endDate", t.getMap().get("endDate"));
        oneJjbjl.getMap().put("syxh", t.getMap().get("syxh"));
        oneJjbjl.getMap().put("yljgdm", t.getMap().get("yljgdm"));
        oneJjbjl.getMap().put("regex", t.getMap().get("regex"));

        List<HlhtZybcjlJjbjl> hlhtZybcjlJjbjls = this.hlhtZybcjlJjbjlDao.selectHlhtZybcjlJjbjlListByProc(oneJjbjl);
        emr_count = emr_count + hlhtZybcjlJjbjls.size();
        if (hlhtZybcjlJjbjls != null) {
            for (HlhtZybcjlJjbjl obj : hlhtZybcjlJjbjls) {
                //清库
                HlhtZybcjlJjbjl temp = new HlhtZybcjlJjbjl();
                temp.setYjlxh(obj.getYjlxh());
                this.removeHlhtZybcjlJjbjl(temp);
                //清除日志
                Map<String, Object> param = new HashMap<>();
                param.put("SOURCE_ID", obj.getYjlxh());
                param.put("SOURCE_TYPE", Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE);
                mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                //3.xml文件解析 获取病历信息
                Document document = null;
                if (!StringUtil.isEmptyOrNull(obj.getBlnr())) {
                    try {
                        document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                    } catch (Exception e) {
                        logger.error("解析病历报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                        continue;
                    }
                }
                obj = (HlhtZybcjlJjbjl) HicHelper.initModelValue(mbzDataSetList, document, obj, paramTypeMap);
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_JJBJL), SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtZybcjlJjbjl(obj);
                try {
                    mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                            Long.parseLong(Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE),
                            Long.parseLong(obj.getYjlxh()), obj.getBlmc(), obj.getSyxh(), obj.getJbsj(),
                            obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                            "NA", "NA", "NA", "NA", obj.getSfzhm(),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE), obj, 1),
                            PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE), obj, 0)));
                } catch (Exception e) {
                    //e.printStackTrace();
                    logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                    continue;
                }
                real_count++;
            }
        }
        this.splitTableDao.selectAnmrZybcjlJjbjlSplitByProc(oneJjbjl);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count, real_count, Integer.parseInt(Constants.WN_ZYBCJL_JJBJL_SOURCE_TYPE), t);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}