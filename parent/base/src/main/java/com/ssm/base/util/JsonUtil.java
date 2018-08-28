package com.ssm.base.util;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public abstract class JsonUtil {

    private final static String SUCCESS_CODE="200";
    private final static String ERROR_CODE="400";

    public JsonUtil() {
    }

    public static String success(Object object){
        Map map = new HashMap();
        map.put("code",SUCCESS_CODE);
        map.put("data",object);
        return JSONObject.fromObject(map).toString();
    }


    public static String success(){
        Map map = new HashMap();
        map.put("code",SUCCESS_CODE);
        return JSONObject.fromObject(map).toString();
    }


    public static String error(String msg){
        Map map = new HashMap();
        map.put("code",ERROR_CODE);
        return JSONObject.fromObject(map).toString();
    }


}
