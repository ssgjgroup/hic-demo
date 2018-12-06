package com.winning.hic.base.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.winning.hic.base.Constants;
import com.winning.hic.model.MbzDataSet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: LENOVO
 * Date: 2018-08-08
 * Time: 13:04
 */
public class HicHelper {

    private static final Logger logger = LoggerFactory.getLogger(HicHelper.class);

    /**
     * 解析xml信息获取对象字段信息
     *
     * @param mbzDataSets  接口表中定义字段名称信息
     * @param document     xml解析dom
     * @param obj          初始化对象
     * @param paramTypeMap 对象定义变量信息 map集合
     * @return
     * @throws ParseException
     */
    public static Object initModelValue(List<MbzDataSet> mbzDataSets, Document document,
                                        Object obj, Map<String, String> paramTypeMap) {

        String bltd = "";
        String shzdbm = "";
        String shzdmc = "";
        for (MbzDataSet dataSet : mbzDataSets) {
            //获取属性名
            String pyCode = dataSet.getPyCode();
            String methodName = "set" + StringUtil.titleCase(pyCode);
            String strValue = null;

            //判断是否可以取值到，不能则提供默认值
            try {
                strValue = DomUtils.getAttrValueByDataSet(document, dataSet).trim();
                //logger.info("pyCode:{};methodName:{};strValue:{};", pyCode, methodName, strValue);
            } catch (NullPointerException e) {
                //logger.info("pyCode:{};methodName:{};strValue:{};using default value", pyCode, methodName, strValue);
            }
            Object value = null;
            if (strValue == null) {
                String paramType = paramTypeMap.get(pyCode.trim());
                if (paramType.contains("String")) {
                    value = "NA";
                } else if (paramType.contains("Short")) {
                    value = new Short("0");
                } else if (paramType.contains("Timestamp")) {
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    String dateStr = "1990-01-01 00:00:00";
                    java.sql.Timestamp sqlDate = null;
                    try {
                        sqlDate = new java.sql.Timestamp(sdf.parse(dateStr).getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    value = sqlDate;
                } else if (paramType.contains("Date")) {
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    String dateStr = "1990-01-01 00:00:00";
                    java.sql.Date sqlDate = null;
                    try {
                        sqlDate = new java.sql.Date(sdf.parse(dateStr).getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    value = sqlDate;
                } else if (paramType.contains("BigDecimal")) {
                    value = new BigDecimal(0);
                } else if (paramType.contains("Integer")) {
                    value = new Integer(0);
                }
            } else {
                String paramType = paramTypeMap.get(pyCode);
                if (paramType.contains("String")) {
                    value = StringUtil.isEmptyOrNull(strValue) ? "NA" : strValue.trim();
                    if (((String) value).contains("yyyy年MM月dd日+Day行")) {
                        value = ((String) value).replace("yyyy年MM月dd日+Day行", "");
                    }
                    value = StringUtil.isEmptyOrNull(((String) value).trim()) ? "NA" : ((String) value).trim();
                } else if (paramType.contains("Short")) {
                    //格式：50`50`50
                    String shortStr = StringUtil.isEmptyOrNull(strValue.trim()) ? null : strValue.trim();
                    if (StringUtil.isEmptyOrNull(shortStr)) {
                        value = (short) 0;
                    } else {
                        Pattern pattern = Pattern.compile("[^0-9]");
                        Matcher m = pattern.matcher(shortStr);
                        shortStr = m.replaceAll("").trim();
                        logger.info("shortStr:" + shortStr);
                        if (!StringUtil.isEmptyOrNull(shortStr)) {
                            BigDecimal dec = new BigDecimal(shortStr);
                            value = dec.setScale(0, BigDecimal.ROUND_HALF_UP).shortValue();
                        } else {
                            value = (short) 0;
                        }

                    }
                } else if (paramType.contains("Timestamp")) {
                    String dateStr = StringUtil.isEmptyOrNull(strValue.trim()) ? "1990-01-01 00:00:00" : strValue.trim();
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    if (StringUtil.hasChinese(dateStr)) {
                        if (dateStr.contains("年")) {
                            dateStr = dateStr.replace("年", "-");
                        }
                        if (dateStr.contains("月")) {
                            dateStr = dateStr.replace("月", "-");
                        }
                        if (dateStr.contains("日")) {
                            dateStr = dateStr.replace("日", " ");
                        }
                        if (dateStr.contains("时")) {
                            dateStr = dateStr.replace("时", ":");
                        }
                        if (dateStr.contains("分")) {
                            dateStr = dateStr.replace("分", ":00");
                        }
                    }
                    //處理特殊數據
//                    dateStr = dateStr.replaceAll(" ","");
//                    if(dateStr.contains(".")){
//                        dateStr = dateStr.replace(".", "-");
//                    }
                    dateStr = dateStr.trim();
                    if (dateStr.length() <= 10) {
                        pattern = "yyyy-MM-dd";
                    } else if (dateStr.contains("yyyy-MM-dd") && !dateStr.contains("yyyy-MM-dd HH:mm:00")) {
                        dateStr = dateStr.substring(0, 10);
                        pattern = "yyyy-MM-dd";
                    } else if (dateStr.contains("yyyy-MM-dd HH:mm:00")) {
                        int index = dateStr.indexOf("yyyy-MM-dd");
                        int index2 = dateStr.indexOf("yyyy-MM-dd HH:mm:00");
                        if (index2 == index) {
                            dateStr = dateStr.substring(0, 19);
                            pattern = "yyyy-MM-dd HH:mm:ss";
                        } else {
                            dateStr = dateStr.substring(0, 10);
                            pattern = "yyyy-MM-dd";
                        }
                    } else {
                        logger.info("dateStr:" + dateStr);
                        dateStr = dateStr.concat(":00");
                        if (dateStr.length() < 18) {
                            dateStr = dateStr.substring(0, 10).trim();
                            pattern = "yyyy-MM-dd";
                        } else {
                            dateStr = dateStr.substring(0, 18);
                        }
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    try {
                        Date date = StringUtil.isEmptyOrNull(dateStr) ? null : sdf.parse(dateStr);
                        if (date != null) {
                            java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
                            value = sqlDate;
                        }
                    } catch (ParseException e) {
                        //e.printStackTrace();
                        logger.error("时间转换失败:{},错误原因:{}", dateStr, e.getMessage());
                        try {
                            value = new java.sql.Timestamp(sdf.parse("1990-01-01 00:00:00").getTime());
                        } catch (ParseException e1) {
                            //e1.printStackTrace();
                        }
                    }
                } else if (paramType.contains("Date")) {
                    //格式：636467930400000000`2017-11-20,16:44
                    String dateStr = StringUtil.isEmptyOrNull(strValue.trim()) ? "1990-01-01 00:00:00" : strValue.trim();
                    String pattern = "yyyy-MM-dd HH:mm:ss";
                    if (StringUtil.hasChinese(dateStr)) {
                        if (dateStr.contains("年")) {
                            dateStr = dateStr.replace("年", "-");
                        }
                        if (dateStr.contains("月")) {
                            dateStr = dateStr.replace("月", "-");
                        }
                        if (dateStr.contains("日")) {
                            dateStr = dateStr.replace("日", "");
                        }
                    }
                    if (dateStr.length() <= 10) {
                        pattern = "yyyy-MM-dd";
                    } else if (dateStr.contains("yyyy-MM-dd HH:mm:00")) {
                        dateStr = dateStr.substring(0, 19);
                        pattern = "yyyy-MM-dd HH:mm:ss";
                    } else if (dateStr.contains("yyyy-MM-dd")) {
                        dateStr = dateStr.substring(0, 10);
                        pattern = "yyyy-MM-dd";
                    } else if (!dateStr.contains(":")) {
                        pattern = "yyyy-MM-dd";
                        dateStr = dateStr.replace(" ", "").replace(" ", "");
                    } else {
                        dateStr = dateStr.concat(":00").substring(0, 18);
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    try {
                        Date date = StringUtil.isEmptyOrNull(dateStr.trim()) ? null : sdf.parse(dateStr.trim());
                        if (date != null) {
                            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                            value = sqlDate;
                        }
                    } catch (ParseException e) {
                        // e.printStackTrace();
                        logger.error("时间转换失败:{},错误原因:{}", dateStr, e.getMessage());
                        try {
                            java.sql.Date sqlDate = new java.sql.Date(sdf.parse("1990-01-01 00:00:00").getTime());
                            value = sqlDate;
                        } catch (ParseException e1) {
                            //e1.printStackTrace();
                        }
                    }
                } else if (paramType.contains("BigDecimal")) {

                    String dateStr = StringUtil.isEmptyOrNull(strValue) ? "0" : strValue.trim();
                    try {
                        value = StringUtil.isEmptyOrNull(dateStr) ? new BigDecimal(0) : new BigDecimal(dateStr);
                    } catch (NumberFormatException e) {
                        logger.error("数据转换异常:{},错误原因:{}", dateStr, e.getMessage());
                        value = new BigDecimal(0);
                    }

                } else if (paramType.contains("Integer")) {
                    String dateStr = StringUtil.isEmptyOrNull(strValue.trim()) ? "0" : strValue.trim();
                    try {
                        value = StringUtil.isEmptyOrNull(dateStr) ? new Integer(0) : Integer.parseInt(dateStr);
                    } catch (NumberFormatException e) {
                        value = 0;
                    }

                }
            }
            //类型
            try {
                if (value != null) {
                     /*String info = "长度正常，可以入库";
                   if(value instanceof String){
                        String str = value.toString();
                        Long datalength = (long)str.length();
                        boolean hasChs = StringUtil.hasChinese(str);
                        if(hasChs){
                            datalength = datalength * 2;
                        }
                        if(dataSet.getDataLength() != 0 && datalength > dataSet.getDataLength()){
                            info = "发生截断，需要调整数据长度";
                        }
                        logger.info("pyCode:{};methodName:{};strValue:{};info:{}", pyCode, methodName, value,info);
                    }
                    logger.info("pyCode:{};methodName:{};strValue:{};info:{}", pyCode, methodName, value,info);*/
                    //logger.info("pyCode:{};methodName:{};strValue:{}", pyCode, methodName, value);
                    if (dataSet.getSourceType().equals("6") && pyCode.equals("bltd")) {
                        if (!"NA".equals(value)) {
                            bltd = bltd + " " + value;
                            ReflectUtil.setParamKind(obj, methodName, bltd);
                            continue;
                        }
                    }
                    if (dataSet.getSourceType().equals(Constants.WN_ZYBCJL_CYJL_SOURCE_TYPE)) {
                        if (pyCode.equals("cyqk")) {
                            String method = "getCyqk";
                            String exValue = (String) ReflectUtil.getParam(obj, method);
                            if (exValue != null && !"NA".equals(value)) {
                                if (!"NA".equals(exValue)) {
                                    value = exValue + " " + value;
                                }
                                ReflectUtil.setParamKind(obj, methodName, value);
                                continue;
                            }
                        }
                    }
                    if (dataSet.getSourceType().equals(Constants.WN_RYJL_JBXX_SOURCE_TYPE)) {
                        //过敏史
                        if (pyCode.equals("gms")) {
                            String method = "getGms";
                            String exValue = (String) ReflectUtil.getParam(obj, method);
                            if (exValue != null && !"NA".equals(value)) {
                                if (!"NA".equals(exValue)) {
                                    value = exValue + " " + value;
                                }
                                ReflectUtil.setParamKind(obj, methodName, value);
                                continue;
                            }
                        }
                        //一般状况检查结果
                        if (pyCode.equals("tjybjg")) {
                            String method = "getTjybjg";
                            String exValue = (String) ReflectUtil.getParam(obj, method);
                            if (exValue != null && !"NA".equals(value)) {
                                if (!"NA".equals(exValue)) {
                                    value = exValue + " " + value;
                                }
                                ReflectUtil.setParamKind(obj, methodName, value);
                                continue;
                            }
                        }
                        //头部及其器官检查结果
                        if (pyCode.equals("tjtbqgjg")) {
                            String method = "getTjtbqgjg";
                            String exValue = (String) ReflectUtil.getParam(obj, method);
                            if (exValue != null && !"NA".equals(value)) {
                                if (!"NA".equals(exValue)) {
                                    value = exValue + " " + value;
                                }
                                ReflectUtil.setParamKind(obj, methodName, value);
                                continue;
                            }
                        }
                        //腹部检查结果
                        if (pyCode.equals("tjfbjg")) {
                            String method = "getTjfbjg";
                            String exValue = (String) ReflectUtil.getParam(obj, method);
                            if (exValue != null && !"NA".equals(value)) {
                                if (!"NA".equals(exValue)) {
                                    value = exValue + " " + value;
                                }
                                ReflectUtil.setParamKind(obj, methodName, value);
                                continue;
                            }
                        }
                    }
                    ReflectUtil.setParam(obj, methodName, value);


                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //logger.info("Model:{}", obj);
        }
        return obj;
    }

    /**
     * 数据封装 将map中参数封装到obj中
     *
     * @param object  待数据封装obj
     * @param dataMap 数据参数map
     * @return
     */
    public static Class<?> initBean(Object object, Map<String, Object> dataMap) {

        Class<?> T = null;
        try {
            T = object.getClass();
            Method[] method = T.getMethods();
            for (Method m : method) {
                String methodName = m.getName();
                if (methodName.startsWith("set")) {
                    String fieldName = methodName.substring(3);
                    String index = fieldName.substring(0, 1).toLowerCase();
                    String next = fieldName.substring(1);
                    fieldName = index + next;
                    Class<?>[] types = m.getParameterTypes();
                    String type = types[0].getName();
                    if (dataMap.get(fieldName) != null
                            && !dataMap.get(fieldName).equals("")) {
                        Object[] param = new Object[1];
                        String value = String.valueOf(dataMap.get(fieldName));
                        if (type.equals(String.class.getName())) {
                            param[0] = value;
                        } else if (type.equals("int")
                                || type.equals(Integer.class.getName())) {
                            param[0] = new Integer(value);
                        } else if (type.equals("long")
                                || type.equals(Long.class.getName())) {
                            param[0] = new Long(value);
                        } else if (type.equals("boolean")
                                || type.equals(Boolean.class.getName())) {
                            param[0] = Boolean.valueOf(value);
                        } else if (type.equals(Date.class.getName())) {
                            SimpleDateFormat sdf = new SimpleDateFormat(
                                    "yyyy-MM-dd");
                            Date date = sdf.parse(value);
                            param[0] = date;
                        } else if (type.equals("double")
                                || type.equals(Double.class.getName())) {
                            param[0] = new Double(value);
                        } else if (type.equals("short")
                                || type.equals(Short.class.getName())) {
                            param[0] = new Short(value);
                        }

                        m.invoke(object, param);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return T;
    }
}
