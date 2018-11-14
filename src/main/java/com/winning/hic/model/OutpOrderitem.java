package com.winning.hic.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author HLHT
 * @title 
 * @email Winning Health
 * @package com.winning.isc.model
 * @date 2018-27-14 16:27:38
 */
@Alias("outpOrderitem")
public class OutpOrderitem extends BaseDomain implements Serializable {

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
     * 字段名：cfxh
     * 备注: 
     * 默认值：无
     */
    private Long cfxh;
    /**
     * 字段名：cd_idm
     * 备注: 
     * 默认值：无
     */
    private Integer cdIdm;
    /**
     * 字段名：gg_idm
     * 备注: 
     * 默认值：无
     */
    private Integer ggIdm;
    /**
     * 字段名：ekbz
     * 备注: 
     * 默认值：无
     */
    private Boolean ekbz;
    /**
     * 字段名：dxmdm
     * 备注: 
     * 默认值：无
     */
    private String dxmdm;
    /**
     * 字段名：dxmmc
     * 备注: 
     * 默认值：无
     */
    private String dxmmc;
    /**
     * 字段名：ypdm
     * 备注: 
     * 默认值：无
     */
    private String ypdm;
    /**
     * 字段名：lcxmdm
     * 备注: 
     * 默认值：无
     */
    private String lcxmdm;
    /**
     * 字段名：ypmc
     * 备注: 
     * 默认值：无
     */
    private String ypmc;
    /**
     * 字段名：ypgg
     * 备注: 
     * 默认值：无
     */
    private String ypgg;
    /**
     * 字段名：ypdw
     * 备注: 
     * 默认值：无
     */
    private String ypdw;
    /**
     * 字段名：ypxs
     * 备注: 
     * 默认值：无
     */
    private BigDecimal ypxs;
    /**
     * 字段名：ykxs
     * 备注: 
     * 默认值：无
     */
    private BigDecimal ykxs;
    /**
     * 字段名：mzdw
     * 备注: 
     * 默认值：无
     */
    private String mzdw;
    /**
     * 字段名：mzxs
     * 备注: 
     * 默认值：无
     */
    private BigDecimal mzxs;
    /**
     * 字段名：ggdw
     * 备注: 
     * 默认值：无
     */
    private String ggdw;
    /**
     * 字段名：ggxs
     * 备注: 
     * 默认值：无
     */
    private BigDecimal ggxs;
    /**
     * 字段名：zxdw
     * 备注: 
     * 默认值：无
     */
    private String zxdw;
    /**
     * 字段名：jxdm
     * 备注: 
     * 默认值：无
     */
    private String jxdm;
    /**
     * 字段名：jxmc
     * 备注: 
     * 默认值：无
     */
    private String jxmc;
    /**
     * 字段名：ylsj
     * 备注: 
     * 默认值：无
     */
    private BigDecimal ylsj;
    /**
     * 字段名：ypfj
     * 备注: 
     * 默认值：无
     */
    private BigDecimal ypfj;
    /**
     * 字段名：ypyf
     * 备注: 
     * 默认值：无
     */
    private String ypyf;
    /**
     * 字段名：ypyfmc
     * 备注: 
     * 默认值：无
     */
    private String ypyfmc;
    /**
     * 字段名：pcdm
     * 备注: 
     * 默认值：无
     */
    private String pcdm;
    /**
     * 字段名：pcmc
     * 备注: 
     * 默认值：无
     */
    private String pcmc;
    /**
     * 字段名：ypjl
     * 备注: 
     * 默认值：无
     */
    private BigDecimal ypjl;
    /**
     * 字段名：jldw
     * 备注: 
     * 默认值：无
     */
    private String jldw;
    /**
     * 字段名：dwlb
     * 备注: 
     * 默认值：无
     */
    private Integer dwlb;
    /**
     * 字段名：ts
     * 备注: 
     * 默认值：无
     */
    private Integer ts;
    /**
     * 字段名：yfldsl
     * 备注: 
     * 默认值：无
     */
    private Integer yfldsl;
    /**
     * 字段名：ldlx
     * 备注: 
     * 默认值：无
     */
    private String ldlx;
    /**
     * 字段名：ldxh
     * 备注: 
     * 默认值：无
     */
    private String ldxh;
    /**
     * 字段名：ypsl
     * 备注: 
     * 默认值：无
     */
    private BigDecimal ypsl;
    /**
     * 字段名：cyts
     * 备注: 
     * 默认值：无
     */
    private Integer cyts;
    /**
     * 字段名：shbz
     * 备注: 
     * 默认值：无
     */
    private Boolean shbz;
    /**
     * 字段名：zbz
     * 备注: 
     * 默认值：无
     */
    private Integer zbz;
    /**
     * 字段名：mzdm
     * 备注: 
     * 默认值：无
     */
    private String mzdm;
    /**
     * 字段名：mzmc
     * 备注: 
     * 默认值：无
     */
    private String mzmc;
    /**
     * 字段名：fzxh
     * 备注: 
     * 默认值：无
     */
    private Long fzxh;
    /**
     * 字段名：psbz
     * 备注: 
     * 默认值：无
     */
    private Boolean psbz;
    /**
     * 字段名：zbbz
     * 备注: 
     * 默认值：无
     */
    private Boolean zbbz;
    /**
     * 字段名：jjbz
     * 备注: 
     * 默认值：无
     */
    private Integer jjbz;
    /**
     * 字段名：jlzt
     * 备注: 
     * 默认值：无
     */
    private Boolean jlzt;
    /**
     * 字段名：ybspbz
     * 备注: 
     * 默认值：无
     */
    private Integer ybspbz;
    /**
     * 字段名：ybjzbz
     * 备注: 
     * 默认值：无
     */
    private Boolean ybjzbz;
    /**
     * 字段名：mzlybz
     * 备注: 
     * 默认值：无
     */
    private Integer mzlybz;
    /**
     * 字段名：memo
     * 备注: 
     * 默认值：无
     */
    private String memo;
    /**
     * 字段名：ljdyxh
     * 备注: 
     * 默认值：无
     */
    private Long ljdyxh;
    /**
     * 字段名：xz
     * 备注: 
     * 默认值：无
     */
    private Integer xz;
    /**
     * 字段名：kzggdwxh
     * 备注: 
     * 默认值：无
     */
    private Long kzggdwxh;
    /**
     * 字段名：tsdybz
     * 备注: 
     * 默认值：无
     */
    private Integer tsdybz;
    /**
     * 字段名：ksskzbz
     * 备注: 
     * 默认值：无
     */
    private Integer ksskzbz;
    /**
     * 字段名：bbzl
     * 备注: 
     * 默认值：无
     */
    private String bbzl;
    /**
     * 字段名：mrjldwbz
     * 备注: 
     * 默认值：无
     */
    private Integer mrjldwbz;
    /**
     * 字段名：zfbz
     * 备注: 
     * 默认值：无
     */
    private Boolean zfbz;
    /**
     * 字段名：jlsm
     * 备注: 
     * 默认值：无
     */
    private String jlsm;
    /**
     * 字段名：psypdm
     * 备注: 
     * 默认值：无
     */
    private String psypdm;
    /**
     * 字段名：ybjyb
     * 备注: 
     * 默认值：无
     */
    private Integer ybjyb;
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
     * 字段名：cqcfmxxh
     * 备注: 
     * 默认值：无
     */
    private Long cqcfmxxh;
    /**
     * 字段名：oldxh
     * 备注: 
     * 默认值：无
     */
    private Long oldxh;
    /**
     * 字段名：gdzlxmxh
     * 备注: 
     * 默认值：无
     */
    private Long gdzlxmxh;
    /**
     * 字段名：cjrq
     * 备注: 
     * 默认值：无
     */
    private String cjrq;
    /**
     * 字段名：ybbz
     * 备注: 
     * 默认值：无
     */
    private Boolean ybbz;
    /**
     * 字段名：tfbz
     * 备注: 
     * 默认值：无
     */
    private Boolean tfbz;
    /**
     * 字段名：cjlqm
     * 备注: 
     * 默认值：无
     */
    private Integer cjlqm;
    /**
     * 字段名：mbbz
     * 备注: 
     * 默认值：无
     */
    private Boolean mbbz;
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

