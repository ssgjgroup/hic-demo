package com.winning.hic.model.xml;

/**
 * @author LENOVO
 * @title Ref 标签对象
 * @project hic
 * @package com.winning.hic.model.xml
 * @date: 2018-11-30 14:53
 */
public class RefNodeInfo {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RefNodeInfo{" +
                "id='" + id + '\'' +
                '}';
    }
}
