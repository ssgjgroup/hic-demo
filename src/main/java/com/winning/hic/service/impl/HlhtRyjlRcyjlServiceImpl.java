package com.winning.hic.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.winning.hic.base.SplitParamsConstants;
import com.winning.hic.base.utils.*;
import com.winning.hic.dao.hdw.SplitTableDao;
import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winning.hic.base.Constants;
import com.winning.hic.dao.cmdatacenter.MbzLoadDataInfoDao;
import com.winning.hic.dao.hdw.CommonQueryDao;
import com.winning.hic.dao.hdw.HlhtRyjlRcyjlDao;
import com.winning.hic.model.HlhtRyjlRcyjl;
import com.winning.hic.model.MbzDataCheck;
import com.winning.hic.model.MbzDataSet;
import com.winning.hic.model.MbzLoadDataInfo;
import com.winning.hic.service.EmrQtbljlkService;
import com.winning.hic.service.HlhtRyjlRcyjlService;
import com.winning.hic.service.MbzDataCheckService;
import com.winning.hic.service.MbzDataListSetService;
import com.winning.hic.service.MbzDataSetService;


/**
* @author HLHT
* @title HLHT_RYJL_RCYJL
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-30-31 16:30:31
*/
@Service
public class HlhtRyjlRcyjlServiceImpl implements  HlhtRyjlRcyjlService {

    private static final Logger logger = LoggerFactory.getLogger(HlhtRyjlRcyjlServiceImpl.class);

    @Autowired
    private HlhtRyjlRcyjlDao hlhtRyjlRcyjlDao;
    @Autowired
    private CommonQueryDao commonQueryDao;
    @Autowired
    private SplitTableDao splitTableDao;
    @Autowired
    private MbzDataSetService mbzDataSetService;
    @Autowired
    private MbzDataCheckService mbzDataCheckService;
    @Autowired
    private MbzLoadDataInfoDao mbzLoadDataInfoDao;

    public int createHlhtRyjlRcyjl(HlhtRyjlRcyjl hlhtRyjlRcyjl){
        return this.hlhtRyjlRcyjlDao.insertHlhtRyjlRcyjl(hlhtRyjlRcyjl);
    }

    public int modifyHlhtRyjlRcyjl(HlhtRyjlRcyjl hlhtRyjlRcyjl){
        return this.hlhtRyjlRcyjlDao.updateHlhtRyjlRcyjl(hlhtRyjlRcyjl);
    }

    public int removeHlhtRyjlRcyjl(HlhtRyjlRcyjl hlhtRyjlRcyjl){
        return this.hlhtRyjlRcyjlDao.deleteHlhtRyjlRcyjl(hlhtRyjlRcyjl);
    }

    public HlhtRyjlRcyjl getHlhtRyjlRcyjl(HlhtRyjlRcyjl hlhtRyjlRcyjl){
        return this.hlhtRyjlRcyjlDao.selectHlhtRyjlRcyjl(hlhtRyjlRcyjl);
    }

    public int getHlhtRyjlRcyjlCount(HlhtRyjlRcyjl hlhtRyjlRcyjl){
        return (Integer)this.hlhtRyjlRcyjlDao.selectHlhtRyjlRcyjlCount(hlhtRyjlRcyjl);
    }

    public List<HlhtRyjlRcyjl> getHlhtRyjlRcyjlList(HlhtRyjlRcyjl hlhtRyjlRcyjl){
        return this.hlhtRyjlRcyjlDao.selectHlhtRyjlRcyjlList(hlhtRyjlRcyjl);
    }

    public List<HlhtRyjlRcyjl> getHlhtRyjlRcyjlPageList(HlhtRyjlRcyjl hlhtRyjlRcyjl){
        return this.hlhtRyjlRcyjlDao.selectHlhtRyjlRcyjlPageList(hlhtRyjlRcyjl);
    }

