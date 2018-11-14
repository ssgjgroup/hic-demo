package com.winning.hic.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.winning.hic.model.Environment;

/**
 * Created with IntelliJ IDEA.
 * Description:加载config.properties文件内容，填充内容到Environment中
 * User: LENOVO
 * Date: 2018-07-24
 * Time: 15:30
 */
public class ConfigUtils {

    private static Properties properties = new Properties();
    private static Environment environment = new Environment();

    public static void readProperties(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        properties.load(is);
        is.close();
        initEnvConfig(properties);
    }

    private static void initEnvConfig(Properties properties) {
    	//数据仓库管理库
        environment.setCmDataCenterdbUrl(properties.getProperty("cmdatacenterdb.url"));
        environment.setCmDataCenterdbName(properties.getProperty("cmdatacenterdb.dbName"));
        environment.setCmDataCenterdbUsername(properties.getProperty("cmdatacenterdb.username"));
        environment.setCmDataCenterdbPassword(properties.getProperty("cmdatacenterdb.password"));
        //数据仓库
        environment.setHdwdbUrl(properties.getProperty("hdwdb.url"));
        environment.setHdwdbName(properties.getProperty("hdwdb.dbName"));
        environment.setHdwdbUsername(properties.getProperty("hdwdb.username"));
        environment.setHdwdbPassword(properties.getProperty("hdwdb.password"));
       
    }

    public static Environment getEnvironment(){
        return  environment;
    }
}
