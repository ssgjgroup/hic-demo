package com.winning.hic;

import com.winning.hic.model.xml.ModelNodeInfo;
import org.dom4j.*;

import java.io.*;
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
    /* display value */
    private static final String DISPLAY_ATTR_VALUE_SHOW = "20"; /*显示当前节点的text的value*/
    private static final String DISPLAY_ATTR_VALUE_HIDE = "11"; /*不显示当前节点的*/

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
        //循环获取根节点属性值，封装到map中
        System.out.println("==================================================================");
        System.out.println("Model:");
        for (Attribute attribute : attributes) {
            paramMap.put(attribute.getName(),attribute.getValue());
           // System.out.println(attribute.getName()+":"+attribute.getValue());
            System.out.println(attribute.getName());
        }
        //创建节点对象 model 对象
//        ModelNodeInfo nodeInfo = new ModelNodeInfo();
//        HicHelper.initBean(nodeInfo,paramMap);
//        System.out.println(nodeInfo);

        //node type=dynamicMoleNode 病历文件结构
        List<Element> dynamicMoleNodeList = root.elements("node");
        Element first = dynamicMoleNodeList.get(0);
        List<Attribute> elementAttributes = first.attributes();
        System.out.println("==================================================================");
        System.out.println("Node");
        for (Attribute attribute : elementAttributes) {
            //System.out.println(attribute.getName()+":"+attribute.getValue());
            System.out.println(attribute.getName() );
        }

        List<Element> refList = root.elements("Ref");
        first = refList.get(0);
        elementAttributes = first.attributes();
        System.out.println("==================================================================");
        System.out.println("Ref");
        for (Attribute attribute : elementAttributes) {
            //System.out.println(attribute.getName()+":"+attribute.getValue());
            System.out.println(attribute.getName() );
        }

        List<Element> refChild = first.elements("node");
        elementAttributes = refChild.get(0).attributes();
        System.out.println("==================================================================");
        System.out.println("Emebed");
        for (Attribute attribute : elementAttributes) {
            //System.out.println(attribute.getName()+":"+attribute.getValue());
            System.out.println(attribute.getName() );
        }
        refChild = refChild.get(0).elements("node");
        elementAttributes = refChild.get(0).attributes();
        System.out.println("==================================================================");
        System.out.println("Object");
        for (Attribute attribute : elementAttributes) {
            //System.out.println(attribute.getName()+":"+attribute.getValue());
            System.out.println(attribute.getName() );
        }

        refChild = refChild.get(0).elements("node");
        elementAttributes = refChild.get(0).attributes();
        System.out.println("==================================================================");
        System.out.println("Atom");
        for (Attribute attribute : elementAttributes) {
            //System.out.println(attribute.getName()+":"+attribute.getValue());
            System.out.println(attribute.getName() );
        }
//        List<ModelNodeInfo> childNode = new ArrayList<>();
//
//        //遍历病历文件结构
//        for (Element element : dynamicMoleNodeList) {
//            //病历文件结构 对象属性map值封装
//            Map<String,Object> elementMap = new HashMap<>();
//            List<Attribute> elementAttributes = element.attributes();
//            for (Attribute attribute : elementAttributes) {
//                elementMap.put(attribute.getName(),attribute.getValue());
//            }
//            ModelNodeInfo childNodeInfo = new ModelNodeInfo();
//            HicHelper.initBean(childNodeInfo,elementMap);
//            childNode.add(childNodeInfo);
//        }
//        for (ModelNodeInfo info : childNode) {
//            //System.out.println(info);
//            System.out.println(info.getText()+":"+info.getDisplay());
//            showDisplayName(info);
//        }
        //全部子节点
//        List<Element> dynamicMoleNodeList = root.elements();
//        //全部文件结构子节点
//        List<ModelNodeInfo> childNode = new ArrayList<>();
//        //全部引入Ref节点
//        Map<String,RefNodeInfo> childRefNode = new HashMap<>();
//        for (Element element : dynamicMoleNodeList) {
//            String qName = element.getQName().getName();
//            Map<String,Object> elementMap = new HashMap<>();
//            List<Attribute> elementAttributes = element.attributes();
//            if(REF_TAG.equals(qName)){}else{
//                for (Attribute attribute : elementAttributes) {
//                    elementMap.put(attribute.getName(),attribute.getValue());
//                    System.out.println(attribute.getName()+":"+attribute.getValue());
//                }
//            }
//            for (Attribute attribute : elementAttributes) {
//                elementMap.put(attribute.getName(),attribute.getValue());
//            }
//            if(REF_TAG.equals(qName)){
//                RefNodeInfo ref = new RefNodeInfo();
//                HicHelper.initBean(ref,elementMap);
//                ref.setElement(element);
//                childRefNode.put(ref.getId(),ref);
//            }else{
//                ModelNodeInfo childNodeInfo = new ModelNodeInfo();
//                HicHelper.initBean(childNodeInfo,elementMap);
//                childNodeInfo.setElement(element);
//                childNode.add(childNodeInfo);
//            }
//        }

//        StringBuilder content = new StringBuilder();
//        //循环node子节点
//        for (ModelNodeInfo info : childNode) {
//            if(nodeInfo.getDisplay().startsWith(DISPLAY_ATTR_VALUE_SHOW)
//              ){}
//        }



    }

    private static void showDisplayName(ModelNodeInfo info){
        //System.out.println(info.getDisplay());
       String[] displays =  info.getDisplay().split("`");
        //System.out.println(displays[1]+displays[2]);
    }
}
