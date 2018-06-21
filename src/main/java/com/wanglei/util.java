package com.wanglei;

import java.text.SimpleDateFormat;
import java.util.Date;

public class util {
    static SimpleDateFormat sdf=  new SimpleDateFormat("yyyy-mm-dd");

    public static void main(String[] args) {
        System.out.println(sdf.format(new Date()));
    }
}
