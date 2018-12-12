package com.winning.hic.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.model.MbzDictInfo;
import com.winning.hic.service.MbzDictInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.base.utils.PercentUtil;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.HlhtBlgyWssjzyDao;
import com.winning.hic.dao.hdw.MZCommonQueryDao;
import com.winning.hic.model.HlhtBlgyWssjzy;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtBlgyWssjzyService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_BLGY_WSSJZY
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-29-31 16:29:04
 */
@Service
public class HlhtBlgyWssjzyServiceImpl implements HlhtBlgyWssjzyService {
    private final Logger logger = LoggerFactory.getLogger(HlhtBlgyJbjkxxServiceImpl.class);

    @Autowired
    private HlhtBlgyWssjzyDao hlhtBlgyWssjzyDao;

    @Autowired
    private MbzDataCheckService mbzDataCheckService;

    @Autowired
    private CommonQueryDao commonQueryDao;

    @Autowired
    private MZCommonQueryDao mzCommonQueryDao;

    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtBlgyWssjzy(HlhtBlgyWssjzy hlhtBlgyWssjzy) {
        return this.hlhtBlgyWssjzyDao.insertHlhtBlgyWssjzy(hlhtBlgyWssjzy);
    }

    public int modifyHlhtBlgyWssjzy(HlhtBlgyWssjzy hlhtBlgyWssjzy) {
        return this.hlhtBlgyWssjzyDao.updateHlhtBlgyWssjzy(hlhtBlgyWssjzy);
    }

    public int removeHlhtBlgyWssjzy(HlhtBlgyWssjzy hlhtBlgyWssjzy) {
        return this.hlhtBlgyWssjzyDao.deleteHlhtBlgyWssjzy(hlhtBlgyWssjzy);
    }

    public HlhtBlgyWssjzy getHlhtBlgyWssjzy(HlhtBlgyWssjzy hlhtBlgyWssjzy) {
        return this.hlhtBlgyWssjzyDao.selectHlhtBlgyWssjzy(hlhtBlgyWssjzy);
    }

    public int getHlhtBlgyWssjzyCount(HlhtBlgyWssjzy hlhtBlgyWssjzy) {
        return (Integer) this.hlhtBlgyWssjzyDao.selectHlhtBlgyWssjzyCount(hlhtBlgyWssjzy);
    }

    public List<HlhtBlgyWssjzy> getHlhtBlgyWssjzyList(HlhtBlgyWssjzy hlhtBlgyWssjzy) {
        return this.hlhtBlgyWssjzyDao.selectHlhtBlgyWssjzyList(hlhtBlgyWssjzy);
    }

    public List<HlhtBlgyWssjzy> getHlhtBlgyWssjzyPageList(HlhtBlgyWssjzy hlhtBlgyWssjzy) {
        return this.hlhtBlgyWssjzyDao.selectHlhtBlgyWssjzyPageList(hlhtBlgyWssjzy);
    }

    @Override
    public MbzDataCheck interfaceHlhtBlgyWssjzy(MbzDataCheck entity) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_BLGY_WSSJZY_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }
        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量


        HlhtBlgyWssjzy wssjzy = new HlhtBlgyWssjzy();
        this.hlhtBlgyWssjzyDao.deleteHlhtBlgyWssjzy(wssjzy);
        wssjzy.getMap().put("startDate", entity.getMap().get("startDate"));
        wssjzy.getMap().put("endDate", entity.getMap().get("endDate"));
        wssjzy.getMap().put("syxh", entity.getMap().get("syxh"));
        List<HlhtBlgyWssjzy> hlhtBlgyWssjzyZyList = hlhtBlgyWssjzyDao.selectInitHlhtBlgyWssjzyListByProc(wssjzy);
        for (HlhtBlgyWssjzy obj : hlhtBlgyWssjzyZyList) {
            //清除历史数据
            HlhtBlgyWssjzy wssjzy1_one = new HlhtBlgyWssjzy();
            wssjzy1_one.setYjlxh(obj.getYjlxh());
            this.hlhtBlgyWssjzyDao.deleteHlhtBlgyWssjzy(wssjzy1_one);
            //清除日志
            Map<String, Object> param = new HashMap<>();
            param.put("SOURCE_ID", obj.getYjlxh());
            param.put("SOURCE_TYPE", Constants.WN_BLGY_WSSJZY_SOURCE_TYPE);
            mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
            logger.info("Model:{}", obj);
            //创建新的数据
            try {
                this.createHlhtBlgyWssjzy(obj);
            } catch (Exception e) {
                logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(), e.getMessage());
                continue;
            }
            try {
                //插入日志
                mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                        Long.parseLong(Constants.WN_BLGY_WSSJZY_SOURCE_TYPE),
                        Long.parseLong(obj.getYjlxh()), "卫生事件摘要表", obj.getSyxh() + "", new Timestamp(obj.getGxsj().getTime()),
                        obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                        "NA", "NA", "NA", "NA", obj.getSfzhm(), PercentUtil.getPercent(Long.parseLong(Constants.WN_BLGY_WSSJZY_SOURCE_TYPE), obj, 1),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_BLGY_WSSJZY_SOURCE_TYPE), obj, 0)));
                real_count++;
            } catch (Exception e) {
                //e.printStackTrace();
                logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                continue;
            }
        }


        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(hlhtBlgyWssjzyZyList.size(), real_count, Integer.parseInt(Constants.WN_BLGY_WSSJZY_SOURCE_TYPE), entity);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}