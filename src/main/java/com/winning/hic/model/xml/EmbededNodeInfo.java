package com.winning.hic.model.xml;

import org.dom4j.Element;

/**
 * @author LENOVO
 * @title 基础模板信息
 * @project hic
 * @package com.winning.hic.model.xml
 * @date: 2018-11-30 14:53
 */
public class EmbededNodeInfo {

    private String id;
    private String nodetype;
    private String name;
    private String text;
    private String description;
    private String identity ;
    private String isfixed;
    private String spaceholder;
    private String atomvisibleenabled;
    private String atomvisible;
    private String diagnosistype;
    private String illnesstypecode;
    private String hospitalcoderange;
    private String diagnosisInsertstype;
    private String FirstCharOfDiagnosisInsertVertical;
    private String nodelogiccontent;
    private String display;

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIsfixed() {
        return isfixed;
    }

    public void setIsfixed(String isfixed) {
        this.isfixed = isfixed;
    }

    public String getSpaceholder() {
        return spaceholder;
    }

    public void setSpaceholder(String spaceholder) {
        this.spaceholder = spaceholder;
    }

    public String getAtomvisibleenabled() {
        return atomvisibleenabled;
    }

    public void setAtomvisibleenabled(String atomvisibleenabled) {
        this.atomvisibleenabled = atomvisibleenabled;
    }

    public String getAtomvisible() {
        return atomvisible;
    }

    public void setAtomvisible(String atomvisible) {
        this.atomvisible = atomvisible;
    }

    public String getDiagnosistype() {
        return diagnosistype;
    }

    public void setDiagnosistype(String diagnosistype) {
        this.diagnosistype = diagnosistype;
    }

    public String getIllnesstypecode() {
        return illnesstypecode;
    }

    public void setIllnesstypecode(String illnesstypecode) {
        this.illnesstypecode = illnesstypecode;
    }

    public String getHospitalcoderange() {
        return hospitalcoderange;
    }

    public void setHospitalcoderange(String hospitalcoderange) {
        this.hospitalcoderange = hospitalcoderange;
    }

    public String getDiagnosisInsertstype() {
        return diagnosisInsertstype;
    }

    public void setDiagnosisInsertstype(String diagnosisInsertstype) {
        this.diagnosisInsertstype = diagnosisInsertstype;
    }

    public String getFirstCharOfDiagnosisInsertVertical() {
        return FirstCharOfDiagnosisInsertVertical;
    }

    public void setFirstCharOfDiagnosisInsertVertical(String firstCharOfDiagnosisInsertVertical) {
        FirstCharOfDiagnosisInsertVertical = firstCharOfDiagnosisInsertVertical;
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
        return "EmbededNodeInfo{" +
                "id='" + id + '\'' +
                ", nodetype='" + nodetype + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", identity='" + identity + '\'' +
                ", isfixed='" + isfixed + '\'' +
                ", spaceholder='" + spaceholder + '\'' +
                ", atomvisibleenabled='" + atomvisibleenabled + '\'' +
                ", atomvisible='" + atomvisible + '\'' +
                ", diagnosistype='" + diagnosistype + '\'' +
                ", illnesstypecode='" + illnesstypecode + '\'' +
                ", hospitalcoderange='" + hospitalcoderange + '\'' +
                ", diagnosisInsertstype='" + diagnosisInsertstype + '\'' +
                ", FirstCharOfDiagnosisInsertVertical='" + FirstCharOfDiagnosisInsertVertical + '\'' +
                ", nodelogiccontent='" + nodelogiccontent + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
