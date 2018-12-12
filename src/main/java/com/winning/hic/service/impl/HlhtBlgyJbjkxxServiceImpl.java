package com.winning.hic.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.dao.hdw.SplitTableDao;
import com.winning.hic.model.MbzDictInfo;
import com.winning.hic.service.MbzDictInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.base.utils.PercentUtil;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.HlhtBlgyJbjkxxDao;
import com.winning.hic.model.HlhtBlgyJbjkxx;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtBlgyJbjkxxService;
import com.winning.hic.service.MbzDataCheckService;


/**
 * @author HLHT
 * @title HLHT_BLGY_JBJKXX
 * @email Winning Health
 * @package com.winning.hic.service.impl
 * @date 2018-28-31 16:28:56
 */
@Service
public class HlhtBlgyJbjkxxServiceImpl implements HlhtBlgyJbjkxxService {

    private final Logger logger = LoggerFactory.getLogger(HlhtBlgyJbjkxxServiceImpl.class);
    @Autowired
    private HlhtBlgyJbjkxxDao hlhtBlgyJbjkxxDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzDictInfoService mbzDictInfoService;

    public int createHlhtBlgyJbjkxx(HlhtBlgyJbjkxx hlhtBlgyJbjkxx) {
        return this.hlhtBlgyJbjkxxDao.insertHlhtBlgyJbjkxx(hlhtBlgyJbjkxx);
    }

    public int modifyHlhtBlgyJbjkxx(HlhtBlgyJbjkxx hlhtBlgyJbjkxx) {
        return this.hlhtBlgyJbjkxxDao.updateHlhtBlgyJbjkxx(hlhtBlgyJbjkxx);
    }

    public int removeHlhtBlgyJbjkxx(HlhtBlgyJbjkxx hlhtBlgyJbjkxx) {
        return this.hlhtBlgyJbjkxxDao.deleteHlhtBlgyJbjkxx(hlhtBlgyJbjkxx);
    }

    public HlhtBlgyJbjkxx getHlhtBlgyJbjkxx(HlhtBlgyJbjkxx hlhtBlgyJbjkxx) {
        return this.hlhtBlgyJbjkxxDao.selectHlhtBlgyJbjkxx(hlhtBlgyJbjkxx);
    }

    public int getHlhtBlgyJbjkxxCount(HlhtBlgyJbjkxx hlhtBlgyJbjkxx) {
        return (Integer) this.hlhtBlgyJbjkxxDao.selectHlhtBlgyJbjkxxCount(hlhtBlgyJbjkxx);
    }

    public List<HlhtBlgyJbjkxx> getHlhtBlgyJbjkxxList(HlhtBlgyJbjkxx hlhtBlgyJbjkxx) {
        return this.hlhtBlgyJbjkxxDao.selectHlhtBlgyJbjkxxList(hlhtBlgyJbjkxx);
    }

    public List<HlhtBlgyJbjkxx> getHlhtBlgyJbjkxxPageList(HlhtBlgyJbjkxx hlhtBlgyJbjkxx) {
        return this.hlhtBlgyJbjkxxDao.selectHlhtBlgyJbjkxxPageList(hlhtBlgyJbjkxx);
    }

    @Override
    public MbzDataCheck interfaceHlhtBlgyJbjkxx(MbzDataCheck entity) {
        //获取数据集字典表中配置，判断是否需要抽取
        MbzDictInfo mbzDictInfo = new MbzDictInfo();
        mbzDictInfo.setDictCode("platformTableName");
        mbzDictInfo.setDictValue(Constants.WN_BLGY_JBJKXX_SOURCE_TYPE);
        mbzDictInfo = mbzDictInfoService.getMbzDictInfo(mbzDictInfo);
        if (mbzDictInfo == null || mbzDictInfo.getStatus() != 1) {
            //数据集不存在或者未配置需要抽取
            return new MbzDataCheck();
        }

        int emr_count = 0;//病历数量
        int real_count = 0;//实际数量        //实际数量

        HlhtBlgyJbjkxx jbjkxx = new HlhtBlgyJbjkxx();
        jbjkxx.getMap().put("startDate", entity.getMap().get("startDate"));
        jbjkxx.getMap().put("endDate", entity.getMap().get("endDate"));
        jbjkxx.getMap().put("syxh", entity.getMap().get("syxh"));
        jbjkxx.getMap().put("yljgdm", entity.getMap().get("yljgdm"));
        jbjkxx.getMap().put("regex", entity.getMap().get("regex"));
        jbjkxx.getMap().put("sourceType", "1");
        List<HlhtBlgyJbjkxx> jbjkxxListMZ = hlhtBlgyJbjkxxDao.selectHlhtBlgyJbjkxxListByProc(jbjkxx);
        jbjkxx.getMap().put("sourceType", "2");
        List<HlhtBlgyJbjkxx> jbjkxxList = hlhtBlgyJbjkxxDao.selectHlhtBlgyJbjkxxListByProc(jbjkxx);
        jbjkxxList.addAll(jbjkxxListMZ);
        emr_count = jbjkxxList.size();
        for (HlhtBlgyJbjkxx obj : jbjkxxList) {
            //清除历史数据
            HlhtBlgyJbjkxx tempJbxx = new HlhtBlgyJbjkxx();
            tempJbxx.setYjlxh(obj.getYjlxh());
            this.hlhtBlgyJbjkxxDao.deleteHlhtBlgyJbjkxx(tempJbxx);
            //清除日志
            Map<String, Object> param = new HashMap<>();
            param.put("SOURCE_ID", obj.getYjlxh());
            param.put("SOURCE_TYPE", Constants.WN_BLGY_JBJKXX_SOURCE_TYPE);
            mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);

            logger.info("Model:{}", obj);
            //创建新的数据
            try {
                this.createHlhtBlgyJbjkxx(obj);
            } catch (Exception e) {
                logger.error("数据入库报错,病历名称：{},源记录序号{},错误原因：{}", obj.getBlmc(), obj.getYjlxh(),e.getMessage());
                continue;
            }
            //插入日志
            try {
                mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                        Long.parseLong(Constants.WN_BLGY_JBJKXX_SOURCE_TYPE),
                        Long.parseLong(obj.getYjlxh()), "基本健康信息表", obj.getSyxh() + "", new Timestamp(obj.getGxsj().getTime()),
                        obj.getPatid(), obj.getZyh(), obj.getHzxm(), obj.getXbmc(), obj.getXbdm(),
                        "NA", "NA", "NA", "NA", obj.getSfzhm(),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_BLGY_JBJKXX_SOURCE_TYPE), obj, 1),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_BLGY_JBJKXX_SOURCE_TYPE), obj, 0)));
            } catch (Exception e) {
                //e.printStackTrace();
                logger.error("病历百分比计算报错,病历名称：{},源记录序号{}", obj.getBlmc(), obj.getYjlxh());
                continue;
            }
            real_count++;
        }
        this.splitTableDao.selectAnmrBlgyJbjkxxSplitByProc(jbjkxx);
        entity.getMap().put("sourceType", Constants.WN_BLGY_JBJKXX_SOURCE_TYPE);
        this.splitTableDao.updateDcTableData(entity);
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(jbjkxxList.size(), real_count, Integer.parseInt(Constants.WN_BLGY_JBJKXX_SOURCE_TYPE), entity);
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        mbzDataCheck.setDataCount(emr_count);
        mbzDataCheck.setRealCount(real_count);
        return mbzDataCheck;
    }
}