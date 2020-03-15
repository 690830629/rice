package com.rice.util;

public class StringUtil {
    public  void getString(){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.insert(2,"5");
//        StringBuilder stringBuilder=new StringBuilder();
//        stringBuilder.append("a");
        String s=new String("年你好");
        System.out.println(s);
    }

    public static void main(String[] args) {
        int ff = Runtime.getRuntime().availableProcessors();
        System.out.println(ff);
    }
}
