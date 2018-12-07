package com.winning.hic.base;

/**
 * @author chensj
 * @title 需要拆分的编码
 * @email chensj@winning.com.cn
 * @package com.winning.hic.base
 * @date: 2018-11-19 13:47
 */
public class SplitParamsConstants {

    public static final String SPECIAL_SPLIT_FLAG = "§|§";
    /**
     * 24h内入出院记录
     */
    public static final String[] RYJL_RCYJL = {
            "rzxzzdbm",
            "rzxyzdmc",
            "rzzybmdm",
            "rzzybmmc",
            "rzzyzhdm",
            "rzzyzhmc",
            "czxyzdbm",
            "czxyzdmc",
            "czzybmdm",
            "czzybmmc",
            "czzyzhdm",
            "czzyzhmc"
    };
    /**
     * 24h内入院死亡记录
     */
    public static final String[] RYJL_RYSWJL = {
            "rzzybmmc",
            "rzzybmdm",
            "rzzyzhmc",
            "rzzyzhdm",
            "rzxyzdmc",
            "rzxyzdbm",
            "szzybmmc",
            "szzybmdm",
            "szzyzhmc",
            "szzyzhdm",
            "szxyzdmc",
            "szxyzdbm",
    };


    /**
     * 入院记录
     */
    public static final String[] RYJL_JBXX = {
            "qzzybmmc",
            "qzzybmdm",
            "qzzyzhmc",
            "qzzyzhdm",
            "qzxyzdmc",
            "qzxyzdbm",
            "xzxyzdmc",
            "xzxyzdbm",
            "xzzybmmc",
            "xzzybmdm",
            "xzzyzhmc",
            "xzzyzhdm",
            "czxyzdmc",
            "czxyzdbm",
            "czzybmmc",
            "czzybmdm",
            "czzyzhmc",
            "czzyzhdm",
            "bzbm",
            "bzmc"
    };

    /**
     * 出院小结－出院小结
     */
    public static final String[] CYXJ_CYXJ = {
            "czxyzdbm",
            "czxyzd",
            "czzyzhdm",
            "czzyzh",
            "czzybmdm",
            "czzybm",
            "rzxyzdbm",
            "rzxyzd",
            "rzzybmdm",
            "rzzybm",
            "rzzyzhdm",
            "rzzyzh"
    };

    /**
     * 门（急）诊病历 — 急诊留观病历
     */
    public static final String[] MJZBL_JZLGB = {
            "xyzdbm",
            "xyzdmc",
            "zybmdm",
            "zybmmc",
            "zyzhdm",
            "zyzhmc"
    };
    /**
     * 门急诊病历
     */
    public static final String[] MJZBL_MJZBL = {
            "xyzdbm",
            "xyzdmc",
            "zybmdm",
            "zybmmc",
            "zyzhdm",
            "zyzhmc"};
    /**
     * 输血记录
     */
    public static final String[] ZLCZJL_SXJL = {
            "jbzdbm",
            "jbzd"
    };
    /**
     * 一般手术记录
     */
    public static final String[] ZLCZJL_YBSSJL = {
            "sqzdbm",
            "sqzdmc",
            "shzdbm",
            "shzdmc"
    };
    /**
     * 治疗记录
     */
    public static final String[] ZLCZJL_ZLJL = {
            "jbzdbm",
            "jbzd"
    };
    /**
     * 病危（重）通知书
     */
    public static final String[] ZQGZXX_BWZTZS = {
            "jbzdbm",
            "jbzd"
    };
    /**
     * 知情告知信息 ― 其他知情同意书
     */
    public static final String[] ZQGZXX_QTZQTYS = {
            "jbzdbm",
            "jbzd"
    };
    /**
     * 知情告知信息－手术同意书
     */
    public static final String[] ZQGZXX_SSTYS = {
            "sqzd",
            "sqzdmc"
    };

    /**
     * 输血治疗同意书
     */
    public static final String[] ZQGZXX_SXZLTYS = {
            "jbzdbm",
            "jbzd"
    };
    /**
     * 知情告知信息－特殊检查及特殊治疗同意书
     */
    public static final String[] ZQGZXX_TSJCZLTYS = {
            "jbzdbm",
            "jbzd"
    };

