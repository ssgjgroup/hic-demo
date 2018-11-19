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

    public static void convertValue(Object obj,List<String> params,String regex){
        for (String param : params) {
            String setMethodName = "set" + StringUtil.titleCase(param);
            String getMethodName = "get" + StringUtil.titleCase(param);
            try {
                String value = (String) ReflectUtil.getParam(obj, getMethodName);
                String[] strArray = value.split(" ");
                List<String> stringList = Arrays.asList(strArray);
                String regexValue = "";
                for (String s : stringList) {
                    if(!StringUtil.isEmptyOrNull(s)){
                        regexValue=s.trim()+regex;
                    }
                }
                ReflectUtil.setParam(obj,setMethodName,regexValue);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
