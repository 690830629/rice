package com.rice.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Generic {
    private static void unSafeAdd(List list,Object object){
        list.add(object);
    }
    private static void safeAdd(List<Object> list,Object object){
        list.add(object);
    }
    private static int unSafeNumElementsInCommon(Set s1,Set s2){
        int result=0;
        for(Object o1:s1){
            if(s2.contains(o1)){
                result++;
            }
        }
        return result;
    }
    private static int SafeNumElementsInCommon(Set<?> s1,Set<?> s2){
        int result=0;
        for(Object o1:s1){
            if(s2.contains(o1)){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
