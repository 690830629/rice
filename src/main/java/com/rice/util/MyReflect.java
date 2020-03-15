package com.rice.util;

import com.rice.entity.Dog;
import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyReflect {


    public <R> R testReflect(Class<R> resultClass) throws Exception {
        R instance = resultClass.newInstance();
        Field[] declaredFields = resultClass.getDeclaredFields();
        for(int i=0;i<declaredFields.length;i++){

            declaredFields[i].setAccessible(true);
            Object obj = declaredFields[i].get(instance);
            String name = declaredFields[i].getName();
            Class<?> type = declaredFields[i].getType();
            Method method = resultClass.getMethod("set"+ StringStatisticUti.getMethodName(name)
, type);
            System.out.println(method);
            System.out.println(type);
            System.out.println(name);
            System.out.println(obj);
            System.out.println(instance);
        }
          return null;
    }
    public static void main(String[] args) throws Exception {
        new MyReflect().testReflect(Dog.class);

    }

}
