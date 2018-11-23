package com.winning.hic.model;

import java.util.Date; 
import java.io.Serializable; 

import com.winning.hic.model.BaseDomain;

import org.apache.ibatis.type.Alias; 



/**
 * @author HLHT
 * @title 
 * @email Winning Health
 * @package com.winning.hic.model
 * @date 2018-50-23 14:50:38
 */
@Alias("emrMbk")
public class EmrMbk extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 字段名：yljgdm
     * 备注: 
     * 默认值：无
     */
    private String yljgdm;
    /**
     * 字段名：mbdm
     * 备注: 
     * 默认值：无
     */
    private String mbdm;
    /**
     * 字段名：mbmc
     * 备注: 
     * 默认值：无
     */
    private String mbmc;
    /**
     * 字段名：mbms
     * 备注: 
     * 默认值：无
     */
    private String mbms;
    /**
     * 字段名：mbnr
     * 备注: 
     * 默认值：无
     */
    private String mbnr;
    /**
     * 字段名：version
     * 备注: 
     * 默认值：无
     */
    private String version;
    /**
     * 字段名：mxfldm
     * 备注: 
     * 默认值：无
     */
    private String mxfldm;
    /**
     * 字段名：bzdm
     * 备注: 
     * 默认值：无
     */
    private String bzdm;
    /**
     * 字段名：dymb
     * 备注: 
     * 默认值：无
     */
    private String dymb;
    /**
     * 字段名：yxjl
     * 备注: 
     * 默认值：无
     */
    private Short yxjl;
    /**
     * 字段名：xgsj
     * 备注: 
     * 默认值：无
     */
    private String xgsj;
    /**
     * 字段名：grmbbz
     * 备注: 
     * 默认值：无
     */
    private Short grmbbz;
    /**
     * 字段名：xsysz
     * 备注: 
     * 默认值：无
     */
    private String xsysz;
    /**
     * 字段名：xbbz
     * 备注: 
     * 默认值：无
     */
    private Short xbbz;
    /**
     * 字段名：blbm
     * 备注: 
     * 默认值：无
     */
    private String blbm;
    /**
     * 字段名：sfhlhtmb
     * 备注: 
     * 默认值：无
     */
    private Short sfhlhtmb;
    /**
     * 字段名：iscurrent
     * 备注: 
     * 默认值：((1))
     */
    private Boolean iscurrent;
    /**
     * 字段名：gxrq
     * 备注: 
     * 默认值：(getdate())
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

    public EmrMbk (){

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
   * 字段名：mbdm
   * get方法
   * 备注: 
   */
   public String getMbdm(){

        return mbdm;
   }

   /**
   * 字段名：mbdm
   * set方法
   * 备注: 
   */
   public void setMbdm(String mbdm){
        this.mbdm = mbdm;
   }
   /**
   * 字段名：mbmc
   * get方法
   * 备注: 
   */
   public String getMbmc(){

        return mbmc;
   }

   /**
   * 字段名：mbmc
   * set方法
   * 备注: 
   */
   public void setMbmc(String mbmc){
        this.mbmc = mbmc;
   }
   /**
   * 字段名：mbms
   * get方法
   * 备注: 
   */
   public String getMbms(){

        return mbms;
   }

   /**
   * 字段名：mbms
   * set方法
   * 备注: 
   */
   public void setMbms(String mbms){
        this.mbms = mbms;
   }
   /**
   * 字段名：mbnr
   * get方法
   * 备注: 
   */
   public String getMbnr(){

        return mbnr;
   }

   /**
   * 字段名：mbnr
   * set方法
   * 备注: 
   */
   public void setMbnr(String mbnr){
        this.mbnr = mbnr;
   }
   /**
   * 字段名：version
   * get方法
   * 备注: 
   */
   public String getVersion(){

        return version;
   }

   /**
   * 字段名：version
   * set方法
   * 备注: 
   */
   public void setVersion(String version){
        this.version = version;
   }
   /**
   * 字段名：mxfldm
   * get方法
   * 备注: 
   */
   public String getMxfldm(){

        return mxfldm;
   }

   /**
   * 字段名：mxfldm
   * set方法
   * 备注: 
   */
   public void setMxfldm(String mxfldm){
        this.mxfldm = mxfldm;
   }
   /**
   * 字段名：bzdm
   * get方法
   * 备注: 
   */
   public String getBzdm(){

        return bzdm;
   }

   /**
   * 字段名：bzdm
   * set方法
   * 备注: 
   */
   public void setBzdm(String bzdm){
        this.bzdm = bzdm;
   }
   /**
   * 字段名：dymb
   * get方法
   * 备注: 
   */
   public String getDymb(){

        return dymb;
   }

   /**
   * 字段名：dymb
   * set方法
   * 备注: 
   */
   public void setDymb(String dymb){
        this.dymb = dymb;
   }
   /**
   * 字段名：yxjl
   * get方法
   * 备注: 
   */
   public Short getYxjl(){

        return yxjl;
   }

   /**
   * 字段名：yxjl
   * set方法
   * 备注: 
   */
   public void setYxjl(Short yxjl){
        this.yxjl = yxjl;
   }
   /**
   * 字段名：xgsj
   * get方法
   * 备注: 
   */
   public String getXgsj(){

        return xgsj;
   }

   /**
   * 字段名：xgsj
   * set方法
   * 备注: 
   */
   public void setXgsj(String xgsj){
        this.xgsj = xgsj;
   }
   /**
   * 字段名：grmbbz
   * get方法
   * 备注: 
   */
   public Short getGrmbbz(){

        return grmbbz;
   }

   /**
   * 字段名：grmbbz
   * set方法
   * 备注: 
   */
   public void setGrmbbz(Short grmbbz){
        this.grmbbz = grmbbz;
   }
   /**
   * 字段名：xsysz
   * get方法
   * 备注: 
   */
   public String getXsysz(){

        return xsysz;
   }

   /**
   * 字段名：xsysz
   * set方法
   * 备注: 
   */
   public void setXsysz(String xsysz){
        this.xsysz = xsysz;
   }
   /**
   * 字段名：xbbz
   * get方法
   * 备注: 
   */
   public Short getXbbz(){

        return xbbz;
   }

   /**
   * 字段名：xbbz
   * set方法
   * 备注: 
   */
   public void setXbbz(Short xbbz){
        this.xbbz = xbbz;
   }
   /**
   * 字段名：blbm
   * get方法
   * 备注: 
   */
   public String getBlbm(){

        return blbm;
   }

   /**
   * 字段名：blbm
   * set方法
   * 备注: 
   */
   public void setBlbm(String blbm){
        this.blbm = blbm;
   }
   /**
   * 字段名：sfhlhtmb
   * get方法
   * 备注: 
   */
   public Short getSfhlhtmb(){

        return sfhlhtmb;
   }

   /**
   * 字段名：sfhlhtmb
   * set方法
   * 备注: 
   */
   public void setSfhlhtmb(Short sfhlhtmb){
        this.sfhlhtmb = sfhlhtmb;
   }
   /**
   * 字段名：iscurrent
   * get方法
   * 备注: 
   */
   public Boolean getIscurrent(){

        return iscurrent;
   }

   /**
   * 字段名：iscurrent
   * set方法
   * 备注: 
   */
   public void setIscurrent(Boolean iscurrent){
        this.iscurrent = iscurrent;
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

}