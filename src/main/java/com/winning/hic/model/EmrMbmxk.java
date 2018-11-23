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
 * @date 2018-53-23 14:53:45
 */
@Alias("emrMbmxk")
public class EmrMbmxk extends BaseDomain implements Serializable {

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
     * 字段名：jdrefid
     * 备注: 
     * 默认值：无
     */
    private Integer jdrefid;
    /**
     * 字段名：jddm
     * 备注: 
     * 默认值：无
     */
    private String jddm;
    /**
     * 字段名：jdlx
     * 备注: 
     * 默认值：无
     */
    private String jdlx;
    /**
     * 字段名：jdnr
     * 备注: 
     * 默认值：无
     */
    private String jdnr;
    /**
     * 字段名：memo
     * 备注: 
     * 默认值：无
     */
    private String memo;
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

    public EmrMbmxk (){

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
   * 字段名：jdrefid
   * get方法
   * 备注: 
   */
   public Integer getJdrefid(){

        return jdrefid;
   }

   /**
   * 字段名：jdrefid
   * set方法
   * 备注: 
   */
   public void setJdrefid(Integer jdrefid){
        this.jdrefid = jdrefid;
   }
   /**
   * 字段名：jddm
   * get方法
   * 备注: 
   */
   public String getJddm(){

        return jddm;
   }

   /**
   * 字段名：jddm
   * set方法
   * 备注: 
   */
   public void setJddm(String jddm){
        this.jddm = jddm;
   }
   /**
   * 字段名：jdlx
   * get方法
   * 备注: 
   */
   public String getJdlx(){

        return jdlx;
   }

   /**
   * 字段名：jdlx
   * set方法
   * 备注: 
   */
   public void setJdlx(String jdlx){
        this.jdlx = jdlx;
   }
   /**
   * 字段名：jdnr
   * get方法
   * 备注: 
   */
   public String getJdnr(){

        return jdnr;
   }

   /**
   * 字段名：jdnr
   * set方法
   * 备注: 
   */
   public void setJdnr(String jdnr){
        this.jdnr = jdnr;
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