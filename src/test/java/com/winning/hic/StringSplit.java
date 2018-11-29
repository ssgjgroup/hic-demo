package com.winning.hic;

import com.winning.hic.base.utils.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chensj
 * @title
 * @email chensj@winning.com.cn
 * @package com.winning.hic
 * @date: 2018-11-19 11:07
 */
public class StringSplit {
    public static void main(String[] args){
       String a = "C92.000   I69.300   N18.905   B18.107";
       String[] strArray = a.split(" ");
        System.out.println(Arrays.asList(strArray));
        List<String> strs = new ArrayList<>();
        List<String> stringList = Arrays.asList(strArray);
        for (String s : stringList) {
            if(!StringUtil.isEmptyOrNull(s)){
                strs.add(s.trim());
            }
        }
        for (String str : strs) {
            System.out.println(str);
        }

        String allName = "void com.winning.hic.dao.hdw.SplitTableDao.selectAnmrRyjlRcyjlSplitByProc(HlhtRyjlRcyjl)";
        allName = allName.split(" ")[1];
        System.out.println(allName.substring(0, allName.lastIndexOf(".")));

    }

}
