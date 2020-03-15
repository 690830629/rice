package com.rice.util;

public class StringStatisticUti {
    public static String getMethodName(String fildeName){
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    public static void main(String[] args)  {
        System.out.println(getMethodName("fdsfsdfnKKKme"));
    }
}
