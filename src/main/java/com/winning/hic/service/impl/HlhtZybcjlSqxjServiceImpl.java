package com.winning.hic.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzDataListSetDao;
import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtZybcjlSqxjDao;
import com.winning.hic.model.HlhtZybcjlSqxj;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtZybcjlSqxjService;
import com.winning.hic.service.MbzDataCheckService;


/**
* @author HLHT
* @title HLHT_ZYBCJL_SQXJ
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-34-31 16:34:33
*/
@Service
public class HlhtZybcjlSqxjServiceImpl implements  HlhtZybcjlSqxjService {

    private static final Logger logger = LoggerFactory.getLogger(HlhtZybcjlSqxjServiceImpl.class);
    @Autowired
    private HlhtZybcjlSqxjDao hlhtZybcjlSqxjDao;
    @Autowired
    private MbzDataListSetDao mbzDataListSetDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private EmrQtbljlkDao emrQtbljlkDao;
    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;


    public int createHlhtZybcjlSqxj(HlhtZybcjlSqxj hlhtZybcjlSqxj){
        return this.hlhtZybcjlSqxjDao.insertHlhtZybcjlSqxj(hlhtZybcjlSqxj);
    }

    public int modifyHlhtZybcjlSqxj(HlhtZybcjlSqxj hlhtZybcjlSqxj){
        return this.hlhtZybcjlSqxjDao.updateHlhtZybcjlSqxj(hlhtZybcjlSqxj);
    }

    public int removeHlhtZybcjlSqxj(HlhtZybcjlSqxj hlhtZybcjlSqxj){
        return this.hlhtZybcjlSqxjDao.deleteHlhtZybcjlSqxj(hlhtZybcjlSqxj);
    }

    public HlhtZybcjlSqxj getHlhtZybcjlSqxj(HlhtZybcjlSqxj hlhtZybcjlSqxj){
        return this.hlhtZybcjlSqxjDao.selectHlhtZybcjlSqxj(hlhtZybcjlSqxj);
    }

    public int getHlhtZybcjlSqxjCount(HlhtZybcjlSqxj hlhtZybcjlSqxj){
        return (Integer)this.hlhtZybcjlSqxjDao.selectHlhtZybcjlSqxjCount(hlhtZybcjlSqxj);
    }

    public List<HlhtZybcjlSqxj> getHlhtZybcjlSqxjList(HlhtZybcjlSqxj hlhtZybcjlSqxj){
        return this.hlhtZybcjlSqxjDao.selectHlhtZybcjlSqxjList(hlhtZybcjlSqxj);
    }

    public List<HlhtZybcjlSqxj> getHlhtZybcjlSqxjPageList(HlhtZybcjlSqxj hlhtZybcjlSqxj){
        return this.hlhtZybcjlSqxjDao.selectHlhtZybcjlSqxjPageList(hlhtZybcjlSqxj);
    }

    @Override
    public List<MbzDataCheck> interfaceHlhtZybcjlSqxj(MbzDataCheck entity) throws Exception {
        List<MbzDataCheck> dataChecks = null;
        int emr_count =0;//病历数量
        int real_count=0;//实际数量

        //加载需要抽取的数据的字段信息
        MbzDataSet dataSet = new MbzDataSet();
        dataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE));
        dataSet.setSourceType(Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE);
        List<MbzDataSet> mbzDataSetList = mbzDataSetDao.selectMbzDataSetList(dataSet);
        //查询
        dataSet = new MbzDataSet();
        dataSet.setPId(0L);
        dataSet.setSourceType(Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE);
        dataSet = mbzDataSetDao.selectMbzDataSet(dataSet);

        Map<String,String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlSqxj.class);

        HlhtZybcjlSqxj hlht = new HlhtZybcjlSqxj();
        hlht.getMap().put("sourceType",Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE);
        hlht.getMap().put("startDate",entity.getMap().get("startDate"));
        hlht.getMap().put("endDate",entity.getMap().get("endDate"));
        hlht.getMap().put("syxh",entity.getMap().get("syxh"));

        List<HlhtZybcjlSqxj> list = this.hlhtZybcjlSqxjDao.selectHlhtZybcjlSqxjListByProc(hlht);
        if(list != null && list.size() > 0){
            emr_count = emr_count+list.size();
            for(HlhtZybcjlSqxj obj:list){
                //获取接口数据
                HlhtZybcjlSqxj oldObj = new HlhtZybcjlSqxj();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getHlhtZybcjlSqxj(oldObj);
                //解析病历xml
                Document document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                //System.out.println(Base64Utils.unzipEmrXml(emrQtbljlk.getBlnr()));
                //判断是否存在重复,存在则删除，重新新增
                if(oldObj != null ){
                    //初始化数据
                    HlhtZybcjlSqxj oldRcyjl  = new HlhtZybcjlSqxj();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeHlhtZybcjlSqxj(oldRcyjl);
                    //清除日志
                    Map<String,Object> param = new HashMap<>();
                    param.put("SOURCE_ID",obj.getYjlxh());
                    param.put("SOURCE_TYPE",Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (HlhtZybcjlSqxj) HicHelper.initModelValue(mbzDataSetList,document,obj,paramTypeMap);
                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.ZYBCJL_SQXJ),SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtZybcjlSqxj(obj);
                //插入日志
                mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                        Long.parseLong(Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE),
                        Long.parseLong(obj.getYjlxh()), obj.getBlmc(),obj.getSyxh()+"",
                        obj.getFssj(),
                        obj.getPatid(),obj.getZyh(),obj.getHzxm(),obj.getXbmc(),obj.getXbdm(),
                        "NA","NA",  "NA","NA", obj.getSfzhm(),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE), obj, 1),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE), obj, 0)));
                real_count++;
            }
        }else{
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集",dataSet.getRecordName());
        }
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count,real_count,Integer.parseInt(Constants.WN_ZYBCJL_SQXJ_SOURCE_TYPE),entity);

        return dataChecks;
    }
}