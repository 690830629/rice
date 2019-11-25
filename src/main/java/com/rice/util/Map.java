package com.rice.util;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Map {

    public static void put(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1","2");
        System.out.println("你好");
        HashMap<String,String> map=new HashMap(3);
        map.put("1","2");
    }

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(10);
        concurrentHashMap.put("1","2");
//        HashMap<String,String> map=new HashMap(3);
//        map.put("1","2");
    }

}
