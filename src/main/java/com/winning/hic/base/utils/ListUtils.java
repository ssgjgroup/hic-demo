package com.winning.hic.base.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chensj
 * @title
 * @email chensj@winning.com.cn
 * @package com.winning.hic.base.utils
 * @date: 2018-11-19 11:17
 */
public class ListUtils {
    /**
     * 特殊处理数据
     * @param obj 元数据对象
     * @param params 需要处理的数据
     * @param regex 数据分割的符号
     */
    public static void convertValue(Object obj,List<String> params,String regex){
        for (String param : params) {
            String setMethodName = "set" + StringUtil.titleCase(param);
            String getMethodName = "get" + StringUtil.titleCase(param);
            try {
                String value = (String)ReflectUtil.getParam(obj, getMethodName);
                String[] strArray = value.split(" ");
                List<String> strs = new ArrayList<>();
                List<String> stringList = Arrays.asList(strArray);
                String regexValue = "";
                for (String s : stringList) {
                    if(!StringUtil.isEmptyOrNull(s)){
                        regexValue+=s.trim()+regex;
                    }
                }
                regexValue = regexValue.substring(0,regexValue.length()-regex.length());
                ReflectUtil.setParamKind(obj,setMethodName,regexValue);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
