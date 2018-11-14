package com.winning.hic.model;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable; 

import com.winning.hic.model.BaseDomain;

import org.apache.ibatis.type.Alias; 



/**
 * @author HLHT
 * @title 
 * @email Winning Health
 * @package com.winning.hic.model
 * @date 2018-27-14 17:27:52
 */
@Alias("emrQtbljlk")
public class EmrQtbljlk extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 字段名：yljgdm
     * 备注: 
     * 默认值：无
     */
    private String yljgdm;
    /**
     * 字段名：qtbljlxh
     * 备注: 
     * 默认值：无
     */
    private Long qtbljlxh;
    /**
     * 字段名：syxh
     * 备注: 
     * 默认值：无
     */
    private Integer syxh;
    /**
     * 字段名：bldm
     * 备注: 
     * 默认值：无
     */
    private String bldm;
    /**
     * 字段名：blmc
     * 备注: 
     * 默认值：无
     */
    private String blmc;
    /**
     * 字段名：blms
     * 备注: 
     * 默认值：无
     */
    private String blms;
    /**
     * 字段名：blnr
     * 备注: 
     * 默认值：无
     */
    private String blnr;
    /**
     * 字段名：mxfldm
     * 备注: 
     * 默认值：无
     */
    private String mxfldm;
    /**
     * 字段名：cjys
     * 备注: 
     * 默认值：无
     */
    private String cjys;
    /**
     * 字段名：shys
     * 备注: 
     * 默认值：无
     */
    private String shys;
    /**
     * 字段名：cjsj
     * 备注: 
     * 默认值：无
     */
    private Timestamp cjsj;
    /**
     * 字段名：shsj
     * 备注: 
     * 默认值：无
     */
    private Timestamp shsj;
    /**
     * 字段名：yxjl
     * 备注: 
     * 默认值：无
     */
    private Short yxjl;
    /**
     * 字段名：tjzt
     * 备注: 
     * 默认值：无
     */
    private Short tjzt;
    /**
     * 字段名：dyzt
     * 备注: 
     * 默认值：无
     */
    private Short dyzt;
    /**
     * 字段名：dzqmbz
     * 备注: 
     * 默认值：无
     */
    private Short dzqmbz;
    /**
     * 字段名：containerid
     * 备注: 
     * 默认值：无
     */
    private String containerid;
    /**
     * 字段名：fssj
     * 备注: 
     * 默认值：无
     */
    private Timestamp fssj;
    /**
     * 字段名：instanceversion
     * 备注: 
     * 默认值：无
     */
    private Integer instanceversion;
    /**
     * 字段名：dczt
     * 备注: 
     * 默认值：无
     */
    private Short dczt;
    /**
     * 字段名：dcczsj
     * 备注: 
     * 默认值：无
     */
    private Date dcczsj;
    /**
     * 字段名：blxsmc
     * 备注: 
     * 默认值：无
     */
    private String blxsmc;
    /**
     * 字段名：tjys
     * 备注: 
     * 默认值：无
     */
    private String tjys;
    /**
     * 字段名：tjsj
     * 备注: 
     * 默认值：无
     */
    private Date tjsj;
    /**
     * 字段名：yshysdm
     * 备注: 
     * 默认值：无
     */
    private String yshysdm;
    /**
     * 字段名：yshysxm
     * 备注: 
     * 默认值：无
     */
    private String yshysxm;
    /**
     * 字段名：sfhlhtmb
     * 备注: 
     * 默认值：无
     */
    private Short sfhlhtmb;
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
    /**
     * 字段名：gxrq_cis
     * 备注: 
     * 默认值：无
     */
    private Date gxrqCis;

    public EmrQtbljlk (){

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
   * 字段名：qtbljlxh
   * get方法
   * 备注: 
   */
   public Long getQtbljlxh(){

        return qtbljlxh;
   }

   /**
   * 字段名：qtbljlxh
   * set方法
   * 备注: 
   */
   public void setQtbljlxh(Long qtbljlxh){
        this.qtbljlxh = qtbljlxh;
   }
   /**
   * 字段名：syxh
   * get方法
   * 备注: 
   */
   public Integer getSyxh(){

        return syxh;
   }

   /**
   * 字段名：syxh
   * set方法
   * 备注: 
   */
   public void setSyxh(Integer syxh){
        this.syxh = syxh;
   }
   /**
   * 字段名：bldm
   * get方法
   * 备注: 
   */
   public String getBldm(){

        return bldm;
   }

   /**
   * 字段名：bldm
   * set方法
   * 备注: 
   */
   public void setBldm(String bldm){
        this.bldm = bldm;
   }
   /**
   * 字段名：blmc
   * get方法
   * 备注: 
   */
   public String getBlmc(){

        return blmc;
   }

   /**
   * 字段名：blmc
   * set方法
   * 备注: 
   */
   public void setBlmc(String blmc){
        this.blmc = blmc;
   }
   /**
   * 字段名：blms
   * get方法
   * 备注: 
   */
   public String getBlms(){

        return blms;
   }

   /**
   * 字段名：blms
   * set方法
   * 备注: 
   */
   public void setBlms(String blms){
        this.blms = blms;
   }
   /**
   * 字段名：blnr
   * get方法
   * 备注: 
   */
   public String getBlnr(){

        return blnr;
   }

   /**
   * 字段名：blnr
   * set方法
   * 备注: 
   */
   public void setBlnr(String blnr){
        this.blnr = blnr;
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
   * 字段名：cjys
   * get方法
   * 备注: 
   */
   public String getCjys(){

        return cjys;
   }

   /**
   * 字段名：cjys
   * set方法
   * 备注: 
   */
   public void setCjys(String cjys){
        this.cjys = cjys;
   }
   /**
   * 字段名：shys
   * get方法
   * 备注: 
   */
   public String getShys(){

        return shys;
   }

   /**
   * 字段名：shys
   * set方法
   * 备注: 
   */
   public void setShys(String shys){
        this.shys = shys;
   }
   /**
   * 字段名：cjsj
   * get方法
   * 备注: 
   */
   public Timestamp getCjsj(){

        return cjsj;
   }

   /**
   * 字段名：cjsj
   * set方法
   * 备注: 
   */
   public void setCjsj(Timestamp cjsj){
        this.cjsj = cjsj;
   }
   /**
   * 字段名：shsj
   * get方法
   * 备注: 
   */
   public Timestamp getShsj(){

        return shsj;
   }

   /**
   * 字段名：shsj
   * set方法
   * 备注: 
   */
   public void setShsj(Timestamp shsj){
        this.shsj = shsj;
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
   * 字段名：tjzt
   * get方法
   * 备注: 
   */
   public Short getTjzt(){

        return tjzt;
   }

   /**
   * 字段名：tjzt
   * set方法
   * 备注: 
   */
   public void setTjzt(Short tjzt){
        this.tjzt = tjzt;
   }
   /**
   * 字段名：dyzt
   * get方法
   * 备注: 
   */
   public Short getDyzt(){

        return dyzt;
   }

   /**
   * 字段名：dyzt
   * set方法
   * 备注: 
   */
   public void setDyzt(Short dyzt){
        this.dyzt = dyzt;
   }
   /**
   * 字段名：dzqmbz
   * get方法
   * 备注: 
   */
   public Short getDzqmbz(){

        return dzqmbz;
   }

   /**
   * 字段名：dzqmbz
   * set方法
   * 备注: 
   */
   public void setDzqmbz(Short dzqmbz){
        this.dzqmbz = dzqmbz;
   }
   /**
   * 字段名：containerid
   * get方法
   * 备注: 
   */
   public String getContainerid(){

        return containerid;
   }

   /**
   * 字段名：containerid
   * set方法
   * 备注: 
   */
   public void setContainerid(String containerid){
        this.containerid = containerid;
   }
   /**
   * 字段名：fssj
   * get方法
   * 备注: 
   */
   public Timestamp getFssj(){

        return fssj;
   }

   /**
   * 字段名：fssj
   * set方法
   * 备注: 
   */
   public void setFssj(Timestamp fssj){
        this.fssj = fssj;
   }
   /**
   * 字段名：instanceversion
   * get方法
   * 备注: 
   */
   public Integer getInstanceversion(){

        return instanceversion;
   }

   /**
   * 字段名：instanceversion
   * set方法
   * 备注: 
   */
   public void setInstanceversion(Integer instanceversion){
        this.instanceversion = instanceversion;
   }
   /**
   * 字段名：dczt
   * get方法
   * 备注: 
   */
   public Short getDczt(){

        return dczt;
   }

   /**
   * 字段名：dczt
   * set方法
   * 备注: 
   */
   public void setDczt(Short dczt){
        this.dczt = dczt;
   }
   /**
   * 字段名：dcczsj
   * get方法
   * 备注: 
   */
   public Date getDcczsj(){

        return dcczsj;
   }

   /**
   * 字段名：dcczsj
   * set方法
   * 备注: 
   */
   public void setDcczsj(Date dcczsj){
        this.dcczsj = dcczsj;
   }
   /**
   * 字段名：blxsmc
   * get方法
   * 备注: 
   */
   public String getBlxsmc(){

        return blxsmc;
   }

   /**
   * 字段名：blxsmc
   * set方法
   * 备注: 
   */
   public void setBlxsmc(String blxsmc){
        this.blxsmc = blxsmc;
   }
   /**
   * 字段名：tjys
   * get方法
   * 备注: 
   */
   public String getTjys(){

        return tjys;
   }

   /**
   * 字段名：tjys
   * set方法
   * 备注: 
   */
   public void setTjys(String tjys){
        this.tjys = tjys;
   }
   /**
   * 字段名：tjsj
   * get方法
   * 备注: 
   */
   public Date getTjsj(){

        return tjsj;
   }

   /**
   * 字段名：tjsj
   * set方法
   * 备注: 
   */
   public void setTjsj(Date tjsj){
        this.tjsj = tjsj;
   }
   /**
   * 字段名：yshysdm
   * get方法
   * 备注: 
   */
   public String getYshysdm(){

        return yshysdm;
   }

   /**
   * 字段名：yshysdm
   * set方法
   * 备注: 
   */
   public void setYshysdm(String yshysdm){
        this.yshysdm = yshysdm;
   }
   /**
   * 字段名：yshysxm
   * get方法
   * 备注: 
   */
   public String getYshysxm(){

        return yshysxm;
   }

   /**
   * 字段名：yshysxm
   * set方法
   * 备注: 
   */
   public void setYshysxm(String yshysxm){
        this.yshysxm = yshysxm;
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
   /**
   * 字段名：gxrq_cis
   * get方法
   * 备注: 
   */
   public Date getGxrqCis(){

        return gxrqCis;
   }

   /**
   * 字段名：gxrq_cis
   * set方法
   * 备注: 
   */
   public void setGxrqCis(Date gxrqCis){
        this.gxrqCis = gxrqCis;
   }

}