package com.winning.hic.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;



/**
 * @author HLHT
 * @title 
 * @email Winning Health
 * @package com.winning.isc.model
 * @date 2018-27-14 16:27:45
 */
@Alias("outpOrder")
public class OutpOrder extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 字段名：yljgdm
     * 备注: 
     * 默认值：无
     */
    private String yljgdm;
    /**
     * 字段名：xh
     * 备注: 
     * 默认值：无
     */
    private Long xh;
    /**
     * 字段名：ghxh
     * 备注: 
     * 默认值：无
     */
    private Long ghxh;
    /**
     * 字段名：patid
     * 备注: 
     * 默认值：无
     */
    private Long patid;
    /**
     * 字段名：hzxm
     * 备注: 
     * 默认值：无
     */
    private String hzxm;
    /**
     * 字段名：py
     * 备注: 
     * 默认值：无
     */
    private String py;
    /**
     * 字段名：wb
     * 备注: 
     * 默认值：无
     */
    private String wb;
    /**
     * 字段名：ysdm
     * 备注: 
     * 默认值：无
     */
    private String ysdm;
    /**
     * 字段名：ysmc
     * 备注: 
     * 默认值：无
     */
    private String ysmc;
    /**
     * 字段名：ksdm
     * 备注: 
     * 默认值：无
     */
    private String ksdm;
    /**
     * 字段名：ksmc
     * 备注: 
     * 默认值：无
     */
    private String ksmc;
    /**
     * 字段名：yfdm
     * 备注: 
     * 默认值：无
     */
    private String yfdm;
    /**
     * 字段名：yfmc
     * 备注: 
     * 默认值：无
     */
    private String yfmc;
    /**
     * 字段名：cfts
     * 备注: 
     * 默认值：无
     */
    private Integer cfts;
    /**
     * 字段名：cydjs
     * 备注: 
     * 默认值：无
     */
    private Integer cydjs;
    /**
     * 字段名：yzzt
     * 备注: 
     * 默认值：无
     */
    private Integer yzzt;
    /**
     * 字段名：jlzt
     * 备注: 
     * 默认值：无
     */
    private Integer jlzt;
    /**
     * 字段名：cflx
     * 备注: 
     * 默认值：无
     */
    private Integer cflx;
    /**
     * 字段名：cfzddm
     * 备注: 
     * 默认值：无
     */
    private String cfzddm;
    /**
     * 字段名：cfzdmc
     * 备注: 
     * 默认值：无
     */
    private String cfzdmc;
    /**
     * 字段名：cyypyf
     * 备注: 
     * 默认值：无
     */
    private String cyypyf;
    /**
     * 字段名：cyyfmc
     * 备注: 
     * 默认值：无
     */
    private String cyyfmc;
    /**
     * 字段名：sycfbz
     * 备注: 
     * 默认值：无
     */
    private Integer sycfbz;
    /**
     * 字段名：tscfbz
     * 备注: 
     * 默认值：无
     */
    private Integer tscfbz;
    /**
     * 字段名：ekcfbz
     * 备注: 
     * 默认值：无
     */
    private Integer ekcfbz;
    /**
     * 字段名：ektz
     * 备注: 
     * 默认值：无
     */
    private String ektz;
    /**
     * 字段名：dmjsbz
     * 备注: 
     * 默认值：无
     */
    private Integer dmjsbz;
    /**
     * 字段名：shbz
     * 备注: 
     * 默认值：无
     */
    private Integer shbz;
    /**
     * 字段名：ybshbz
     * 备注: 
     * 默认值：无
     */
    private Integer ybshbz;
    /**
     * 字段名：zfcfbz
     * 备注: 
     * 默认值：无
     */
    private Boolean zfcfbz;
    /**
     * 字段名：jsdjfbz
     * 备注: 
     * 默认值：无
     */
    private Boolean jsdjfbz;
    /**
     * 字段名：czyh
     * 备注: 
     * 默认值：无
     */
    private String czyh;
    /**
     * 字段名：lrrq
     * 备注: 
     * 默认值：无
     */
    private Date lrrq;
    /**
     * 字段名：xsmc
     * 备注: 
     * 默认值：无
     */
    private String xsmc;
    /**
     * 字段名：memo
     * 备注: 
     * 默认值：无
     */
    private String memo;
    /**
     * 字段名：faxh
     * 备注: 
     * 默认值：无
     */
    private Long faxh;
    /**
     * 字段名：sfbz
     * 备注: 
     * 默认值：无
     */
    private String sfbz;
    /**
     * 字段名：qyid
     * 备注: 
     * 默认值：无
     */
    private String qyid;
    /**
     * 字段名：bmbz
     * 备注: 
     * 默认值：无
     */
    private Boolean bmbz;
    /**
     * 字段名：tbzddm
     * 备注: 
     * 默认值：无
     */
    private String tbzddm;
    /**
     * 字段名：tbzdmc
     * 备注: 
     * 默认值：无
     */
    private String tbzdmc;
    /**
     * 字段名：pydybz
     * 备注: 
     * 默认值：无
     */
    private Integer pydybz;
    /**
     * 字段名：yllb
     * 备注: 
     * 默认值：无
     */
    private String yllb;
    /**
     * 字段名：ybbfzdm
     * 备注: 
     * 默认值：无
     */
    private String ybbfzdm;
    /**
     * 字段名：eknlsm
     * 备注: 
     * 默认值：无
     */
    private String eknlsm;
    /**
     * 字段名：cymrjl
     * 备注: 
     * 默认值：无
     */
    private Integer cymrjl;
    /**
     * 字段名：cycyjx
     * 备注: 
     * 默认值：无
     */
    private String cycyjx;
    /**
     * 字段名：cyfycs
     * 备注: 
     * 默认值：无
     */
    private Integer cyfycs;
    /**
     * 字段名：cyyyff
     * 备注: 
     * 默认值：无
     */
    private String cyyyff;
    /**
     * 字段名：cyfyyq
     * 备注: 
     * 默认值：无
     */
    private String cyfyyq;
    /**
     * 字段名：cycyjxdm
     * 备注: 
     * 默认值：无
     */
    private String cycyjxdm;
    /**
     * 字段名：cyyyffdm
     * 备注: 
     * 默认值：无
     */
    private String cyyyffdm;
    /**
     * 字段名：cyfyyqdm
     * 备注: 
     * 默认值：无
     */
    private String cyfyyqdm;
    /**
     * 字段名：wsbz
     * 备注: 
     * 默认值：无
     */
    private Boolean wsbz;
    /**
     * 字段名：lsbz
     * 备注: 
     * 默认值：无
     */
    private Boolean lsbz;
    /**
     * 字段名：tzsj
     * 备注: 
     * 默认值：无
     */
    private Date tzsj;
    /**
     * 字段名：cqcfxh
     * 备注: 
     * 默认值：无
     */
    private Long cqcfxh;
    /**
     * 字段名：lgbz
     * 备注: 
     * 默认值：无
     */
    private Boolean lgbz;
    /**
     * 字段名：oldxh
     * 备注: 
     * 默认值：无
     */
    private Long oldxh;
    /**
     * 字段名：zfdm
     * 备注: 
     * 默认值：无
     */
    private String zfdm;
    /**
     * 字段名：zfmc
     * 备注: 
     * 默认值：无
     */
    private String zfmc;
    /**
     * 字段名：cfyyts
     * 备注: 
     * 默认值：无
     */
    private Integer cfyyts;
    /**
     * 字段名：cyrycs
     * 备注: 
     * 默认值：无
     */
    private Integer cyrycs;
    /**
     * 字段名：cydjts
     * 备注: 
     * 默认值：无
     */
    private Integer cydjts;
    /**
     * 字段名：cyjzzl
     * 备注: 
     * 默认值：无
     */
    private Integer cyjzzl;
    /**
     * 字段名：jldw
     * 备注: 
     * 默认值：无
     */
    private String jldw;
    /**
     * 字段名：ukbz
     * 备注: 
     * 默认值：无
     */
    private Boolean ukbz;
    /**
     * 字段名：xdfxh
     * 备注: 
     * 默认值：无
     */
    private Long xdfxh;
    /**
     * 字段名：qjbz
     * 备注: 
     * 默认值：无
     */
    private Boolean qjbz;
    /**
     * 字段名：shbz8
     * 备注: 
     * 默认值：无
     */
    private Integer shbz8;
    /**
     * 字段名：isNew
     * 备注: 
     * 默认值：无
     */
    private Boolean isnew;
    /**
     * 字段名：gxrqtimestr
     * 备注: 
     * 默认值：无
     */
    private String gxrqtimestr;
    /**
     * 字段名：timetempstr
     * 备注: 
     * 默认值：无
     */
    private byte[] timetempstr;
    /**
     * 字段名：createtime
     * 备注: 
     * 默认值：(getdate())
     */
    private Date createtime;
    /**
     * 字段名：timetemp
     * 备注: 
     * 默认值：无
     */
    private byte[] timetemp;
    /**
     * 字段名：gxrq
     * 备注: 
     * 默认值：无
     */
    private Date gxrq;
    /**
     * 字段名：sys_id
     * 备注: 
     * 默认值：无
     */
    private String sysId;
    /**
     * 字段名：lsnid
     * 备注: 
     * 默认值：无
     */
    private Long lsnid;
    /**
     * 字段名：isdelete
     * 备注: 
     * 默认值：无
     */
    private String isdelete;
    /**
     * 字段名：timetempstr_cdc
     * 备注: 
     * 默认值：无
     */
    private byte[] timetempstrCdc;

    public OutpOrder (){

    }

   /**
   * 字段名：yljgdm
   * get方法
   * 备注: 
   */
   public String getYljgdm(){

        return yljgdm;
   }

   /**
   * 字段名：yljgdm
   * set方法
   * 备注: 
   */
   public void setYljgdm(String yljgdm){
        this.yljgdm = yljgdm;
   }
   /**
   * 字段名：xh
   * get方法
   * 备注: 
   */
   public Long getXh(){

        return xh;
   }

   /**
   * 字段名：xh
   * set方法
   * 备注: 
   */
   public void setXh(Long xh){
        this.xh = xh;
   }
   /**
   * 字段名：ghxh
   * get方法
   * 备注: 
   */
   public Long getGhxh(){

        return ghxh;
   }

   /**
   * 字段名：ghxh
   * set方法
   * 备注: 
   */
   public void setGhxh(Long ghxh){
        this.ghxh = ghxh;
   }
   /**
   * 字段名：patid
   * get方法
   * 备注: 
   */
   public Long getPatid(){

        return patid;
   }

   /**
   * 字段名：patid
   * set方法
   * 备注: 
   */
   public void setPatid(Long patid){
        this.patid = patid;
   }
   /**
   * 字段名：hzxm
   * get方法
   * 备注: 
   */
   public String getHzxm(){

        return hzxm;
   }

   /**
   * 字段名：hzxm
   * set方法
   * 备注: 
   */
   public void setHzxm(String hzxm){
        this.hzxm = hzxm;
   }
   /**
   * 字段名：py
   * get方法
   * 备注: 
   */
   public String getPy(){

        return py;
   }

   /**
   * 字段名：py
   * set方法
   * 备注: 
   */
   public void setPy(String py){
        this.py = py;
   }
   /**
   * 字段名：wb
   * get方法
   * 备注: 
   */
   public String getWb(){

        return wb;
   }

   /**
   * 字段名：wb
   * set方法
   * 备注: 
   */
   public void setWb(String wb){
        this.wb = wb;
   }
   /**
   * 字段名：ysdm
   * get方法
   * 备注: 
   */
   public String getYsdm(){

        return ysdm;
   }

   /**
   * 字段名：ysdm
   * set方法
   * 备注: 
   */
   public void setYsdm(String ysdm){
        this.ysdm = ysdm;
   }
   /**
   * 字段名：ysmc
   * get方法
   * 备注: 
   */
   public String getYsmc(){

        return ysmc;
   }

   /**
   * 字段名：ysmc
   * set方法
   * 备注: 
   */
   public void setYsmc(String ysmc){
        this.ysmc = ysmc;
   }
   /**
   * 字段名：ksdm
   * get方法
   * 备注: 
   */
   public String getKsdm(){

        return ksdm;
   }

   /**
   * 字段名：ksdm
   * set方法
   * 备注: 
   */
   public void setKsdm(String ksdm){
        this.ksdm = ksdm;
   }
   /**
   * 字段名：ksmc
   * get方法
   * 备注: 
   */
   public String getKsmc(){

        return ksmc;
   }

   /**
   * 字段名：ksmc
   * set方法
   * 备注: 
   */
   public void setKsmc(String ksmc){
        this.ksmc = ksmc;
   }
   /**
   * 字段名：yfdm
   * get方法
   * 备注: 
   */
   public String getYfdm(){

        return yfdm;
   }

   /**
   * 字段名：yfdm
   * set方法
   * 备注: 
   */
   public void setYfdm(String yfdm){
        this.yfdm = yfdm;
   }
   /**
   * 字段名：yfmc
   * get方法
   * 备注: 
   */
   public String getYfmc(){

        return yfmc;
   }

   /**
   * 字段名：yfmc
   * set方法
   * 备注: 
   */
   public void setYfmc(String yfmc){
        this.yfmc = yfmc;
   }
   /**
   * 字段名：cfts
   * get方法
   * 备注: 
   */
   public Integer getCfts(){

        return cfts;
   }

   /**
   * 字段名：cfts
   * set方法
   * 备注: 
   */
   public void setCfts(Integer cfts){
        this.cfts = cfts;
   }
   /**
   * 字段名：cydjs
   * get方法
   * 备注: 
   */
   public Integer getCydjs(){

        return cydjs;
   }

   /**
   * 字段名：cydjs
   * set方法
   * 备注: 
   */
   public void setCydjs(Integer cydjs){
        this.cydjs = cydjs;
   }
   /**
   * 字段名：yzzt
   * get方法
   * 备注: 
   */
   public Integer getYzzt(){

        return yzzt;
   }

   /**
   * 字段名：yzzt
   * set方法
   * 备注: 
   */
   public void setYzzt(Integer yzzt){
        this.yzzt = yzzt;
   }
   /**
   * 字段名：jlzt
   * get方法
   * 备注: 
   */
   public Integer getJlzt(){

        return jlzt;
   }

   /**
   * 字段名：jlzt
   * set方法
   * 备注: 
   */
   public void setJlzt(Integer jlzt){
        this.jlzt = jlzt;
   }
   /**
   * 字段名：cflx
   * get方法
   * 备注: 
   */
   public Integer getCflx(){

        return cflx;
   }

   /**
   * 字段名：cflx
   * set方法
   * 备注: 
   */
   public void setCflx(Integer cflx){
        this.cflx = cflx;
   }
   /**
   * 字段名：cfzddm
   * get方法
   * 备注: 
   */
   public String getCfzddm(){

        return cfzddm;
   }

   /**
   * 字段名：cfzddm
   * set方法
   * 备注: 
   */
   public void setCfzddm(String cfzddm){
        this.cfzddm = cfzddm;
   }
   /**
   * 字段名：cfzdmc
   * get方法
   * 备注: 
   */
   public String getCfzdmc(){

        return cfzdmc;
   }

   /**
   * 字段名：cfzdmc
   * set方法
   * 备注: 
   */
   public void setCfzdmc(String cfzdmc){
        this.cfzdmc = cfzdmc;
   }
   /**
   * 字段名：cyypyf
   * get方法
   * 备注: 
   */
   public String getCyypyf(){

        return cyypyf;
   }

   /**
   * 字段名：cyypyf
   * set方法
   * 备注: 
   */
   public void setCyypyf(String cyypyf){
        this.cyypyf = cyypyf;
   }
   /**
   * 字段名：cyyfmc
   * get方法
   * 备注: 
   */
   public String getCyyfmc(){

        return cyyfmc;
   }

   /**
   * 字段名：cyyfmc
   * set方法
   * 备注: 
   */
   public void setCyyfmc(String cyyfmc){
        this.cyyfmc = cyyfmc;
   }
   /**
   * 字段名：sycfbz
   * get方法
   * 备注: 
   */
   public Integer getSycfbz(){

        return sycfbz;
   }

   /**
   * 字段名：sycfbz
   * set方法
   * 备注: 
   */
   public void setSycfbz(Integer sycfbz){
        this.sycfbz = sycfbz;
   }
   /**
   * 字段名：tscfbz
   * get方法
   * 备注: 
   */
   public Integer getTscfbz(){

        return tscfbz;
   }

   /**
   * 字段名：tscfbz
   * set方法
   * 备注: 
   */
   public void setTscfbz(Integer tscfbz){
        this.tscfbz = tscfbz;
   }
   /**
   * 字段名：ekcfbz
   * get方法
   * 备注: 
   */
   public Integer getEkcfbz(){

        return ekcfbz;
   }

   /**
   * 字段名：ekcfbz
   * set方法
   * 备注: 
   */
   public void setEkcfbz(Integer ekcfbz){
        this.ekcfbz = ekcfbz;
   }
   /**
   * 字段名：ektz
   * get方法
   * 备注: 
   */
   public String getEktz(){

        return ektz;
   }

   /**
   * 字段名：ektz
   * set方法
   * 备注: 
   */
   public void setEktz(String ektz){
        this.ektz = ektz;
   }
   /**
   * 字段名：dmjsbz
   * get方法
   * 备注: 
   */
   public Integer getDmjsbz(){

        return dmjsbz;
   }

   /**
   * 字段名：dmjsbz
   * set方法
   * 备注: 
   */
   public void setDmjsbz(Integer dmjsbz){
        this.dmjsbz = dmjsbz;
   }
   /**
   * 字段名：shbz
   * get方法
   * 备注: 
   */
   public Integer getShbz(){

        return shbz;
   }

   /**
   * 字段名：shbz
   * set方法
   * 备注: 
   */
   public void setShbz(Integer shbz){
        this.shbz = shbz;
   }
   /**
   * 字段名：ybshbz
   * get方法
   * 备注: 
   */
   public Integer getYbshbz(){

        return ybshbz;
   }

   /**
   * 字段名：ybshbz
   * set方法
   * 备注: 
   */
   public void setYbshbz(Integer ybshbz){
        this.ybshbz = ybshbz;
   }
   /**
   * 字段名：zfcfbz
   * get方法
   * 备注: 
   */
   public Boolean getZfcfbz(){

        return zfcfbz;
   }

   /**
   * 字段名：zfcfbz
   * set方法
   * 备注: 
   */
   public void setZfcfbz(Boolean zfcfbz){
        this.zfcfbz = zfcfbz;
   }
   /**
   * 字段名：jsdjfbz
   * get方法
   * 备注: 
   */
   public Boolean getJsdjfbz(){

        return jsdjfbz;
   }

   /**
   * 字段名：jsdjfbz
   * set方法
   * 备注: 
   */
   public void setJsdjfbz(Boolean jsdjfbz){
        this.jsdjfbz = jsdjfbz;
   }
   /**
   * 字段名：czyh
   * get方法
   * 备注: 
   */
   public String getCzyh(){

        return czyh;
   }

   /**
   * 字段名：czyh
   * set方法
   * 备注: 
   */
   public void setCzyh(String czyh){
        this.czyh = czyh;
   }
   /**
   * 字段名：lrrq
   * get方法
   * 备注: 
   */
   public Date getLrrq(){

        return lrrq;
   }

   /**
   * 字段名：lrrq
   * set方法
   * 备注: 
   */
   public void setLrrq(Date lrrq){
        this.lrrq = lrrq;
   }
   /**
   * 字段名：xsmc
   * get方法
   * 备注: 
   */
   public String getXsmc(){

        return xsmc;
   }

   /**
   * 字段名：xsmc
   * set方法
   * 备注: 
   */
   public void setXsmc(String xsmc){
        this.xsmc = xsmc;
   }
   /**
   * 字段名：memo
   * get方法
   * 备注: 
   */
   public String getMemo(){

        return memo;
   }

   /**
   * 字段名：memo
   * set方法
   * 备注: 
   */
   public void setMemo(String memo){
        this.memo = memo;
   }
   /**
   * 字段名：faxh
   * get方法
   * 备注: 
   */
   public Long getFaxh(){

        return faxh;
   }

   /**
   * 字段名：faxh
   * set方法
   * 备注: 
   */
   public void setFaxh(Long faxh){
        this.faxh = faxh;
   }
   /**
   * 字段名：sfbz
   * get方法
   * 备注: 
   */
   public String getSfbz(){

        return sfbz;
   }

   /**
   * 字段名：sfbz
   * set方法
   * 备注: 
   */
   public void setSfbz(String sfbz){
        this.sfbz = sfbz;
   }
   /**
   * 字段名：qyid
   * get方法
   * 备注: 
   */
   public String getQyid(){

        return qyid;
   }

   /**
   * 字段名：qyid
   * set方法
   * 备注: 
   */
   public void setQyid(String qyid){
        this.qyid = qyid;
   }
   /**
   * 字段名：bmbz
   * get方法
   * 备注: 
   */
   public Boolean getBmbz(){

        return bmbz;
   }

   /**
   * 字段名：bmbz
   * set方法
   * 备注: 
   */
   public void setBmbz(Boolean bmbz){
        this.bmbz = bmbz;
   }
   /**
   * 字段名：tbzddm
   * get方法
   * 备注: 
   */
   public String getTbzddm(){

        return tbzddm;
   }

   /**
   * 字段名：tbzddm
   * set方法
   * 备注: 
   */
   public void setTbzddm(String tbzddm){
        this.tbzddm = tbzddm;
   }
   /**
   * 字段名：tbzdmc
   * get方法
   * 备注: 
   */
   public String getTbzdmc(){

        return tbzdmc;
   }

   /**
   * 字段名：tbzdmc
   * set方法
   * 备注: 
   */
   public void setTbzdmc(String tbzdmc){
        this.tbzdmc = tbzdmc;
   }
   /**
   * 字段名：pydybz
   * get方法
   * 备注: 
   */
   public Integer getPydybz(){

        return pydybz;
   }

   /**
   * 字段名：pydybz
   * set方法
   * 备注: 
   */
   public void setPydybz(Integer pydybz){
        this.pydybz = pydybz;
   }
   /**
   * 字段名：yllb
   * get方法
   * 备注: 
   */
   public String getYllb(){

        return yllb;
   }

   /**
   * 字段名：yllb
   * set方法
   * 备注: 
   */
   public void setYllb(String yllb){
        this.yllb = yllb;
   }
   /**
   * 字段名：ybbfzdm
   * get方法
   * 备注: 
   */
   public String getYbbfzdm(){

        return ybbfzdm;
   }

   /**
   * 字段名：ybbfzdm
   * set方法
   * 备注: 
   */
   public void setYbbfzdm(String ybbfzdm){
        this.ybbfzdm = ybbfzdm;
   }
   /**
   * 字段名：eknlsm
   * get方法
   * 备注: 
   */
   public String getEknlsm(){

        return eknlsm;
   }

   /**
   * 字段名：eknlsm
   * set方法
   * 备注: 
   */
   public void setEknlsm(String eknlsm){
        this.eknlsm = eknlsm;
   }
   /**
   * 字段名：cymrjl
   * get方法
   * 备注: 
   */
   public Integer getCymrjl(){

        return cymrjl;
   }

   /**
   * 字段名：cymrjl
   * set方法
   * 备注: 
   */
   public void setCymrjl(Integer cymrjl){
        this.cymrjl = cymrjl;
   }
   /**
   * 字段名：cycyjx
   * get方法
   * 备注: 
   */
   public String getCycyjx(){

        return cycyjx;
   }

   /**
   * 字段名：cycyjx
   * set方法
   * 备注: 
   */
   public void setCycyjx(String cycyjx){
        this.cycyjx = cycyjx;
   }
   /**
   * 字段名：cyfycs
   * get方法
   * 备注: 
   */
   public Integer getCyfycs(){

        return cyfycs;
   }

   /**
   * 字段名：cyfycs
   * set方法
   * 备注: 
   */
   public void setCyfycs(Integer cyfycs){
        this.cyfycs = cyfycs;
   }
   /**
   * 字段名：cyyyff
   * get方法
   * 备注: 
   */
   public String getCyyyff(){

        return cyyyff;
   }

   /**
   * 字段名：cyyyff
   * set方法
   * 备注: 
   */
   public void setCyyyff(String cyyyff){
        this.cyyyff = cyyyff;
   }
   /**
   * 字段名：cyfyyq
   * get方法
   * 备注: 
   */
   public String getCyfyyq(){

        return cyfyyq;
   }

   /**
   * 字段名：cyfyyq
   * set方法
   * 备注: 
   */
   public void setCyfyyq(String cyfyyq){
        this.cyfyyq = cyfyyq;
   }
   /**
   * 字段名：cycyjxdm
   * get方法
   * 备注: 
   */
   public String getCycyjxdm(){

        return cycyjxdm;
   }

   /**
   * 字段名：cycyjxdm
   * set方法
   * 备注: 
   */
   public void setCycyjxdm(String cycyjxdm){
        this.cycyjxdm = cycyjxdm;
   }
   /**
   * 字段名：cyyyffdm
   * get方法
   * 备注: 
   */
   public String getCyyyffdm(){

        return cyyyffdm;
   }

   /**
   * 字段名：cyyyffdm
   * set方法
   * 备注: 
   */
   public void setCyyyffdm(String cyyyffdm){
        this.cyyyffdm = cyyyffdm;
   }
   /**
   * 字段名：cyfyyqdm
   * get方法
   * 备注: 
   */
   public String getCyfyyqdm(){

        return cyfyyqdm;
   }

   /**
   * 字段名：cyfyyqdm
   * set方法
   * 备注: 
   */
   public void setCyfyyqdm(String cyfyyqdm){
        this.cyfyyqdm = cyfyyqdm;
   }
   /**
   * 字段名：wsbz
   * get方法
   * 备注: 
   */
   public Boolean getWsbz(){

        return wsbz;
   }

   /**
   * 字段名：wsbz
   * set方法
   * 备注: 
   */
   public void setWsbz(Boolean wsbz){
        this.wsbz = wsbz;
   }
   /**
   * 字段名：lsbz
   * get方法
   * 备注: 
   */
   public Boolean getLsbz(){

        return lsbz;
   }

   /**
   * 字段名：lsbz
   * set方法
   * 备注: 
   */
   public void setLsbz(Boolean lsbz){
        this.lsbz = lsbz;
   }
   /**
   * 字段名：tzsj
   * get方法
   * 备注: 
   */
   public Date getTzsj(){

        return tzsj;
   }

   /**
   * 字段名：tzsj
   * set方法
   * 备注: 
   */
   public void setTzsj(Date tzsj){
        this.tzsj = tzsj;
   }
   /**
   * 字段名：cqcfxh
   * get方法
   * 备注: 
   */
   public Long getCqcfxh(){

        return cqcfxh;
   }

   /**
   * 字段名：cqcfxh
   * set方法
   * 备注: 
   */
   public void setCqcfxh(Long cqcfxh){
        this.cqcfxh = cqcfxh;
   }
   /**
   * 字段名：lgbz
   * get方法
   * 备注: 
   */
   public Boolean getLgbz(){

        return lgbz;
   }

   /**
   * 字段名：lgbz
   * set方法
   * 备注: 
   */
   public void setLgbz(Boolean lgbz){
        this.lgbz = lgbz;
   }
   /**
   * 字段名：oldxh
   * get方法
   * 备注: 
   */
   public Long getOldxh(){

        return oldxh;
   }

   /**
   * 字段名：oldxh
   * set方法
   * 备注: 
   */
   public void setOldxh(Long oldxh){
        this.oldxh = oldxh;
   }
   /**
   * 字段名：zfdm
   * get方法
   * 备注: 
   */
   public String getZfdm(){

        return zfdm;
   }

   /**
   * 字段名：zfdm
   * set方法
   * 备注: 
   */
   public void setZfdm(String zfdm){
        this.zfdm = zfdm;
   }
   /**
   * 字段名：zfmc
   * get方法
   * 备注: 
   */
   public String getZfmc(){

        return zfmc;
   }

   /**
   * 字段名：zfmc
   * set方法
   * 备注: 
   */
   public void setZfmc(String zfmc){
        this.zfmc = zfmc;
   }
   /**
   * 字段名：cfyyts
   * get方法
   * 备注: 
   */
   public Integer getCfyyts(){

        return cfyyts;
   }

   /**
   * 字段名：cfyyts
   * set方法
   * 备注: 
   */
   public void setCfyyts(Integer cfyyts){
        this.cfyyts = cfyyts;
   }
   /**
   * 字段名：cyrycs
   * get方法
   * 备注: 
   */
   public Integer getCyrycs(){

        return cyrycs;
   }

   /**
   * 字段名：cyrycs
   * set方法
   * 备注: 
   */
   public void setCyrycs(Integer cyrycs){
        this.cyrycs = cyrycs;
   }
   /**
   * 字段名：cydjts
   * get方法
   * 备注: 
   */
   public Integer getCydjts(){

        return cydjts;
   }

   /**
   * 字段名：cydjts
   * set方法
   * 备注: 
   */
   public void setCydjts(Integer cydjts){
        this.cydjts = cydjts;
   }
   /**
   * 字段名：cyjzzl
   * get方法
   * 备注: 
   */
   public Integer getCyjzzl(){

        return cyjzzl;
   }

   /**
   * 字段名：cyjzzl
   * set方法
   * 备注: 
   */
   public void setCyjzzl(Integer cyjzzl){
        this.cyjzzl = cyjzzl;
   }
   /**
   * 字段名：jldw
   * get方法
   * 备注: 
   */
   public String getJldw(){

        return jldw;
   }

   /**
   * 字段名：jldw
   * set方法
   * 备注: 
   */
   public void setJldw(String jldw){
        this.jldw = jldw;
   }
   /**
   * 字段名：ukbz
   * get方法
   * 备注: 
   */
   public Boolean getUkbz(){

        return ukbz;
   }

   /**
   * 字段名：ukbz
   * set方法
   * 备注: 
   */
   public void setUkbz(Boolean ukbz){
        this.ukbz = ukbz;
   }
   /**
   * 字段名：xdfxh
   * get方法
   * 备注: 
   */
   public Long getXdfxh(){

        return xdfxh;
   }

   /**
   * 字段名：xdfxh
   * set方法
   * 备注: 
   */
   public void setXdfxh(Long xdfxh){
        this.xdfxh = xdfxh;
   }
   /**
   * 字段名：qjbz
   * get方法
   * 备注: 
   */
   public Boolean getQjbz(){

        return qjbz;
   }

   /**
   * 字段名：qjbz
   * set方法
   * 备注: 
   */
   public void setQjbz(Boolean qjbz){
        this.qjbz = qjbz;
   }
   /**
   * 字段名：shbz8
   * get方法
   * 备注: 
   */
   public Integer getShbz8(){

        return shbz8;
   }

   /**
   * 字段名：shbz8
   * set方法
   * 备注: 
   */
   public void setShbz8(Integer shbz8){
        this.shbz8 = shbz8;
   }
   /**
   * 字段名：isNew
   * get方法
   * 备注: 
   */
   public Boolean getIsnew(){

        return isnew;
   }

   /**
   * 字段名：isNew
   * set方法
   * 备注: 
   */
   public void setIsnew(Boolean isnew){
        this.isnew = isnew;
   }
   /**
   * 字段名：gxrqtimestr
   * get方法
   * 备注: 
   */
   public String getGxrqtimestr(){

        return gxrqtimestr;
   }

   /**
   * 字段名：gxrqtimestr
   * set方法
   * 备注: 
   */
   public void setGxrqtimestr(String gxrqtimestr){
        this.gxrqtimestr = gxrqtimestr;
   }
   /**
   * 字段名：timetempstr
   * get方法
   * 备注: 
   */
   public byte[] getTimetempstr(){

        return timetempstr;
   }

   /**
   * 字段名：timetempstr
   * set方法
   * 备注: 
   */
   public void setTimetempstr(byte[] timetempstr){
        this.timetempstr = timetempstr;
   }
   /**
   * 字段名：createtime
   * get方法
   * 备注: 
   */
   public Date getCreatetime(){

        return createtime;
   }

   /**
   * 字段名：createtime
   * set方法
   * 备注: 
   */
   public void setCreatetime(Date createtime){
        this.createtime = createtime;
   }
   /**
   * 字段名：timetemp
   * get方法
   * 备注: 
   */
   public byte[] getTimetemp(){

        return timetemp;
   }

   /**
   * 字段名：timetemp
   * set方法
   * 备注: 
   */
   public void setTimetemp(byte[] timetemp){
        this.timetemp = timetemp;
   }
   /**
   * 字段名：gxrq
   * get方法
   * 备注: 
   */
   public Date getGxrq(){

        return gxrq;
   }

   /**
   * 字段名：gxrq
   * set方法
   * 备注: 
   */
   public void setGxrq(Date gxrq){
        this.gxrq = gxrq;
   }
   /**
   * 字段名：sys_id
   * get方法
   * 备注: 
   */
   public String getSysId(){

        return sysId;
   }

   /**
   * 字段名：sys_id
   * set方法
   * 备注: 
   */
   public void setSysId(String sysId){
        this.sysId = sysId;
   }
   /**
   * 字段名：lsnid
   * get方法
   * 备注: 
   */
   public Long getLsnid(){

        return lsnid;
   }

   /**
   * 字段名：lsnid
   * set方法
   * 备注: 
   */
   public void setLsnid(Long lsnid){
        this.lsnid = lsnid;
   }
   /**
   * 字段名：isdelete
   * get方法
   * 备注: 
   */
   public String getIsdelete(){

        return isdelete;
   }

   /**
   * 字段名：isdelete
   * set方法
   * 备注: 
   */
   public void setIsdelete(String isdelete){
        this.isdelete = isdelete;
   }
   /**
   * 字段名：timetempstr_cdc
   * get方法
   * 备注: 
   */
   public byte[] getTimetempstrCdc(){

        return timetempstrCdc;
   }

   /**
   * 字段名：timetempstr_cdc
   * set方法
   * 备注: 
   */
   public void setTimetempstrCdc(byte[] timetempstrCdc){
        this.timetempstrCdc = timetempstrCdc;
   }

    @Override
    public String toString() {
        return "OutpOrder{" +
                "yljgdm='" + yljgdm + '\'' +
                ", xh=" + xh +
                ", ghxh=" + ghxh +
                ", patid=" + patid +
                ", hzxm='" + hzxm + '\'' +
                ", py='" + py + '\'' +
                ", wb='" + wb + '\'' +
                ", ysdm='" + ysdm + '\'' +
                ", ysmc='" + ysmc + '\'' +
                ", ksdm='" + ksdm + '\'' +
                ", ksmc='" + ksmc + '\'' +
                ", yfdm='" + yfdm + '\'' +
                ", yfmc='" + yfmc + '\'' +
                ", cfts=" + cfts +
                ", cydjs=" + cydjs +
                ", yzzt=" + yzzt +
                ", jlzt=" + jlzt +
                ", cflx=" + cflx +
                ", cfzddm='" + cfzddm + '\'' +
                ", cfzdmc='" + cfzdmc + '\'' +
                ", cyypyf='" + cyypyf + '\'' +
                ", cyyfmc='" + cyyfmc + '\'' +
                ", sycfbz=" + sycfbz +
                ", tscfbz=" + tscfbz +
                ", ekcfbz=" + ekcfbz +
                ", ektz='" + ektz + '\'' +
                ", dmjsbz=" + dmjsbz +
                ", shbz=" + shbz +
                ", ybshbz=" + ybshbz +
                ", zfcfbz=" + zfcfbz +
                ", jsdjfbz=" + jsdjfbz +
                ", czyh='" + czyh + '\'' +
                ", lrrq=" + lrrq +
                ", xsmc='" + xsmc + '\'' +
                ", memo='" + memo + '\'' +
                ", faxh=" + faxh +
                ", sfbz='" + sfbz + '\'' +
                ", qyid='" + qyid + '\'' +
                ", bmbz=" + bmbz +
                ", tbzddm='" + tbzddm + '\'' +
                ", tbzdmc='" + tbzdmc + '\'' +
                ", pydybz=" + pydybz +
                ", yllb='" + yllb + '\'' +
                ", ybbfzdm='" + ybbfzdm + '\'' +
                ", eknlsm='" + eknlsm + '\'' +
                ", cymrjl=" + cymrjl +
                ", cycyjx='" + cycyjx + '\'' +
                ", cyfycs=" + cyfycs +
                ", cyyyff='" + cyyyff + '\'' +
                ", cyfyyq='" + cyfyyq + '\'' +
                ", cycyjxdm='" + cycyjxdm + '\'' +
                ", cyyyffdm='" + cyyyffdm + '\'' +
                ", cyfyyqdm='" + cyfyyqdm + '\'' +
                ", wsbz=" + wsbz +
                ", lsbz=" + lsbz +
                ", tzsj=" + tzsj +
                ", cqcfxh=" + cqcfxh +
                ", lgbz=" + lgbz +
                ", oldxh=" + oldxh +
                ", zfdm='" + zfdm + '\'' +
                ", zfmc='" + zfmc + '\'' +
                ", cfyyts=" + cfyyts +
                ", cyrycs=" + cyrycs +
                ", cydjts=" + cydjts +
                ", cyjzzl=" + cyjzzl +
                ", jldw='" + jldw + '\'' +
                ", ukbz=" + ukbz +
                ", xdfxh=" + xdfxh +
                ", qjbz=" + qjbz +
                ", shbz8=" + shbz8 +
                ", isnew=" + isnew +
                ", gxrqtimestr='" + gxrqtimestr + '\'' +
                ", timetempstr=" + Arrays.toString(timetempstr) +
                ", createtime=" + createtime +
                ", timetemp=" + Arrays.toString(timetemp) +
                ", gxrq=" + gxrq +
                ", sysId='" + sysId + '\'' +
                ", lsnid=" + lsnid +
                ", isdelete='" + isdelete + '\'' +
                ", timetempstrCdc=" + Arrays.toString(timetempstrCdc) +
                '}';
    }
}