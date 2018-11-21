package com.winning.hic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.dao.hdw.SplitTableDao;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.base.utils.Base64Utils;
import com.winning.hic.base.utils.HicHelper;
import com.winning.hic.base.utils.PercentUtil;
import com.winning.hic.base.utils.ReflectUtil;
import com.winning.hic.base.utils.XmlUtil;

import com.winning.hic.dao.cmdatacenter.MbzDataSetDao;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.EmrQtbljlkDao;
import com.winning.hic.dao.hdw.HlhtCommonQueryDao;
import com.winning.hic.dao.hdw.HlhtZybcjlSjyscfjlDao;
import com.winning.hic.model.EmrQtbljlk;
import com.winning.hic.model.HlhtZybcjlSjyscfjl;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.HlhtZybcjlSjyscfjlService;
import com.winning.hic.service.MbzDataCheckService;


/**
* @author HLHT
* @title HLHT_ZYBCJL_SJYSCFJL
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-34-31 16:34:17
*/
@Service
public class HlhtZybcjlSjyscfjlServiceImpl implements  HlhtZybcjlSjyscfjlService {

    private static final Logger logger = LoggerFactory.getLogger(HlhtZybcjlSjyscfjlServiceImpl.class);
    @Autowired
    private HlhtZybcjlSjyscfjlDao hlhtZybcjlSjyscfjlDao;
    @Autowired
    private HlhtCommonQueryDao hlhtCommonQueryDao;
    @Autowired
    private MbzDataSetDao mbzDataSetDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;


    public int createHlhtZybcjlSjyscfjl(HlhtZybcjlSjyscfjl hlhtZybcjlSjyscfjl){
        return this.hlhtZybcjlSjyscfjlDao.insertHlhtZybcjlSjyscfjl(hlhtZybcjlSjyscfjl);
    }

    public int modifyHlhtZybcjlSjyscfjl(HlhtZybcjlSjyscfjl hlhtZybcjlSjyscfjl){
        return this.hlhtZybcjlSjyscfjlDao.updateHlhtZybcjlSjyscfjl(hlhtZybcjlSjyscfjl);
    }

    public int removeHlhtZybcjlSjyscfjl(HlhtZybcjlSjyscfjl hlhtZybcjlSjyscfjl){
        return this.hlhtZybcjlSjyscfjlDao.deleteHlhtZybcjlSjyscfjl(hlhtZybcjlSjyscfjl);
    }

    public HlhtZybcjlSjyscfjl getHlhtZybcjlSjyscfjl(HlhtZybcjlSjyscfjl hlhtZybcjlSjyscfjl){
        return this.hlhtZybcjlSjyscfjlDao.selectHlhtZybcjlSjyscfjl(hlhtZybcjlSjyscfjl);
    }

    public int getHlhtZybcjlSjyscfjlCount(HlhtZybcjlSjyscfjl hlhtZybcjlSjyscfjl){
        return (Integer)this.hlhtZybcjlSjyscfjlDao.selectHlhtZybcjlSjyscfjlCount(hlhtZybcjlSjyscfjl);
    }

    public List<HlhtZybcjlSjyscfjl> getHlhtZybcjlSjyscfjlList(HlhtZybcjlSjyscfjl hlhtZybcjlSjyscfjl){
        return this.hlhtZybcjlSjyscfjlDao.selectHlhtZybcjlSjyscfjlList(hlhtZybcjlSjyscfjl);
    }

    public List<HlhtZybcjlSjyscfjl> getHlhtZybcjlSjyscfjlPageList(HlhtZybcjlSjyscfjl hlhtZybcjlSjyscfjl){
        return this.hlhtZybcjlSjyscfjlDao.selectHlhtZybcjlSjyscfjlPageList(hlhtZybcjlSjyscfjl);
    }

    @Override
    public List<MbzDataCheck> interfaceHlhtZybcjlSjyscfjl(MbzDataCheck entity) throws Exception {
        List<MbzDataCheck> dataChecks = null;
        int emr_count =0;//病历数量
        int real_count=0;//实际数量
        //配置接口表字段配置信息
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetDao.selectMbzDataSetList(mbzDataSet);

        mbzDataSet = new MbzDataSet();
        mbzDataSet.setPId(0L);
        mbzDataSet.setSourceType(Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE);
        mbzDataSet = mbzDataSetDao.selectMbzDataSet(mbzDataSet);


        //获取接口对象字段集合信息
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtZybcjlSjyscfjl.class);

