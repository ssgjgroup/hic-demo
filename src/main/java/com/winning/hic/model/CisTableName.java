package com.winning.hic.model;

/**
 * @author chensj
 * @title
 * @email chensj@winning.com.cn
 * @package com.winning.hic.model
 * @date: 2018-11-21 14:46
 */
public class CisTableName {

    private int id;
    private String tableName;
    private String tableCnName;

    public CisTableName() {
    }

    public CisTableName(int id, String tableName, String tableCnName) {
        this.id = id;
        this.tableName = tableName;
        this.tableCnName = tableCnName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableCnName() {
        return tableCnName;
    }

    public void setTableCnName(String tableCnName) {
        this.tableCnName = tableCnName;
    }
}
