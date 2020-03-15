package com.rice.util;


import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.Executors;

public class Math {
    public static final MathContext MATH_CONTEXT = new MathContext(2, RoundingMode.HALF_UP);


    public static void a(List<Integer> list) {
        long currentTime = System.currentTimeMillis();
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next() % 2 == 0) {
                iter.remove();
            }
        }
        long consuming = (System.currentTimeMillis() - currentTime);
        System.out.println(consuming+"ms");
    }

    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(100);
        BigDecimal c = new BigDecimal(0.99);
        BigDecimal e = new BigDecimal(100.357);
        System.out.println(b);
        System.out.println(c.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println(e.setScale(2,BigDecimal.ROUND_HALF_UP));
        BigDecimal ffff = new BigDecimal(e.setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
        System.out.println(ffff);
        int totalStock=0;
        int saledStock=20;
        System.out.println((double) saledStock/(double) totalStock);


    }

}
