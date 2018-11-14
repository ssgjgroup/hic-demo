package com.winning.hic.model;

import java.util.Date; 
import java.util.Date; 
import java.io.Serializable; 

import org.apache.ibatis.type.Alias; 

import com.winning.hic.model.BaseDomain;



/**
 * @author HLHT
 * @title 
 * @email Winning Health
 * @package com.winning.hic.model
 * @date 2018-42-14 13:42:44
 */
@Alias("dcRyjlRcyjlCyxyzd")
public class DcRyjlRcyjlCyxyzd extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 字段名：xh
     * 备注: 
     * 默认值：无
     */
    private Long xh;
    /**
     * 字段名：yljgdm
     * 备注: 
     * 默认值：无
     */
    private String yljgdm;
    /**
     * 字段名：yjlxh
     * 备注: 
     * 默认值：无
     */
    private String yjlxh;
    /**
     * 字段名：zyjlxh
     * 备注: 
     * 默认值：无
     */
    private String zyjlxh;
    /**
     * 字段名：czxyzdmc
     * 备注: 
     * 默认值：无
     */
    private String czxyzdmc;
    /**
     * 字段名：czxyzdbm
     * 备注: 
     * 默认值：无
     */
    private String czxyzdbm;
    /**
     * 字段名：sys_id
     * 备注: 
     * 默认值：无
     */
    private String sysId;
    /**
     * 字段名：gxsj
     * 备注: 
     * 默认值：无
     */
    private Date gxsj;
    /**
     * 字段名：sjcqsj
     * 备注: 
     * 默认值：(getdate())
     */
    private Date sjcqsj;
    /**
     * 字段名：pcxh
     * 备注: 
     * 默认值：无
     */
    private String pcxh;

    public DcRyjlRcyjlCyxyzd (){

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
   * 字段名：yjlxh
   * get方法
   * 备注: 
   */
   public String getYjlxh(){

        return yjlxh;
   }

   /**
   * 字段名：yjlxh
   * set方法
   * 备注: 
   */
   public void setYjlxh(String yjlxh){
        this.yjlxh = yjlxh;
   }
   /**
   * 字段名：zyjlxh
   * get方法
   * 备注: 
   */
   public String getZyjlxh(){

        return zyjlxh;
   }

   /**
   * 字段名：zyjlxh
   * set方法
   * 备注: 
   */
   public void setZyjlxh(String zyjlxh){
        this.zyjlxh = zyjlxh;
   }
   /**
   * 字段名：czxyzdmc
   * get方法
   * 备注: 
   */
   public String getCzxyzdmc(){

        return czxyzdmc;
   }

   /**
   * 字段名：czxyzdmc
   * set方法
   * 备注: 
   */
   public void setCzxyzdmc(String czxyzdmc){
        this.czxyzdmc = czxyzdmc;
   }
   /**
   * 字段名：czxyzdbm
   * get方法
   * 备注: 
   */
   public String getCzxyzdbm(){

        return czxyzdbm;
   }

   /**
   * 字段名：czxyzdbm
   * set方法
   * 备注: 
   */
   public void setCzxyzdbm(String czxyzdbm){
        this.czxyzdbm = czxyzdbm;
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
   * 字段名：gxsj
   * get方法
   * 备注: 
   */
   public Date getGxsj(){

        return gxsj;
   }

   /**
   * 字段名：gxsj
   * set方法
   * 备注: 
   */
   public void setGxsj(Date gxsj){
        this.gxsj = gxsj;
   }
   /**
   * 字段名：sjcqsj
   * get方法
   * 备注: 
   */
   public Date getSjcqsj(){

        return sjcqsj;
   }

   /**
   * 字段名：sjcqsj
   * set方法
   * 备注: 
   */
   public void setSjcqsj(Date sjcqsj){
        this.sjcqsj = sjcqsj;
   }
   /**
   * 字段名：pcxh
   * get方法
   * 备注: 
   */
   public String getPcxh(){

        return pcxh;
   }

   /**
   * 字段名：pcxh
   * set方法
   * 备注: 
   */
   public void setPcxh(String pcxh){
        this.pcxh = pcxh;
   }

}