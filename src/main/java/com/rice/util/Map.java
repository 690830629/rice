package com.rice.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Map {

    public static void put(){
        HashMap<String,Integer> map=new HashMap();
        map.put("1",1);
        map.get("1");
        ReentrantLock lock=new ReentrantLock(true);
        lock.tryLock();
        lock.lock();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1","2");
        concurrentHashMap.get("1");
        concurrentHashMap.size();
        concurrentHashMap.entrySet();
        System.out.println("你好");
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        TreeMap<String,String> treeMap=new TreeMap<>();
        treeMap.put("java","java");

    }

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer>  linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(1,1);
        linkedHashMap.put(4,4);
        linkedHashMap.put(2,2);
        linkedHashMap.put(3,3);
        Set<java.util.Map.Entry<Integer, Integer>> fff=linkedHashMap.entrySet();
        for(java.util.Map.Entry<Integer, Integer> entry: fff){
            System.out.println("linkedHashMap"+entry.getKey() +" " +""+ entry.getValue());
        }
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(4,4);
        hashMap.put(2,2);
        hashMap.put(3,3);
        hashMap.get(null);
        Set<java.util.Map.Entry<Integer, Integer>> aaa=hashMap.entrySet();
        for(java.util.Map.Entry<Integer, Integer> entry: aaa){
            System.out.println("hashMap"+entry.getKey() +" " +""+ entry.getValue());
        }
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        treeMap.put(1,1);
        treeMap.put(4,4);
        treeMap.put(2,2);
        treeMap.put(3,3);
        Set<java.util.Map.Entry<Integer, Integer>> entrySetTree=treeMap.entrySet();
        for(java.util.Map.Entry<Integer, Integer> entry: entrySetTree){
            System.out.println("treeHashMap"+entry.getKey() +" " +""+ entry.getValue());
        }


    }

}
