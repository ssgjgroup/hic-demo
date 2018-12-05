package com.winning.hic.model.xml;

import org.dom4j.Element;

/**
 * @author LENOVO
 * @title <node></node> 文件结构节点
 * @project hic
 * @package com.winning.hic.model.xml
 * @date: 2018-11-30 14:53
 */
public class DynamicMoleNode {

    private String id;
    private String nodetype;
    private String nodelogiccontent;
    private String name;
    private String text;
    private String description;
    private String display;
    private String permitobjs;
    private String defaultobjs;
    private String allowUserDefine;
    private String canNotInputText;
    private String isnewPage;
    private String canNull;
    private String canNullSubmit;
    private String permittedDoctorGradeRange;
    private String useDiagContinuedPrint;
    private String nodePrintArea;
    private String indentLength;

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

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getPermitobjs() {
        return permitobjs;
    }

    public void setPermitobjs(String permitobjs) {
        this.permitobjs = permitobjs;
    }

    public String getDefaultobjs() {
        return defaultobjs;
    }

    public void setDefaultobjs(String defaultobjs) {
        this.defaultobjs = defaultobjs;
    }

    public String getAllowUserDefine() {
        return allowUserDefine;
    }

    public void setAllowUserDefine(String allowUserDefine) {
        this.allowUserDefine = allowUserDefine;
    }

    public String getCanNotInputText() {
        return canNotInputText;
    }

    public void setCanNotInputText(String canNotInputText) {
        this.canNotInputText = canNotInputText;
    }

    public String getIsnewPage() {
        return isnewPage;
    }

    public void setIsnewPage(String isnewPage) {
        this.isnewPage = isnewPage;
    }

    public String getCanNull() {
        return canNull;
    }

    public void setCanNull(String canNull) {
        this.canNull = canNull;
    }

    public String getCanNullSubmit() {
        return canNullSubmit;
    }

    public void setCanNullSubmit(String canNullSubmit) {
        this.canNullSubmit = canNullSubmit;
    }

    public String getPermittedDoctorGradeRange() {
        return permittedDoctorGradeRange;
    }

    public void setPermittedDoctorGradeRange(String permittedDoctorGradeRange) {
        this.permittedDoctorGradeRange = permittedDoctorGradeRange;
    }

    public String getUseDiagContinuedPrint() {
        return useDiagContinuedPrint;
    }

    public void setUseDiagContinuedPrint(String useDiagContinuedPrint) {
        this.useDiagContinuedPrint = useDiagContinuedPrint;
    }

    public String getNodePrintArea() {
        return nodePrintArea;
    }

    public void setNodePrintArea(String nodePrintArea) {
        this.nodePrintArea = nodePrintArea;
    }

    public String getIndentLength() {
        return indentLength;
    }

    public void setIndentLength(String indentLength) {
        this.indentLength = indentLength;
    }

    @Override
    public String toString() {
        return "DynamicMoleNode{" +
                "id='" + id + '\'' +
                ", nodetype='" + nodetype + '\'' +
                ", nodelogiccontent='" + nodelogiccontent + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", display='" + display + '\'' +
                ", permitobjs='" + permitobjs + '\'' +
                ", defaultobjs='" + defaultobjs + '\'' +
                ", allowUserDefine='" + allowUserDefine + '\'' +
                ", canNotInputText='" + canNotInputText + '\'' +
                ", isnewPage='" + isnewPage + '\'' +
                ", canNull='" + canNull + '\'' +
                ", canNullSubmit='" + canNullSubmit + '\'' +
                ", permittedDoctorGradeRange='" + permittedDoctorGradeRange + '\'' +
                ", useDiagContinuedPrint='" + useDiagContinuedPrint + '\'' +
                ", nodePrintArea='" + nodePrintArea + '\'' +
                ", indentLength='" + indentLength + '\'' +
                '}';
    }
}
