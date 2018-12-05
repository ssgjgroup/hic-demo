package com.winning.hic.model.xml;

import org.dom4j.Element;

/**
 * @author LENOVO
 * @title <node></node> 嵌入对象
 * @project hic
 * @package com.winning.hic.model.xml
 * @date: 2018-11-30 14:53
 */
public class ObjectNodeInfo {

    private String id;
    private String name;
    private String text;
    private String description;
    private String nodetype;
    private String embededId;
    private String nodelogiccontent;
    private String display;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNodetype() {
        return nodetype;
    }

    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

    public String getEmbededId() {
        return embededId;
    }

    public void setEmbededId(String embededId) {
        this.embededId = embededId;
    }

    public String getNodelogiccontent() {
        return nodelogiccontent;
    }

    public void setNodelogiccontent(String nodelogiccontent) {
        this.nodelogiccontent = nodelogiccontent;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "ObjectNodeInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", nodetype='" + nodetype + '\'' +
                ", embededId='" + embededId + '\'' +
                ", nodelogiccontent='" + nodelogiccontent + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