    public OutpOrderitem (){

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
   * 字段名：cfxh
   * get方法
   * 备注: 
   */
   public Long getCfxh(){

        return cfxh;
   }

   /**
   * 字段名：cfxh
   * set方法
   * 备注: 
   */
   public void setCfxh(Long cfxh){
        this.cfxh = cfxh;
   }
   /**
   * 字段名：cd_idm
   * get方法
   * 备注: 
   */
   public Integer getCdIdm(){

        return cdIdm;
   }

   /**
   * 字段名：cd_idm
   * set方法
   * 备注: 
   */
   public void setCdIdm(Integer cdIdm){
        this.cdIdm = cdIdm;
   }
   /**
   * 字段名：gg_idm
   * get方法
   * 备注: 
   */
   public Integer getGgIdm(){

        return ggIdm;
   }

   /**
   * 字段名：gg_idm
   * set方法
   * 备注: 
   */
   public void setGgIdm(Integer ggIdm){
        this.ggIdm = ggIdm;
   }
   /**
   * 字段名：ekbz
   * get方法
   * 备注: 
   */
   public Boolean getEkbz(){

        return ekbz;
   }

   /**
   * 字段名：ekbz
   * set方法
   * 备注: 
   */
   public void setEkbz(Boolean ekbz){
        this.ekbz = ekbz;
   }
   /**
   * 字段名：dxmdm
   * get方法
   * 备注: 
   */
   public String getDxmdm(){

        return dxmdm;
   }

   /**
   * 字段名：dxmdm
   * set方法
   * 备注: 
   */
   public void setDxmdm(String dxmdm){
        this.dxmdm = dxmdm;
   }
   /**
   * 字段名：dxmmc
   * get方法
   * 备注: 
   */
   public String getDxmmc(){

        return dxmmc;
   }

   /**
   * 字段名：dxmmc
   * set方法
   * 备注: 
   */
   public void setDxmmc(String dxmmc){
        this.dxmmc = dxmmc;
   }
   /**
   * 字段名：ypdm
   * get方法
   * 备注: 
   */
   public String getYpdm(){

        return ypdm;
   }

   /**
   * 字段名：ypdm
   * set方法
   * 备注: 
   */
   public void setYpdm(String ypdm){
        this.ypdm = ypdm;
   }
   /**
   * 字段名：lcxmdm
   * get方法
   * 备注: 
   */
   public String getLcxmdm(){

        return lcxmdm;
   }

   /**
   * 字段名：lcxmdm
   * set方法
   * 备注: 
   */
   public void setLcxmdm(String lcxmdm){
        this.lcxmdm = lcxmdm;
   }
   /**
   * 字段名：ypmc
   * get方法
   * 备注: 
   */
   public String getYpmc(){

        return ypmc;
   }

   /**
   * 字段名：ypmc
   * set方法
   * 备注: 
   */
   public void setYpmc(String ypmc){
        this.ypmc = ypmc;
   }
   /**
   * 字段名：ypgg
   * get方法
   * 备注: 
   */
   public String getYpgg(){

        return ypgg;
   }

   /**
   * 字段名：ypgg
   * set方法
   * 备注: 
   */
   public void setYpgg(String ypgg){
        this.ypgg = ypgg;
   }
   /**
   * 字段名：ypdw
   * get方法
   * 备注: 
   */
   public String getYpdw(){

        return ypdw;
   }

   /**
   * 字段名：ypdw
   * set方法
   * 备注: 
   */
   public void setYpdw(String ypdw){
        this.ypdw = ypdw;
   }
   /**
   * 字段名：ypxs
   * get方法
   * 备注: 
   */
   public BigDecimal getYpxs(){

        return ypxs;
   }

   /**
   * 字段名：ypxs
   * set方法
   * 备注: 
   */
   public void setYpxs(BigDecimal ypxs){
        this.ypxs = ypxs;
   }
   /**
   * 字段名：ykxs
   * get方法
   * 备注: 
   */
   public BigDecimal getYkxs(){

        return ykxs;
   }

   /**
   * 字段名：ykxs
   * set方法
   * 备注: 
   */
   public void setYkxs(BigDecimal ykxs){
        this.ykxs = ykxs;
   }
   /**
   * 字段名：mzdw
   * get方法
   * 备注: 
   */
   public String getMzdw(){

        return mzdw;
   }

   /**
   * 字段名：mzdw
   * set方法
   * 备注: 
   */
   public void setMzdw(String mzdw){
        this.mzdw = mzdw;
   }
   /**
   * 字段名：mzxs
   * get方法
   * 备注: 
   */
   public BigDecimal getMzxs(){

        return mzxs;
   }

   /**
   * 字段名：mzxs
   * set方法
   * 备注: 
   */
   public void setMzxs(BigDecimal mzxs){
        this.mzxs = mzxs;
   }
   /**
   * 字段名：ggdw
   * get方法
   * 备注: 
   */
   public String getGgdw(){

        return ggdw;
   }

   /**
   * 字段名：ggdw
   * set方法
   * 备注: 
   */
   public void setGgdw(String ggdw){
        this.ggdw = ggdw;
   }
   /**
   * 字段名：ggxs
   * get方法
   * 备注: 
   */
   public BigDecimal getGgxs(){

        return ggxs;
   }

   /**
   * 字段名：ggxs
   * set方法
   * 备注: 
   */
   public void setGgxs(BigDecimal ggxs){
        this.ggxs = ggxs;
   }
   /**
   * 字段名：zxdw
   * get方法
   * 备注: 
   */
   public String getZxdw(){

        return zxdw;
   }

   /**
   * 字段名：zxdw
   * set方法
   * 备注: 
   */
   public void setZxdw(String zxdw){
        this.zxdw = zxdw;
   }
   /**
   * 字段名：jxdm
   * get方法
   * 备注: 
   */
   public String getJxdm(){

        return jxdm;
   }

   /**
   * 字段名：jxdm
   * set方法
   * 备注: 
   */
   public void setJxdm(String jxdm){
        this.jxdm = jxdm;
   }
   /**
   * 字段名：jxmc
   * get方法
   * 备注: 
   */
   public String getJxmc(){

        return jxmc;
   }

   /**
   * 字段名：jxmc
   * set方法
   * 备注: 
   */
   public void setJxmc(String jxmc){
        this.jxmc = jxmc;
   }
   /**
   * 字段名：ylsj
   * get方法
   * 备注: 
   */
   public BigDecimal getYlsj(){

        return ylsj;
   }

   /**
   * 字段名：ylsj
   * set方法
   * 备注: 
   */
   public void setYlsj(BigDecimal ylsj){
        this.ylsj = ylsj;
   }
   /**
   * 字段名：ypfj
   * get方法
   * 备注: 
   */
   public BigDecimal getYpfj(){

        return ypfj;
   }

   /**
   * 字段名：ypfj
   * set方法
   * 备注: 
   */
   public void setYpfj(BigDecimal ypfj){
        this.ypfj = ypfj;
   }
   /**
   * 字段名：ypyf
   * get方法
   * 备注: 
   */
   public String getYpyf(){

        return ypyf;
   }

   /**
   * 字段名：ypyf
   * set方法
   * 备注: 
   */
   public void setYpyf(String ypyf){
        this.ypyf = ypyf;
   }
   /**
   * 字段名：ypyfmc
   * get方法
   * 备注: 
   */
   public String getYpyfmc(){

        return ypyfmc;
   }

   /**
   * 字段名：ypyfmc
   * set方法
   * 备注: 
   */
   public void setYpyfmc(String ypyfmc){
        this.ypyfmc = ypyfmc;
   }
   /**
   * 字段名：pcdm
   * get方法
   * 备注: 
   */
   public String getPcdm(){

        return pcdm;
   }

   /**
   * 字段名：pcdm
   * set方法
   * 备注: 
   */
   public void setPcdm(String pcdm){
        this.pcdm = pcdm;
   }
   /**
   * 字段名：pcmc
   * get方法
   * 备注: 
   */
   public String getPcmc(){

        return pcmc;
   }

   /**
   * 字段名：pcmc
   * set方法
   * 备注: 
   */
   public void setPcmc(String pcmc){
        this.pcmc = pcmc;
   }
   /**
   * 字段名：ypjl
   * get方法
   * 备注: 
   */
   public BigDecimal getYpjl(){

        return ypjl;
   }

   /**
   * 字段名：ypjl
   * set方法
   * 备注: 
   */
   public void setYpjl(BigDecimal ypjl){
        this.ypjl = ypjl;
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
   * 字段名：dwlb
   * get方法
   * 备注: 
   */
   public Integer getDwlb(){

        return dwlb;
   }

   /**
   * 字段名：dwlb
   * set方法
   * 备注: 
   */
   public void setDwlb(Integer dwlb){
        this.dwlb = dwlb;
   }
   /**
   * 字段名：ts
   * get方法
   * 备注: 
   */
   public Integer getTs(){

        return ts;
   }

   /**
   * 字段名：ts
   * set方法
   * 备注: 
   */
   public void setTs(Integer ts){
        this.ts = ts;
   }
   /**
   * 字段名：yfldsl
   * get方法
   * 备注: 
   */
   public Integer getYfldsl(){

        return yfldsl;
   }

   /**
   * 字段名：yfldsl
   * set方法
   * 备注: 
   */
   public void setYfldsl(Integer yfldsl){
        this.yfldsl = yfldsl;
   }
   /**
   * 字段名：ldlx
   * get方法
   * 备注: 
   */
   public String getLdlx(){

        return ldlx;
   }

   /**
   * 字段名：ldlx
   * set方法
   * 备注: 
   */
   public void setLdlx(String ldlx){
        this.ldlx = ldlx;
   }
   /**
   * 字段名：ldxh
   * get方法
   * 备注: 
   */
   public String getLdxh(){

        return ldxh;
   }

   /**
   * 字段名：ldxh
   * set方法
   * 备注: 
   */
   public void setLdxh(String ldxh){
        this.ldxh = ldxh;
   }
   /**
   * 字段名：ypsl
   * get方法
   * 备注: 
   */
   public BigDecimal getYpsl(){

        return ypsl;
   }

   /**
   * 字段名：ypsl
   * set方法
   * 备注: 
   */
   public void setYpsl(BigDecimal ypsl){
        this.ypsl = ypsl;
   }
   /**
   * 字段名：cyts
   * get方法
   * 备注: 
   */
   public Integer getCyts(){

        return cyts;
   }

   /**
   * 字段名：cyts
   * set方法
   * 备注: 
   */
   public void setCyts(Integer cyts){
        this.cyts = cyts;
   }
   /**
   * 字段名：shbz
   * get方法
   * 备注: 
   */
   public Boolean getShbz(){

        return shbz;
   }

   /**
   * 字段名：shbz
   * set方法
   * 备注: 
   */
   public void setShbz(Boolean shbz){
        this.shbz = shbz;
   }
   /**
   * 字段名：zbz
   * get方法
   * 备注: 
   */
   public Integer getZbz(){

        return zbz;
   }

   /**
   * 字段名：zbz
   * set方法
   * 备注: 
   */
   public void setZbz(Integer zbz){
        this.zbz = zbz;
   }
   /**
   * 字段名：mzdm
   * get方法
   * 备注: 
   */
   public String getMzdm(){

        return mzdm;
   }

   /**
   * 字段名：mzdm
   * set方法
   * 备注: 
   */
   public void setMzdm(String mzdm){
        this.mzdm = mzdm;
   }
   /**
   * 字段名：mzmc
   * get方法
   * 备注: 
   */
   public String getMzmc(){

        return mzmc;
   }

   /**
   * 字段名：mzmc
   * set方法
   * 备注: 
   */
   public void setMzmc(String mzmc){
        this.mzmc = mzmc;
   }
   /**
   * 字段名：fzxh
   * get方法
   * 备注: 
   */
   public Long getFzxh(){

        return fzxh;
   }

   /**
   * 字段名：fzxh
   * set方法
   * 备注: 
   */
   public void setFzxh(Long fzxh){
        this.fzxh = fzxh;
   }
   /**
   * 字段名：psbz
   * get方法
   * 备注: 
   */
   public Boolean getPsbz(){

        return psbz;
   }

   /**
   * 字段名：psbz
   * set方法
   * 备注: 
   */
   public void setPsbz(Boolean psbz){
        this.psbz = psbz;
   }
   /**
   * 字段名：zbbz
   * get方法
   * 备注: 
   */
   public Boolean getZbbz(){

        return zbbz;
   }

   /**
   * 字段名：zbbz
   * set方法
   * 备注: 
   */
   public void setZbbz(Boolean zbbz){
        this.zbbz = zbbz;
   }
   /**
   * 字段名：jjbz
   * get方法
   * 备注: 
   */
   public Integer getJjbz(){

        return jjbz;
   }

   /**
   * 字段名：jjbz
   * set方法
   * 备注: 
   */
   public void setJjbz(Integer jjbz){
        this.jjbz = jjbz;
   }
   /**
   * 字段名：jlzt
   * get方法
   * 备注: 
   */
   public Boolean getJlzt(){

        return jlzt;
   }

   /**
   * 字段名：jlzt
   * set方法
   * 备注: 
   */
   public void setJlzt(Boolean jlzt){
        this.jlzt = jlzt;
   }
   /**
   * 字段名：ybspbz
   * get方法
   * 备注: 
   */
   public Integer getYbspbz(){

        return ybspbz;
   }

   /**
   * 字段名：ybspbz
   * set方法
   * 备注: 
   */
   public void setYbspbz(Integer ybspbz){
        this.ybspbz = ybspbz;
   }
   /**
   * 字段名：ybjzbz
   * get方法
   * 备注: 
   */
   public Boolean getYbjzbz(){

        return ybjzbz;
   }

   /**
   * 字段名：ybjzbz
   * set方法
   * 备注: 
   */
   public void setYbjzbz(Boolean ybjzbz){
        this.ybjzbz = ybjzbz;
   }
   /**
   * 字段名：mzlybz
   * get方法
   * 备注: 
   */
   public Integer getMzlybz(){

        return mzlybz;
   }

   /**
   * 字段名：mzlybz
   * set方法
   * 备注: 
   */
   public void setMzlybz(Integer mzlybz){
        this.mzlybz = mzlybz;
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
   * 字段名：ljdyxh
   * get方法
   * 备注: 
   */
   public Long getLjdyxh(){

        return ljdyxh;
   }

   /**
   * 字段名：ljdyxh
   * set方法
   * 备注: 
   */
   public void setLjdyxh(Long ljdyxh){
        this.ljdyxh = ljdyxh;
   }
   /**
   * 字段名：xz
   * get方法
   * 备注: 
   */
   public Integer getXz(){

        return xz;
   }

   /**
   * 字段名：xz
   * set方法
   * 备注: 
   */
   public void setXz(Integer xz){
        this.xz = xz;
   }
   /**
   * 字段名：kzggdwxh
   * get方法
   * 备注: 
   */
   public Long getKzggdwxh(){

        return kzggdwxh;
   }

   /**
   * 字段名：kzggdwxh
   * set方法
   * 备注: 
   */
   public void setKzggdwxh(Long kzggdwxh){
        this.kzggdwxh = kzggdwxh;
   }
   /**
   * 字段名：tsdybz
   * get方法
   * 备注: 
   */
   public Integer getTsdybz(){

        return tsdybz;
   }

   /**
   * 字段名：tsdybz
   * set方法
   * 备注: 
   */
   public void setTsdybz(Integer tsdybz){
        this.tsdybz = tsdybz;
   }
   /**
   * 字段名：ksskzbz
   * get方法
   * 备注: 
   */
   public Integer getKsskzbz(){

        return ksskzbz;
   }

   /**
   * 字段名：ksskzbz
   * set方法
   * 备注: 
   */
   public void setKsskzbz(Integer ksskzbz){
        this.ksskzbz = ksskzbz;
   }
   /**
   * 字段名：bbzl
   * get方法
   * 备注: 
   */
   public String getBbzl(){

        return bbzl;
   }

   /**
   * 字段名：bbzl
   * set方法
   * 备注: 
   */
   public void setBbzl(String bbzl){
        this.bbzl = bbzl;
   }
   /**
   * 字段名：mrjldwbz
   * get方法
   * 备注: 
   */
   public Integer getMrjldwbz(){

        return mrjldwbz;
   }

   /**
   * 字段名：mrjldwbz
   * set方法
   * 备注: 
   */
   public void setMrjldwbz(Integer mrjldwbz){
        this.mrjldwbz = mrjldwbz;
   }
   /**
   * 字段名：zfbz
   * get方法
   * 备注: 
   */
   public Boolean getZfbz(){

        return zfbz;
   }

   /**
   * 字段名：zfbz
   * set方法
   * 备注: 
   */
   public void setZfbz(Boolean zfbz){
        this.zfbz = zfbz;
   }
   /**
   * 字段名：jlsm
   * get方法
   * 备注: 
   */
   public String getJlsm(){

        return jlsm;
   }

   /**
   * 字段名：jlsm
   * set方法
   * 备注: 
   */
   public void setJlsm(String jlsm){
        this.jlsm = jlsm;
   }
   /**
   * 字段名：psypdm
   * get方法
   * 备注: 
   */
   public String getPsypdm(){

        return psypdm;
   }

   /**
   * 字段名：psypdm
   * set方法
   * 备注: 
   */
   public void setPsypdm(String psypdm){
        this.psypdm = psypdm;
   }
   /**
   * 字段名：ybjyb
   * get方法
   * 备注: 
   */
   public Integer getYbjyb(){

        return ybjyb;
   }

   /**
   * 字段名：ybjyb
   * set方法
   * 备注: 
   */
   public void setYbjyb(Integer ybjyb){
        this.ybjyb = ybjyb;
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
   * 字段名：cqcfmxxh
   * get方法
   * 备注: 
   */
   public Long getCqcfmxxh(){

        return cqcfmxxh;
   }

   /**
   * 字段名：cqcfmxxh
   * set方法
   * 备注: 
   */
   public void setCqcfmxxh(Long cqcfmxxh){
        this.cqcfmxxh = cqcfmxxh;
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
   * 字段名：gdzlxmxh
   * get方法
   * 备注: 
   */
   public Long getGdzlxmxh(){

        return gdzlxmxh;
   }

   /**
   * 字段名：gdzlxmxh
   * set方法
   * 备注: 
   */
   public void setGdzlxmxh(Long gdzlxmxh){
        this.gdzlxmxh = gdzlxmxh;
   }
   /**
   * 字段名：cjrq
   * get方法
   * 备注: 
   */
   public String getCjrq(){

        return cjrq;
   }

   /**
   * 字段名：cjrq
   * set方法
   * 备注: 
   */
   public void setCjrq(String cjrq){
        this.cjrq = cjrq;
   }
   /**
   * 字段名：ybbz
   * get方法
   * 备注: 
   */
   public Boolean getYbbz(){

        return ybbz;
   }

   /**
   * 字段名：ybbz
   * set方法
   * 备注: 
   */
   public void setYbbz(Boolean ybbz){
        this.ybbz = ybbz;
   }
   /**
   * 字段名：tfbz
   * get方法
   * 备注: 
   */
   public Boolean getTfbz(){

        return tfbz;
   }

   /**
   * 字段名：tfbz
   * set方法
   * 备注: 
   */
   public void setTfbz(Boolean tfbz){
        this.tfbz = tfbz;
   }
   /**
   * 字段名：cjlqm
   * get方法
   * 备注: 
   */
   public Integer getCjlqm(){

        return cjlqm;
   }

   /**
   * 字段名：cjlqm
   * set方法
   * 备注: 
   */
   public void setCjlqm(Integer cjlqm){
        this.cjlqm = cjlqm;
   }
   /**
   * 字段名：mbbz
   * get方法
   * 备注: 
   */
   public Boolean getMbbz(){

        return mbbz;
   }

   /**
   * 字段名：mbbz
   * set方法
   * 备注: 
   */
   public void setMbbz(Boolean mbbz){
        this.mbbz = mbbz;
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

}