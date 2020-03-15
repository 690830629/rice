package com.rice.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyList {
    public static void main(String[] args) {
        List<String> arrayList=new ArrayList<>();
        List<String> linkList=new LinkedList<>();
        arrayList.add("1");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("6");
        linkList.add("2");
        linkList.add("1");
        linkList.add("3");
        linkList.add("5");
        System.out.println(arrayList);
        System.out.println(linkList);

    }
}
