package com.rice.util;


import com.google.common.collect.Lists;
import org.joda.time.DateTime;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

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
    }

}
