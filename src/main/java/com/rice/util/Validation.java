package com.rice.util;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.*;

public class Validation {
    public static boolean isEmpty(Object object) {
        if (object instanceof String) {
            String str = (String) object;
            if (str == null || str.isEmpty()) {
                return true;
            }
            return false;
        }
        if (object == null) {
            return true;
        }
        return false;
    }
    public static boolean isInteger(String str){
        boolean flag = str.matches("^[-]?[0-9]+[.]?[0-9]*");
//                boolean flag = str.matches(" ^[-]?[0-9]+([.]?[0-9]+){0,1}$");


        return flag;
    }

    public static void main(String[] args) {
        HashMap j=new HashMap();
        Collections.emptyList();
        Lists.newArrayList();
        new ArrayList();
    }

}
