package com.winning.hic.base.config;

import com.winning.hic.model.CisTableName;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chensj
 * @title CIS 数据集 表名、字典值、中文名映射关系
 * @email chensj@winning.com.cn
 * @package com.winning.hic.base.config
 * @date: 2018-11-21 14:45
 */
public class CisTableNameConfig {

    private static final Map<String,Object> dataMap ;
    static {
        dataMap = new HashMap<>();
        dataMap.put("HLHT_RYJL_RCYJL", new CisTableName(1,"HLHT_RYJL_RCYJL","24h内入出院记录"));
        dataMap.put("HLHT_RYJL_RYSWJL", new CisTableName(2,"HLHT_RYJL_RYSWJL","24h内入院死亡记录"));
        dataMap.put("HLHT_ZQGZXX_BWZTZS", new CisTableName(3,"HLHT_ZQGZXX_BWZTZS","病危（重）通知书"));
        dataMap.put("HLHT_ZYBCJL_CYJL", new CisTableName(4,"HLHT_ZYBCJL_CYJL","出院记录"));
        dataMap.put("HLHT_RYJL_JBXX", new CisTableName(5,"HLHT_RYJL_JBXX","入院记录"));
        dataMap.put("HLHT_ZYBCJL_SCBCJL", new CisTableName(6,"HLHT_ZYBCJL_SCBCJL","首次病程记录"));
        dataMap.put("HLHT_ZYBCJL_RCBCJL", new CisTableName(7,"HLHT_ZYBCJL_RCBCJL","日常病程记录"));
        dataMap.put("HLHT_ZYBCJL_JJBJL", new CisTableName(8,"HLHT_ZYBCJL_JJBJL","交接班记录"));
        dataMap.put("HLHT_ZYBCJL_JDXJ", new CisTableName(9,"HLHT_ZYBCJL_JDXJ","阶段小结"));
        dataMap.put("HLHT_ZYBCJL_QJJL", new CisTableName(10,"HLHT_ZYBCJL_QJJL","抢救记录"));
        dataMap.put("HLHT_ZYBCJL_SHSCBCJL", new CisTableName(11,"HLHT_ZYBCJL_SHSCBCJL","术后首次病程记录"));
        dataMap.put("HLHT_ZYBCJL_SQXJ", new CisTableName(12,"HLHT_ZYBCJL_SQXJ","术前小结"));
        dataMap.put("HLHT_ZYBCJL_SQTL", new CisTableName(13,"HLHT_ZYBCJL_SQTL","术前讨论"));
        dataMap.put("HLHT_ZYBCJL_SWBLTLJL", new CisTableName(14,"HLHT_ZYBCJL_SWBLTLJL","死亡病例讨论记录"));
        dataMap.put("HLHT_ZYBCJL_SWJL", new CisTableName(15,"HLHT_ZYBCJL_SWJL","死亡记录"));
        dataMap.put("HLHT_ZLCZJL_MZSQFSJL", new CisTableName(16,"HLHT_ZLCZJL_MZSQFSJL","麻醉术前访视记录"));
        dataMap.put("HLHT_ZLCZJL_MZSHFSJL", new CisTableName(17,"HLHT_ZLCZJL_MZSHFSJL","麻醉术后访视记录"));
        dataMap.put("HLHT_ZQGZXX_MZZQTYS", new CisTableName(18,"HLHT_ZQGZXX_MZZQTYS","麻醉知情同意书"));
        dataMap.put("HLHT_ZQGZXX_QTZQTYS", new CisTableName(19,"HLHT_ZQGZXX_QTZQTYS","其他知情告知同意书"));
        dataMap.put("HLHT_ZLCZJL_YBSSJL", new CisTableName(20,"HLHT_ZLCZJL_YBSSJL","一般手术记录"));
        dataMap.put("HLHT_ZYBCJL_HZJL", new CisTableName(21,"HLHT_ZYBCJL_HZJL","会诊记录"));
        dataMap.put("HLHT_CYXJ_CYXJ", new CisTableName(22,"HLHT_CYXJ_CYXJ","出院小结"));
        dataMap.put("HLHT_ZYBCJL_SJYSCFJL", new CisTableName(23,"HLHT_ZYBCJL_SJYSCFJL","上级医师查房记录"));
        dataMap.put("HLHT_ZQGZXX_SSTYS", new CisTableName(24,"HLHT_ZQGZXX_SSTYS","手术同意书"));
        dataMap.put("HLHT_ZQGZXX_SXZLTYS", new CisTableName(25,"HLHT_ZQGZXX_SXZLTYS","输血治疗同意书"));
        dataMap.put("HLHT_ZYBCJL_YNBLTLJL", new CisTableName(26,"HLHT_ZYBCJL_YNBLTLJL","疑难病例讨论记录"));
        dataMap.put("HLHT_ZYBCJL_ZKJL", new CisTableName(27,"HLHT_ZYBCJL_ZKJL","转科记录"));
        dataMap.put("HLHT_ZZYJL_ZZYJL", new CisTableName(28,"HLHT_ZZYJL_ZZYJL","转诊(院)记录"));
        dataMap.put("HLHT_ZQGZXX_TSJCZLTYS", new CisTableName(29,"HLHT_ZQGZXX_TSJCZLTYS","特殊检查及特殊治疗同意书"));
        dataMap.put("HLHT_ZLCZJL_SXJL", new CisTableName(30,"HLHT_ZLCZJL_SXJL","输血记录"));
        dataMap.put("HLHT_MJZBL_MJZBL", new CisTableName(31,"HLHT_MJZBL_MJZBL","门急诊病历"));
        dataMap.put("HLHT_MJZBL_JZLGBL", new CisTableName(32,"HLHT_MJZBL_JZLGBL","急诊留观病历"));
        dataMap.put("HLHT_ZLCZJL_ZLJL", new CisTableName(33,"HLHT_ZLCZJL_ZLJL","治疗记录"));
        dataMap.put("HLHT_ZCJL_YDFM", new CisTableName(34,"HLHT_ZCJL_YDFM","阴道分娩记录"));
        dataMap.put("HLHT_ZCJL_PGC", new CisTableName(35,"HLHT_ZCJL_PGC","剖宫产记录"));
        dataMap.put("HLHT_BLGY_JBJKXX", new CisTableName(36,"HLHT_BLGY_JBJKXX","基本健康信息"));
        dataMap.put("HLHT_BLGY_WSSJZY", new CisTableName(37,"HLHT_BLGY_WSSJZY","卫生事件摘要"));
        dataMap.put("HLHT_MJZCF_XYCF", new CisTableName(38,"HLHT_MJZCF_XYCF","西药处方"));
        dataMap.put("HLHT_MJZCF_ZYCF", new CisTableName(39,"HLHT_MJZCF_ZYCF","中药处方"));
    }

    public static String getDataListName(String tableName){
        return ((CisTableName)dataMap.get(tableName)).getTableCnName();
    }

    public static int getDataListId(String tableName){
        return ((CisTableName)dataMap.get(tableName)).getId();
    }
}
