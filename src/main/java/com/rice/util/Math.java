package com.rice.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Iterator;

public class Math {
    public static final MathContext MATH_CONTEXT = new MathContext(2, RoundingMode.HALF_UP);

    public static void main(String[] args) {
        Multimap<Integer, Integer> multimap = ArrayListMultimap.create();
        multimap.put(1,1);
        multimap.put(1,2);
        multimap.put(1,3);
        multimap.put(2,4);
        Iterator<Integer> ttt = multimap.keySet().iterator();
        if(ttt.hasNext()){
            System.out.println(multimap.get(ttt.next()));
        }





    }

}
