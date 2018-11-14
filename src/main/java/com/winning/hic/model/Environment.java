package com.winning.hic.model;

import com.winning.hic.base.Constants;

/**
 * Created with IntelliJ IDEA.
 * Description: 数据库参数信息
 * User: LENOVO
 * Date: 2018-07-24
 * Time: 14:53
 */
public class Environment {
	//管理库
    private String cmDataCenterdbUrl;
    private String cmDataCenterdbName;
    private String cmDataCenterdbUsername;
    private String cmDataCenterdbPassword;
    //数据仓库
    private String hdwdbUrl;
    private String hdwdbName;
    private String hdwdbUsername;
    private String hdwdbPassword;
    
    
    public String getCMDATACENTERDB_URL(){
        return Constants.URL_PREFIX +cmDataCenterdbUrl+";"+Constants.DATABASE_PREFIX+"="+cmDataCenterdbName;
    }
    
    public String getHDWDB_URL(){
        return Constants.URL_PREFIX +hdwdbUrl+";"+Constants.DATABASE_PREFIX+"="+hdwdbName;
    }
    
    public String getCmDataCenterdbUrl() {
		return cmDataCenterdbUrl;
	}

	public void setCmDataCenterdbUrl(String cmDataCenterdbUrl) {
		this.cmDataCenterdbUrl = cmDataCenterdbUrl;
	}

	public String getCmDataCenterdbName() {
		return cmDataCenterdbName;
	}

	public void setCmDataCenterdbName(String cmDataCenterdbName) {
		this.cmDataCenterdbName = cmDataCenterdbName;
	}

	public String getCmDataCenterdbUsername() {
		return cmDataCenterdbUsername;
	}

	public void setCmDataCenterdbUsername(String cmDataCenterdbUsername) {
		this.cmDataCenterdbUsername = cmDataCenterdbUsername;
	}

	public String getCmDataCenterdbPassword() {
		return cmDataCenterdbPassword;
	}

	public void setCmDataCenterdbPassword(String cmDataCenterdbPassword) {
		this.cmDataCenterdbPassword = cmDataCenterdbPassword;
	}

	public String getHdwdbUrl() {
		return hdwdbUrl;
	}

	public void setHdwdbUrl(String hdwdbUrl) {
		this.hdwdbUrl = hdwdbUrl;
	}

	public String getHdwdbName() {
		return hdwdbName;
	}

	public void setHdwdbName(String hdwdbName) {
		this.hdwdbName = hdwdbName;
	}

	public String getHdwdbUsername() {
		return hdwdbUsername;
	}

	public void setHdwdbUsername(String hdwdbUsername) {
		this.hdwdbUsername = hdwdbUsername;
	}

	public String getHdwdbPassword() {
		return hdwdbPassword;
	}

	public void setHdwdbPassword(String hdwdbPassword) {
		this.hdwdbPassword = hdwdbPassword;
	}
}
