package com.winning.hic;

import com.winning.hic.base.utils.StringUtil;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author chensj
 * @title
 * @email chensj@winning.com.cn
 * @package com.winning.hic
 * @date: 2018-11-20 15:57
 */
public class FileNameConvert {

    public static void main(String[] args){
//       String path = "E:\\工作文档\\02-互联互通工具\\数据解析\\存储过程";
//        File file = new File(path);
//        String[] nameList = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                if(name.startsWith("dbo.USP_SPLIT")&&name.endsWith(".sql")){
//                    return true;
//                }
//                return false;
//            }
//        });
//        for (String name : nameList) {
//            String humpName = StringUtil.UnderlineToHump(name.split("\\.")[1]);
//            String paramEntityName = humpName.replace("uspSplit","Hlht");
//            String paramName = "obj";
//            String methodName = humpName.replace("uspSplit","selectAnmr") + "SplitByProc";
//            String methodAllName = "public void "+methodName +"(" + paramEntityName +" " +paramName +");";
//            System.out.println(methodAllName);
//        }
//
//
//        for (String name : nameList) {
//            String humpName = StringUtil.UnderlineToHump(name.split("\\.")[1]);
//            String procName = name.split("\\.")[1];
//            String methodName = humpName.replace("uspSplit","selectAnmr") + "SplitByProc";
//            String paramEntityName = "com.winning.hic.model."+humpName.replace("uspSplit","Hlht");
//            String methodAllName = "<select id=\""+methodName+"\" statementType=\"CALLABLE\" >\n  " +
//                    "exec " + procName + " #{map.yljgdm} , #{map.regex}  \n " +
//                    "</select> \n"  ;
//            System.out.println(methodAllName);
//        }


    }

}
