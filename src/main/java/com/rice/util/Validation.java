package com.rice.util;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
//        List<String> list=new ArrayList<String> ();
        List<Object> list=new ArrayList<Object>();
        list.add(new Integer(5));
        list.add(new String("4"));
        List to=new ArrayList();
//
    }
}