    /**
     *  生成24小时入出院记录
     * @param rcyjl
     */
    @Override
    public HlhtRyjlRcyjl getInitHlhtRyjlRcyjlData(HlhtRyjlRcyjl rcyjl) {
        return  this.commonQueryDao.selectInitHlhtRyjlRcyjlData(rcyjl);
    }

    @Override
    public List<MbzDataCheck> interfaceHlhtRyjlRcyjl(MbzDataCheck entity) throws Exception {
        //执行过程信息记录
        MbzDataCheck mbzDataCheck = new MbzDataCheck();
        int emr_count =0;//病历数量
        int real_count=0;//实际数量
        //配置接口表字段配置信息
        MbzDataSet mbzDataSet = new MbzDataSet();
        mbzDataSet.setSourceType(Constants.WN_RYJL_RCYJL_SOURCE_TYPE);
        mbzDataSet.setPId(Long.parseLong(Constants.WN_RYJL_RCYJL_SOURCE_TYPE));
        List<MbzDataSet> mbzDataSetList = mbzDataSetService.getMbzDataSetList(mbzDataSet);

        mbzDataSet = new MbzDataSet();
        mbzDataSet.setPId(0L);
        mbzDataSet.setSourceType(Constants.WN_RYJL_RCYJL_SOURCE_TYPE);
        mbzDataSet = mbzDataSetService.getMbzDataSet(mbzDataSet);


        //获取接口对象字段集合信息
        Map<String, String> paramTypeMap = ReflectUtil.getParamTypeMap(HlhtRyjlRcyjl.class);

        HlhtRyjlRcyjl ryjlRcyjl = new HlhtRyjlRcyjl();
        ryjlRcyjl.getMap().put("sourceType",Constants.WN_RYJL_RCYJL_SOURCE_TYPE);
        ryjlRcyjl.getMap().put("startDate",entity.getMap().get("startDate"));
        ryjlRcyjl.getMap().put("endDate",entity.getMap().get("endDate"));
        ryjlRcyjl.getMap().put("syxh",entity.getMap().get("syxh"));
        ryjlRcyjl.getMap().put("yljgdm",entity.getMap().get("yljgdm"));
        ryjlRcyjl.getMap().put("regex",entity.getMap().get("regex"));
        List<HlhtRyjlRcyjl> hlhtRyjlRcyjlList = this.hlhtRyjlRcyjlDao.selectHlhtRyjlRcyjlListByProc(ryjlRcyjl);

        if(hlhtRyjlRcyjlList != null && hlhtRyjlRcyjlList.size() > 0){
            emr_count = emr_count+hlhtRyjlRcyjlList.size();
            for(HlhtRyjlRcyjl obj:hlhtRyjlRcyjlList){
                //获取接口数据
                HlhtRyjlRcyjl oldObj = new HlhtRyjlRcyjl();
                oldObj.setYjlxh(String.valueOf(obj.getYjlxh()));
                oldObj = getHlhtRyjlRcyjl(oldObj);
                //解析病历xml
                Document document = XmlUtil.getDocument(Base64Utils.unzipEmrXml(obj.getBlnr()));
               //System.out.println(Base64Utils.unzipEmrXml(emrQtbljlk.getBlnr()));
                //判断是否存在重复,存在则删除，重新新增
                if(oldObj != null ){
                    //初始化数据
                    HlhtRyjlRcyjl oldRcyjl  = new HlhtRyjlRcyjl();
                    oldRcyjl.setYjlxh(String.valueOf(obj.getYjlxh()));
                    this.removeHlhtRyjlRcyjl(oldRcyjl);
                    //清除日志
                    Map<String,Object> param = new HashMap<>();
                    param.put("SOURCE_ID",obj.getYjlxh());
                    param.put("SOURCE_TYPE",Constants.WN_RYJL_RCYJL_SOURCE_TYPE);
                    mbzLoadDataInfoDao.deleteMbzLoadDataInfoBySourceIdAndSourceType(param);
                }
                obj = (HlhtRyjlRcyjl) HicHelper.initModelValue(mbzDataSetList,document,obj,paramTypeMap);
                //去除入院诊断西医病名和代码的冗余字符串
                obj.setRzxzzdbm(obj.getRzxzzdbm() == null ? "NA" : obj.getRzxzzdbm().replace("西医诊断： ", "").trim());
                obj.setRzxyzdmc(obj.getRzxyzdmc() == null ? "NA" : obj.getRzxyzdmc().replace("西医诊断： ", "").trim());
                //去除入院诊断中医病名和代码的冗余字符串
                obj.setRzzybmdm(obj.getRzzybmdm() == null ? "NA" : obj.getRzzybmdm().replace("中医诊断： ", "").trim());
                obj.setRzzybmmc(obj.getRzzybmmc() == null ? "NA" : obj.getRzzybmmc().replace("中医诊断： ", "").trim());
                //去除入院诊断中医症候和代码的冗余字符串
                obj.setRzzyzhdm(obj.getRzzyzhdm() == null ? "NA" : obj.getRzzyzhdm().replace("中医诊断： ", "").trim());
                obj.setRzzyzhmc(obj.getRzzyzhmc() == null ? "NA" : obj.getRzzyzhmc().replace("中医诊断： ", "").trim());

                //去除出院诊断西医病名和代码的冗余字符串
                obj.setCzxyzdbm(obj.getCzxyzdbm() == null ? "NA" : obj.getCzxyzdbm().replace("西医诊断： ", "").trim());
                obj.setCzxyzdmc(obj.getCzxyzdmc() == null ? "NA" : obj.getCzxyzdmc().replace("西医诊断： ", "").trim());
                //去除出院诊断中医病名和代码的冗余字符串
                obj.setCzzybmdm(obj.getCzzybmdm() == null ? "NA" : obj.getCzzybmdm().replace("中医诊断： ", "").trim());
                obj.setCzzybmmc(obj.getCzzybmmc() == null ? "NA" : obj.getCzzybmmc().replace("中医诊断： ", "").trim());
                //去除出院诊断中医症候和代码的冗余字符串
                obj.setCzzyzhdm(obj.getCzzyzhdm() == null ? "NA" : obj.getCzzyzhdm().replace("中医诊断： ", "").trim());
                obj.setCzzyzhmc(obj.getCzzyzhmc() == null ? "NA" : obj.getCzzyzhmc().replace("中医诊断： ", "").trim());

                //入院诊断-中医病名代码、名称处理
                if (!"NA".equals(obj.getRzzybmdm())) {
                    String bmdm = "";
                    String bm = "";
                    String[] str = obj.getRzzybmdm().split("  ");
                    String[] str2 = obj.getRzzybmmc().split("  ");
                    Character o = new Character('B');
                    for (int i = 0; str.length > i; i++) {
                        if(!"".equals(str[i].toString())) {
                            if (o.equals(str[i].trim().charAt(0))) {
                                bmdm = bmdm + str[i].trim() + "  ";
                                bm = bm + str2[i].trim() + "  ";
                            }
                        }
                    }
                    if (StringUtil.isEmptyOrNull(bmdm)) {
                        obj.setRzzybmdm("NA");
                    } else {
                        obj.setRzzybmdm(bmdm);
                    }
                    if (StringUtil.isEmptyOrNull(bm)) {
                        obj.setRzzybmmc("NA");
                    } else {
                        obj.setRzzybmmc(bm);
                    }
                }

                //入院诊断-中医证候代码
                if (!"NA".equals(obj.getRzzyzhdm())) {
                    String bmdm = "";
                    String bm = "";
                    String[] str = obj.getRzzyzhdm().split("  ");
                    String[] str2 = obj.getRzzyzhmc().split("  ");
                    Character o = new Character('B');
                    for (int i = 0; str.length > i; i++) {
                        if(!"".equals(str[i].toString())) {
                            if (!o.equals(str[i].trim().charAt(0))) {
                                bmdm = bmdm + str[i].trim() + "  ";
                                bm = bm + str2[i].trim() + "  ";
                            }
                        }
                    }
                    if (StringUtil.isEmptyOrNull(bmdm)) {
                        obj.setRzzyzhdm("NA");
                    } else {
                        obj.setRzzyzhdm(bmdm);
                    }
                    if (StringUtil.isEmptyOrNull(bm)) {
                        obj.setRzzyzhmc("NA");
                    } else {
                        obj.setRzzyzhmc(bm);
                    }
                }

                //出院诊断-中医病名代码、名称处理
                if (!"NA".equals(obj.getCzzybmdm())) {
                    String bmdm = "";
                    String bm = "";
                    String[] str = obj.getCzzybmdm().split("  ");
                    String[] str2 = obj.getCzzybmmc().split("  ");
                    Character o = new Character('B');
                    for (int i = 0; str.length > i; i++) {
                        if(!"".equals(str[i].toString())) {
                            if (o.equals(str[i].trim().charAt(0))) {
                                bmdm = bmdm + str[i].trim() + "  ";
                                bm = bm + str2[i].trim() + "  ";
                            }
                        }
                    }
                    if (StringUtil.isEmptyOrNull(bmdm)) {
                        obj.setCzzybmdm("NA");
                    } else {
                        obj.setCzzybmdm(bmdm);
                    }
                    if (StringUtil.isEmptyOrNull(bm)) {
                        obj.setCzzybmmc("NA");
                    } else {
                        obj.setCzzybmmc(bm);
                    }
                }

                //出院诊断-中医证候代码
                if (!"NA".equals(obj.getCzzyzhdm())) {
                    String bmdm = "";
                    String bm = "";
                    String[] str = obj.getCzzyzhdm().split("  ");
                    String[] str2 = obj.getCzzyzhmc().split("  ");
                    Character o = new Character('B');
                    for (int i = 0; str.length > i; i++) {
                        if(!"".equals(str[i].toString())) {
                            if (!o.equals(str[i].trim().charAt(0))) {
                                bmdm = bmdm + str[i].trim() + "  ";
                                bm = bm + str2[i].trim() + "  ";
                            }
                        }
                    }
                    if (StringUtil.isEmptyOrNull(bmdm)) {
                        obj.setCzzyzhdm("NA");
                    } else {
                        obj.setCzzyzhdm(bmdm);
                    }
                    if (StringUtil.isEmptyOrNull(bm)) {
                        obj.setCzzyzhmc("NA");
                    } else {
                        obj.setCzzyzhmc(bm);
                    }
                }

                ListUtils.convertValue(obj, Arrays.asList(SplitParamsConstants.RYJL_RCYJL),SplitParamsConstants.SPECIAL_SPLIT_FLAG);
                this.createHlhtRyjlRcyjl(obj);
                splitTableDao.selectAnmrRyjlRcyjlSplitByProc(ryjlRcyjl);
                //插入日志
                mbzLoadDataInfoDao.insertMbzLoadDataInfo(new MbzLoadDataInfo(
                        Long.parseLong(Constants.WN_RYJL_RCYJL_SOURCE_TYPE),
                        Long.parseLong(obj.getYjlxh()), obj.getBlmc(),obj.getSyxh()+"",obj.getFssj(),
                        obj.getPatid(),obj.getZyh(),obj.getHzxm(),obj.getXbmc(),obj.getXbdm(),
                        "NA","NA",  "NA","NA", obj.getSfzhm(),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_RYJL_RCYJL_SOURCE_TYPE), obj, 1),
                        PercentUtil.getPercent(Long.parseLong(Constants.WN_RYJL_RCYJL_SOURCE_TYPE), obj, 0)));
                real_count++;
            }

        }else{
            logger.info("接口数据集:{}无相关的病历信息或者未配置结果集，请先书写病历信息或配置结果集",mbzDataSet.getRecordName());
        }
        //1.病历总数 2.抽取的病历数量 3.子集类型
        this.mbzDataCheckService.createMbzDataCheckNum(emr_count,real_count,Integer.parseInt(Constants.WN_RYJL_RCYJL_SOURCE_TYPE),entity);

        return null;
    }

}