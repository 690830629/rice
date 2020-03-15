package com.rice.util;

import com.rice.entity.TestReflection;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIGlobalBinding;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class Reflex {
    public static void main(String[] args) {
        Class<TestReflection> fff = TestReflection.class;
        Field[] ffff = fff.getDeclaredFields();
        for(int i=0;i<ffff.length;i++){
            System.out.println(ffff[i]);
        }

        BigDecimal a = new BigDecimal(10000);
        BigDecimal b =BigDecimal.valueOf(10000);
        System.out.println(a);
        System.out.println(b);
    }
}
