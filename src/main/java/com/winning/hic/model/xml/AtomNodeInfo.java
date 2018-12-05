package com.winning.hic.model.xml;

import org.dom4j.Element;

/**
 * @author LENOVO
 * @title 原子节点对象
 * @project hic
 * @package com.winning.hic.model.xml
 * @date: 2018-11-30 14:53
 */
public class AtomNodeInfo {

    private String id;
    private String nodetype;
    private String nodelogiccontent;
    private String name;
    private String readonly;
    private String text;
    private String description;
    private String atomtype;
    private String value;
    private String defaultvalue;
    private String display;
    private String embededId;
    private String autoeditnext;
    private String spaceholder;
    private String forbidDel;
    private String isComplexShowlist;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodetype() {
        return nodetype;
    }

    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

    public String getNodelogiccontent() {
        return nodelogiccontent;
    }

    public void setNodelogiccontent(String nodelogiccontent) {
        this.nodelogiccontent = nodelogiccontent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
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

    public String getAtomtype() {
        return atomtype;
    }

    public void setAtomtype(String atomtype) {
        this.atomtype = atomtype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getEmbededId() {
        return embededId;
    }

    public void setEmbededId(String embededId) {
        this.embededId = embededId;
    }

    public String getAutoeditnext() {
        return autoeditnext;
    }

    public void setAutoeditnext(String autoeditnext) {
        this.autoeditnext = autoeditnext;
    }

    public String getSpaceholder() {
        return spaceholder;
    }

    public void setSpaceholder(String spaceholder) {
        this.spaceholder = spaceholder;
    }

    public String getForbidDel() {
        return forbidDel;
    }

    public void setForbidDel(String forbidDel) {
        this.forbidDel = forbidDel;
    }

    public String getIsComplexShowlist() {
        return isComplexShowlist;
    }

    public void setIsComplexShowlist(String isComplexShowlist) {
        this.isComplexShowlist = isComplexShowlist;
    }

    @Override
    public String toString() {
        return "AtomNodeInfo{" +
                "id='" + id + '\'' +
                ", nodetype='" + nodetype + '\'' +
                ", nodelogiccontent='" + nodelogiccontent + '\'' +
                ", name='" + name + '\'' +
                ", readonly='" + readonly + '\'' +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", atomtype='" + atomtype + '\'' +
                ", value='" + value + '\'' +
                ", defaultvalue='" + defaultvalue + '\'' +
                ", display='" + display + '\'' +
                ", embededId='" + embededId + '\'' +
                ", autoeditnext='" + autoeditnext + '\'' +
                ", spaceholder='" + spaceholder + '\'' +
                ", forbidDel='" + forbidDel + '\'' +
                ", isComplexShowlist='" + isComplexShowlist + '\'' +
                '}';
    }
}
