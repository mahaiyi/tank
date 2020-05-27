package com.tank.prop;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件管理
 */
public class PropertMgr {
    private final static PropertMgr INSTANCE=new PropertMgr();
    private final static Properties props=new Properties();
    static {
        try {
            props.load(PropertMgr.class.getClassLoader().getResourceAsStream("conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private PropertMgr(){}
    public static PropertMgr getInstanse(){
        return INSTANCE;
    }

    public static Object  getPro(String key){
        if(null == props){
            return null;
        }
        return props.get(key);
    }
}
