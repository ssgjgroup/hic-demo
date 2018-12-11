package com.winning.hic.model;

import java.util.Date; 
import java.io.Serializable; 

import org.apache.ibatis.type.Alias; 

import com.winning.hic.model.BaseDomain;



/**
 * @author HLHT
 * @title 
 * @email Winning Health
 * @package com.winning.hic.model
 * @date 2018-07-10 12:07:29
 */
@Alias("mbzDataError")
public class MbzDataError extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 字段名：ID
     * 备注: 
     * 默认值：无
     */
    private String id;
    /**
     * 字段名：CLASS_NAME
     * 备注: 
     * 默认值：无
     */
    private String className;
    /**
     * 字段名：METHOD_NAME
     * 备注: 
     * 默认值：无
     */
    private String methodName;
    /**
     * 字段名：ARGUMENT_STRING
     * 备注: 
     * 默认值：无
     */
    private String argumentString;
    /**
     * 字段名：ERROR_MESSAGE
     * 备注: 
     * 默认值：无
     */
    private String errorMessage;
    /**
     * 字段名：ERROR_TIME
     * 备注: 
     * 默认值：(getdate())
     */
    private Date errorTime;

    public MbzDataError (){

    }

   /**
   * 字段名：ID
   * get方法
   * 备注: 
   */
   public String getId(){

        return id;
   }

   /**
   * 字段名：ID
   * set方法
   * 备注: 
   */
   public void setId(String id){
        this.id = id;
   }
   /**
   * 字段名：CLASS_NAME
   * get方法
   * 备注: 
   */
   public String getClassName(){

        return className;
   }

   /**
   * 字段名：CLASS_NAME
   * set方法
   * 备注: 
   */
   public void setClassName(String className){
        this.className = className;
   }
   /**
   * 字段名：METHOD_NAME
   * get方法
   * 备注: 
   */
   public String getMethodName(){

        return methodName;
   }

   /**
   * 字段名：METHOD_NAME
   * set方法
   * 备注: 
   */
   public void setMethodName(String methodName){
        this.methodName = methodName;
   }
   /**
   * 字段名：ARGUMENT_STRING
   * get方法
   * 备注: 
   */
   public String getArgumentString(){

        return argumentString;
   }

   /**
   * 字段名：ARGUMENT_STRING
   * set方法
   * 备注: 
   */
   public void setArgumentString(String argumentString){
        this.argumentString = argumentString;
   }
   /**
   * 字段名：ERROR_MESSAGE
   * get方法
   * 备注: 
   */
   public String getErrorMessage(){

        return errorMessage;
   }

   /**
   * 字段名：ERROR_MESSAGE
   * set方法
   * 备注: 
   */
   public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
   }
   /**
   * 字段名：ERROR_TIME
   * get方法
   * 备注: 
   */
   public Date getErrorTime(){

        return errorTime;
   }

   private String sourceName;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /**
   * 字段名：ERROR_TIME
   * set方法
   * 备注: 
   */
   public void setErrorTime(Date errorTime){
        this.errorTime = errorTime;
   }

    @Override
    public String toString() {
        return "MbzDataError{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", argumentString='" + argumentString + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorTime=" + errorTime +
                '}';
    }
}