    /**
     * 出院记录
     */
    public static final String[] ZYBCJL_CYJL = {
            "czxyzdmc",
            "czxyzdbm",
            "czzybmmc",
            "czzybmdm",
            "ryzdbm",
            "ryzdmc",
            "czzyzhdm",
            "czzyzhmc"
    };
    /**
     * 会诊记录
     */
    public static final String[] ZYBCJL_HZJL = {
            "zybmmc",
            "zybmdm",
            "zyzhmc",
            "zyzhdm",
            "xyzdmc",
            "xyzdbm"
    };
    /**
     * 住院病程记录－抢救记录
     */
    public static final String[] ZYBCJL_QJJL = {
            "jbzdmc",
            "jbzdbm"
    };
    /**
     * 住院病程记录－日常病程记录
     */
    public static final String[] ZYBCJL_RCBCJL = {

    };
    /**
     * 住院病程记录－术后首次病程记录
     */
    public static final String[] ZYBCJL_SHSCBCJL = {
            "shzdmc",
            "shzdbm"
    };
    /**
     * 住院病程记录－上级医师查房记录
     */
    public static final String[] ZYBCJL_SJYSCFJL = {

    };
    /**
     * 住院病程记录－术前讨论
     */
    public static final String[] ZYBCJL_SQTL = {
            "sqzdbm",
            "sqzdmc"
    };
    /**
     * 住院病程记录－术前小结
     */
    public static final String[] ZYBCJL_SQXJ = {
            "sqzdbm",
            "sqzdmc"
    };
    /**
     * 住院病程记录－死亡病例讨论记录
     */
    public static final String[] ZYBCJL_SWBLTLJL = {
            "swzdbm",
            "swzdmc",
            "tlrybm",
            "cjtlmd",
            "zyzwlbdm",
            "zyzwlbmc"
    };
    /**
     * 死亡记录
     */
    public static final String[] ZYBCJL_SWJL = {
            "ryzdbm",
            "ryzdmc",
            "swzdmc",
            "swzdbm"
    };
    /**
     * 疑难病例讨论记录
     */
    public static final String[] ZYBCJL_YNBLTLJL = {

    };
    /**
     * 转（诊）院记录
     */
    public static final String[] ZZYJL_ZZYJL = {
            "jbzdbm", "jbzd"
    };
    /**
     * 住院病程记录－转科记录
     */
    public static final String[] ZYBCJL_ZKJL = {
            "rzxyzdbm",
            "rzxyzd",
            "rzzybmdm",
            "rzzybm",
            "rzzyzhdm",
            "rzzyzh",
            "mqzdxyzdbm",
            "mqzdxyzd",
            "mqzdzybmdm",
            "mqzdzybm",
            "mqzdzyzhdm",
            "mqzdzyzh"
    };
    /**
     * 阶段小结
     */
    public static final String[] ZYBCJL_JDXJ = {
            "rzxyzdbm",
            "rzxyzd",
            "rzzybmdm",
            "rzzybm",
            "rzzyzhdm",
            "rzzyzh",
            "mqzdxyzdbm",
            "mqzdxyzd",
            "mqzdzybmdm",
            "mqzdzybm",
            "mqzdzyzhdm",
            "mqzdzyzh"
    };
    /**
     * 交接班记录
     */
    public static final String[] ZYBCJL_JJBJL = {
            "rzxyzdbm",
            "rzxyzd",
            "rzzybmdm",
            "rzzybm",
            "rzzyzhdm",
            "rzzyzh",
            "mqzdxyzdbm",
            "mqzdxyzd",
            "mqzdzybmdm",
            "mqzdzybm",
            "mqzdzyzhdm",
            "mqzdzyzh"
    };
    public static final String[] ZYBCJL_SCBCJL = {
            "czxyzdbm",
            "czxyzd",
            "czzybmdm",
            "czzybm",
            "czzyzhdm",
            "czzyzh",
            "jzxyzdbm",
            "jzxyzdmc",
            "jzzybmdm",
            "jzzybmmc",
            "jzzyzhbm",
            "jzzyzhmc"
    };

}
