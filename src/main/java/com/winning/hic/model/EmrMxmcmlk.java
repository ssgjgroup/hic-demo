package com.winning.hic.model;

import java.util.Date; 
import java.io.Serializable; 

import com.winning.hic.model.BaseDomain;

import org.apache.ibatis.type.Alias; 



/**
 * @author HLHT
 * @title 模型名称目录库
 * @email Winning Health
 * @package com.winning.hic.model
 * @date 2018-19-14 17:19:02
 */
@Alias("emrMxmcmlk")
public class EmrMxmcmlk extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 字段名：yljgdm
     * 备注: 
     * 默认值：无
     */
    private String yljgdm;
    /**
     * 字段名：mxmcmlkkey
     * 备注: 
     * 默认值：无
     */
    private Long mxmcmlkkey;
    /**
     * 字段名：mldm
     * 备注: 
     * 默认值：无
     */
    private String mldm;
    /**
     * 字段名：mlmc
     * 备注: 
     * 默认值：无
     */
    private String mlmc;
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
     * 字段名：sjdm
     * 备注: 
     * 默认值：无
     */
    private String sjdm;
    /**
     * 字段名：mlcc
     * 备注: 
     * 默认值：无
     */
    private Integer mlcc;
    /**
     * 字段名：yxjl
     * 备注: 
     * 默认值：无
     */
    private Short yxjl;
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
    /**
     * 字段名：isdelete
     * 备注: 
     * 默认值：无
     */
    private String isdelete;

    public EmrMxmcmlk (){

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
   * 字段名：mxmcmlkkey
   * get方法
   * 备注: 
   */
   public Long getMxmcmlkkey(){

        return mxmcmlkkey;
   }

   /**
   * 字段名：mxmcmlkkey
   * set方法
   * 备注: 
   */
   public void setMxmcmlkkey(Long mxmcmlkkey){
        this.mxmcmlkkey = mxmcmlkkey;
   }
   /**
   * 字段名：mldm
   * get方法
   * 备注: 
   */
   public String getMldm(){

        return mldm;
   }

   /**
   * 字段名：mldm
   * set方法
   * 备注: 
   */
   public void setMldm(String mldm){
        this.mldm = mldm;
   }
   /**
   * 字段名：mlmc
   * get方法
   * 备注: 
   */
   public String getMlmc(){

        return mlmc;
   }

   /**
   * 字段名：mlmc
   * set方法
   * 备注: 
   */
   public void setMlmc(String mlmc){
        this.mlmc = mlmc;
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
   * 字段名：sjdm
   * get方法
   * 备注: 
   */
   public String getSjdm(){

        return sjdm;
   }

   /**
   * 字段名：sjdm
   * set方法
   * 备注: 
   */
   public void setSjdm(String sjdm){
        this.sjdm = sjdm;
   }
   /**
   * 字段名：mlcc
   * get方法
   * 备注: 
   */
   public Integer getMlcc(){

        return mlcc;
   }

   /**
   * 字段名：mlcc
   * set方法
   * 备注: 
   */
   public void setMlcc(Integer mlcc){
        this.mlcc = mlcc;
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


    public MBNoteTree getMBPNoteTree(){
        MBNoteTree tree = new MBNoteTree();
        tree.setNodeId(mldm);
        tree.setNodePid("-1");
        tree.setNodeName(mlmc);
        tree.setNodeDesc(mlmc);
        tree.setParent(Integer.parseInt(getMap().get("num").toString()) == 0 ? false : true);
        if(mldm.startsWith("B") && (Integer.parseInt(getMap().get("num").toString()) == 0)){
            tree.setHidden(true);
        }
        if(Integer.parseInt(getMap().get("num").toString()) == 0 ){
            tree.setIcon("glyphicon glyphicon-leaf");
        }else{
            tree.setIconClose("glyphicon glyphicon-chevron-right");
            tree.setIconOpen("glyphicon glyphicon-chevron-down");
        }

        return tree;
    }
    public MBNoteTree getMBNoteTree(){
        MBNoteTree tree = new MBNoteTree();
        tree.setNodeId(mldm);
        tree.setNodePid(mldm.substring(0,mldm.length()-2));
        tree.setNodeName(mlmc);
        tree.setNodeDesc(mlmc);
        tree.setParent(Integer.parseInt(getMap().get("num").toString()) == 0 ? false : true);
        if(mldm.startsWith("B") && (Integer.parseInt(getMap().get("num").toString()) == 0)){
            tree.setHidden(true);
        }
        if(Integer.parseInt(getMap().get("num").toString()) == 0 ){
            tree.setIcon("glyphicon glyphicon-leaf");
        }else{
            tree.setIconClose("glyphicon glyphicon-chevron-right");
            tree.setIconOpen("glyphicon glyphicon-chevron-down");
        }

        return tree;
    }

}