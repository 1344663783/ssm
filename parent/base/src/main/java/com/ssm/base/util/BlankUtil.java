package com.ssm.base.util;

import javafx.beans.binding.ObjectExpression;

import java.util.List;
import java.util.Map;

public abstract class BlankUtil {

    public BlankUtil() {
    }

    public static boolean isBlank(Object object){
        if(object==null){
            return true;
        }
        if(object instanceof String){
            String str=(String) object;
            if(str==null|| str.trim().length()==0){
                return true;
            }
        }
        if(object instanceof List){
            List lists=(List)object;
            if(lists==null || lists.size()==0){
                return true;
            }
        }
        if (object instanceof Map){
            Map map = (Map)object;
            if(map==null || map.size()==0){
                return true;
            }
        }
        return false;
    }

    public static boolean isNotBlank(Object object){
        return !isBlank(object);
    }
}
