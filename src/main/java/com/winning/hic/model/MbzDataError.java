package com.winning.hic.model;

import java.util.Date; 
import java.io.Serializable; 

import org.apache.ibatis.type.Alias; 

import com.winning.hic.model.BaseDomain;


/**
 * @author ISC [Implementation service center]
 * @title 
 * @email Winning Health
 * @package com.winning.hic.model
 * @date 2018-07-08 16:07:19
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }
}