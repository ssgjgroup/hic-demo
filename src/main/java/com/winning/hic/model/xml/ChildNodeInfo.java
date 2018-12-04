package com.winning.hic.model.xml;

/**
 * @author chensj
 * @title 病历文件结构子节点NODE
 * @email chensj@winning.com.cn
 * @package com.winning.hic.model.xml
 * @date: 2018-12-04 17:12
 */
public class ChildNodeInfo {

    private String refid;
    private String nodetype;
    private String text;
    private String rtf;

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public String getNodetype() {
        return nodetype;
    }

    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRtf() {
        return rtf;
    }

    public void setRtf(String rtf) {
        this.rtf = rtf;
    }

    @Override
    public String toString() {
        return "ChildNodeInfo{" +
                "refid='" + refid + '\'' +
                ", nodetype='" + nodetype + '\'' +
                ", text='" + text + '\'' +
                ", rtf='" + rtf + '\'' +
                '}';
    }
}
