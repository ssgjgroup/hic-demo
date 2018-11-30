package com.winning.hic;

import com.winning.hic.base.utils.HicHelper;
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
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
       InputStream in = ContentTest.class.getClassLoader().getResourceAsStream("pgc.xml");
        System.out.println(in);
        //DocumentHelper.
        //FileReader reader = new FileReader(new InputStreamReader(in));
        //FileInputStream fileInputStream = new FileInputStream(in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        byte[] bytes = new byte[1024];
        String value = "";
        StringBuilder sb = new StringBuilder();
        while( (value = reader.readLine())!= null){
           // System.out.println(value);
            sb.append(value);
        }

        System.out.println(sb);
        Document document = null;
        try {
            document = DocumentHelper.parseText(sb.toString());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(document);
        Element root = document.getRootElement();
        List<Attribute> attributes = root.attributes();
        List<String> attrs = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        for (Attribute attribute : attributes) {
            attrs.add(attribute.getName());
            paramMap.put(attribute.getName(),attribute.getValue());
        }
        XMLNodeInfo nodeInfo = new XMLNodeInfo();
        HicHelper.initBean(nodeInfo,paramMap);
        System.out.println(nodeInfo);

        //node type=dynamicMoleNode
        List<Element> dynamicMoleNodeList = root.elements("node");
        List<XMLNodeInfo> childNode = new ArrayList<>();

        for (Element element : dynamicMoleNodeList) {
            Map<String,Object> elementMap = new HashMap<>();
            List<Attribute> elementAttributes = element.attributes();
            for (Attribute attribute : elementAttributes) {
                elementMap.put(attribute.getName(),attribute.getValue());
            }
            XMLNodeInfo childNodeInfo = new XMLNodeInfo();
            HicHelper.initBean(childNodeInfo,elementMap);
            childNode.add(childNodeInfo);
        }
        for (XMLNodeInfo info : childNode) {
            //System.out.println(info);
            showDisplayName(info);
        }

    }

    private static void showDisplayName(XMLNodeInfo info){
        //System.out.println(info.getDisplay());
       String[] displays =  info.getDisplay().split("`");
        System.out.println(displays[1]+displays[2]);
    }
}
