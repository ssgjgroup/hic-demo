package com.winning.hic.model.xml;

/**
 * @author LENOVO
 * @title
 * @project hic
 * @package com.winning.hic.model.xml
 * @date: 2018-11-30 14:53
 */
public class XMLNodeInfo {

    private String id;
    private String name;
    private String description;
    private String text;
    private String nodetype;
    private String canprint;
    private String printInOddPages;
    private String display;
    private String Version;
    private String titledisplay;
    private String hospitalcoderange;
    private String catalogcode;
    private String illnesstypecode;
    private String scalemodelxml;
    private String modellogiccontent;
    private String indentEnabled;
    private String indentLength;
    private String isReview;
    private String isform;
    private String formclass;
    private String maxrefid;
    private String RelateInstanceId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNodetype() {
        return nodetype;
    }

    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

    public String getCanprint() {
        return canprint;
    }

    public void setCanprint(String canprint) {
        this.canprint = canprint;
    }

    public String getPrintInOddPages() {
        return printInOddPages;
    }

    public void setPrintInOddPages(String printInOddPages) {
        this.printInOddPages = printInOddPages;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getTitledisplay() {
        return titledisplay;
    }

    public void setTitledisplay(String titledisplay) {
        this.titledisplay = titledisplay;
    }

    public String getHospitalcoderange() {
        return hospitalcoderange;
    }

    public void setHospitalcoderange(String hospitalcoderange) {
        this.hospitalcoderange = hospitalcoderange;
    }

    public String getCatalogcode() {
        return catalogcode;
    }

    public void setCatalogcode(String catalogcode) {
        this.catalogcode = catalogcode;
    }

    public String getIllnesstypecode() {
        return illnesstypecode;
    }

    public void setIllnesstypecode(String illnesstypecode) {
        this.illnesstypecode = illnesstypecode;
    }

    public String getScalemodelxml() {
        return scalemodelxml;
    }

    public void setScalemodelxml(String scalemodelxml) {
        this.scalemodelxml = scalemodelxml;
    }

    public String getModellogiccontent() {
        return modellogiccontent;
    }

    public void setModellogiccontent(String modellogiccontent) {
        this.modellogiccontent = modellogiccontent;
    }

    public String getIndentEnabled() {
        return indentEnabled;
    }

    public void setIndentEnabled(String indentEnabled) {
        this.indentEnabled = indentEnabled;
    }

    public String getIndentLength() {
        return indentLength;
    }

    public void setIndentLength(String indentLength) {
        this.indentLength = indentLength;
    }

    public String getIsReview() {
        return isReview;
    }

    public void setIsReview(String isReview) {
        this.isReview = isReview;
    }

    public String getIsform() {
        return isform;
    }

    public void setIsform(String isform) {
        this.isform = isform;
    }

    public String getFormclass() {
        return formclass;
    }

    public void setFormclass(String formclass) {
        this.formclass = formclass;
    }

    public String getMaxrefid() {
        return maxrefid;
    }

    public void setMaxrefid(String maxrefid) {
        this.maxrefid = maxrefid;
    }

    public String getRelateInstanceId() {
        return RelateInstanceId;
    }

    public void setRelateInstanceId(String relateInstanceId) {
        RelateInstanceId = relateInstanceId;
    }

    @Override
    public String toString() {
        return "XMLNodeInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                ", nodetype='" + nodetype + '\'' +
                ", canprint='" + canprint + '\'' +
                ", printInOddPages='" + printInOddPages + '\'' +
                ", display='" + display + '\'' +
                ", Version='" + Version + '\'' +
                ", titledisplay='" + titledisplay + '\'' +
                ", hospitalcoderange='" + hospitalcoderange + '\'' +
                ", catalogcode='" + catalogcode + '\'' +
                ", illnesstypecode='" + illnesstypecode + '\'' +
                ", scalemodelxml='" + scalemodelxml + '\'' +
                ", modellogiccontent='" + modellogiccontent + '\'' +
                ", indentEnabled='" + indentEnabled + '\'' +
                ", indentLength='" + indentLength + '\'' +
                ", isReview='" + isReview + '\'' +
                ", isform='" + isform + '\'' +
                ", formclass='" + formclass + '\'' +
                ", maxrefid='" + maxrefid + '\'' +
                ", RelateInstanceId='" + RelateInstanceId + '\'' +
                '}';
    }
}