        String[] bcCode = {"bzlzms"};
        List<MbzDataSet> bzlzmsDataSetList = new ArrayList<>();
        for (MbzDataSet dataSet : mbzDataSetList) {
            for (int i = 0; i < bcCode.length; i++) {
                if (bcCode[i].equals(dataSet.getPyCode())) {
                    bzlzmsDataSetList.add(dataSet);
                }
            }
        }
        HlhtZybcjlSjyscfjl hlht = new HlhtZybcjlSjyscfjl();
        hlht.getMap().put("sourceType",Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE);
        hlht.getMap().put("startDate",entity.getMap().get("startDate"));
        hlht.getMap().put("endDate",entity.getMap().get("endDate"));
        hlht.getMap().put("syxh",entity.getMap().get("syxh"));
        hlht.getMap().put("yljgdm", entity.getMap().get("yljgdm"));
        hlht.getMap().put("regex", entity.getMap().get("regex"));


        List<HlhtZybcjlSjyscfjl> list = this.hlhtZybcjlSjyscfjlDao.selectHlhtZybcjlSjyscfjlListByProc(hlht);
        if(list != null && list.size() > 0) {
            emr_count = emr_count + list.size();
            for(HlhtZybcjlSjyscfjl obj:list){
                //获取接口数据
                HlhtZybcjlSjyscfjl oldObj = new HlhtZybcjlSjyscfjl();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getHlhtZybcjlSjyscfjl(oldObj);
                //解析病历xml
                Document document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
                //System.out.println(Base64Utils.unzipEmrXml(emrQtbljlk.getBlnr()));
                //判断是否存在重复,存在则删除，重新新增
                if(oldObj != null ){
                    //初始化数据
                    HlhtZybcjlSjyscfjl oldRcyjl  = new HlhtZybcjlSjyscfjl();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeHlhtZybcjlSjyscfjl(oldRcyjl);
                    //清除日志
                    Map<String,Object> param = new HashMap<>();
                    param.put("SOURCE_ID",obj.getYjlxh());
                    param.put("SOURCE_TYPE",Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (HlhtZybcjlSjyscfjl) HicHelper.initModelValue(mbzDataSetList,document,obj,paramTypeMap);
                Map<String,Object> param = new HashMap<>();
                param.put("syxh",obj.getSyxh());
                param.put("keyWord","入院记录(中医入院记录)");
                List<EmrQtbljlk> qtbljlkList1 = this.hlhtCommonQueryDao.selectEmrQtbljlkListByProc(param);
                Document bzlzmsDocument = null;
                //辨证论治详细描述
                if (qtbljlkList1.size() >= 1) {
                    mbzDataSetList.removeAll(bzlzmsDataSetList);
                    bzlzmsDocument = XmlUtil.getDocument(Base64Utils.unzipEmrXml(qtbljlkList1.get(0).getBlnr()));
                }
                //辨证论治详细描述
                if (bzlzmsDataSetList != null) {
                    obj = (HlhtZybcjlSjyscfjl) HicHelper.initModelValue(bzlzmsDataSetList, bzlzmsDocument, obj, paramTypeMap);
                }

                this.createHlhtZybcjlSjyscfjl(obj);
                this.splitTableDao.selectAnmrZybcjlSjyscfjlSplitByProc(hlht);
                //插入日志
                mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                        Long.parseLong(Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE),
                        Long.parseLong(obj.getYjlxh()), obj.getBlmc(),obj.getSyxh()+"",
                        obj.getFssj(),
                        obj.getPatid(),obj.getZyh(),obj.getHzxm(),obj.getXbmc(),obj.getXbdm(),
                        obj.getKsmc(),obj.getKsdm(), obj.getBqmc(),obj.getBqdm(), obj.getSfzhm(),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE), obj, 1),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE), obj, 0)));
                real_count++;
            }

        }else{
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集",mbzDataSet.getRecordName());
        }
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(list.size(),real_count,Integer.parseInt(Constants.WN_ZYBCJL_SJYSCFJL_SOURCE_TYPE),entity);

        return dataChecks;
    }
}