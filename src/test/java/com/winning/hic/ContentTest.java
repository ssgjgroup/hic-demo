package com.winning.hic;

import com.winning.hic.base.utils.HicHelper;
import com.winning.hic.model.xml.RefNodeInfo;
import com.winning.hic.model.xml.XMLNodeInfo;
import org.dom4j.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LENOVO
 * @title
 * @project hic
 * @package com.winning.hic
 * @date: 2018-11-30 13:57
 */
public class ContentTest {
    /*===========================节点标签============================================*/
    /* node 节点*/
    private static final String NODE_TAG = "node";
    /* Ref 节点*/
    private static final String REF_TAG = "Ref";
    /*===========================节点类型============================================*/
    /*文件结构节点*/
    private static final String DYNAMIC_NODE_TYPE = "DynamicMoleNode";
    /*基础模板节点*/
    private static final String EMBEDED_NODE_TYPE = "Embeded";
    /*元数据节点*/
    private static final String OBJECT_NODE_TYPE = "Object";
    /*原子数据节点*/
    private static final String ATOMNODE_NODE_TYPE = "AtomNode";
    /*文本节点*/
    private static final String TEXT_NODE_TYPE = "Text";
    /*============================属性值=============================================*/
    /* id 属性*/
    private static final String ID_ATTR_NAME = "id";
    /* display 属性*/
    private static final String DISPLAY_ATTR_NAME = "display";
    /* visiable 属性*/
    private static final String VISIABLE_ATTR_NAME = "visiable";

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
       InputStream in = ContentTest.class.getClassLoader().getResourceAsStream("24ryjl.xml");
       // System.out.println(in);
        //建立Reader读取流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String value = "";
        //读取文件内容
        StringBuilder sb = new StringBuilder();
        while( (value = reader.readLine())!= null){
           // System.out.println(value);
            sb.append(value);
        }
        //转化string 到 document
        Document document = null;
        try {
            document = DocumentHelper.parseText(sb.toString());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //System.out.println(document);
        //获取根节点 <Model></Model>
        Element root = document.getRootElement();
        //获取根节点属性值集合
        List<Attribute> attributes = root.attributes();
        //创建map放置属性与属性值的key-value
        Map<String,Object> paramMap = new HashMap<>();
        //循环获取属性值，封装到map中
        for (Attribute attribute : attributes) {
            paramMap.put(attribute.getName(),attribute.getValue());
        }
        //创建节点对象 model 对象
        XMLNodeInfo nodeInfo = new XMLNodeInfo();
        HicHelper.initBean(nodeInfo,paramMap);
        System.out.println(nodeInfo);

        //node type=dynamicMoleNode 病历文件结构
//        List<Element> dynamicMoleNodeList = root.elements("node");
//        List<XMLNodeInfo> childNode = new ArrayList<>();
//
//        //遍历病历文件结构
//        for (Element element : dynamicMoleNodeList) {
//            //病历文件结构 对象属性map值封装
//            Map<String,Object> elementMap = new HashMap<>();
//            List<Attribute> elementAttributes = element.attributes();
//            for (Attribute attribute : elementAttributes) {
//                elementMap.put(attribute.getName(),attribute.getValue());
//            }
//            XMLNodeInfo childNodeInfo = new XMLNodeInfo();
//            HicHelper.initBean(childNodeInfo,elementMap);
//            childNode.add(childNodeInfo);
//        }
//        for (XMLNodeInfo info : childNode) {
//            //System.out.println(info);
//            System.out.println(info.getText()+":"+info.getDisplay());
//            showDisplayName(info);
//        }
        //全部子节点
        List<Element> dynamicMoleNodeList = root.elements();
        //全部文件结构子节点
        List<XMLNodeInfo> childNode = new ArrayList<>();
        //全部引入Ref节点
        Map<String,RefNodeInfo> childRefNode = new HashMap<>();
        for (Element element : dynamicMoleNodeList) {
            String qName = element.getQName().getName();
            Map<String,Object> elementMap = new HashMap<>();
            List<Attribute> elementAttributes = element.attributes();
            for (Attribute attribute : elementAttributes) {
                elementMap.put(attribute.getName(),attribute.getValue());
            }
            if(REF_TAG.equals(qName)){
                RefNodeInfo ref = new RefNodeInfo();
                HicHelper.initBean(ref,elementMap);
                childRefNode.put(ref.getId(),ref);
            }else{
                XMLNodeInfo childNodeInfo = new XMLNodeInfo();
                HicHelper.initBean(childNodeInfo,elementMap);
                childNode.add(childNodeInfo);
            }
        }
    }

    private static void showDisplayName(XMLNodeInfo info){
        //System.out.println(info.getDisplay());
       String[] displays =  info.getDisplay().split("`");
        //System.out.println(displays[1]+displays[2]);
    }
}
