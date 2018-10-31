package com.rice.util;

import com.google.common.collect.Lists;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static sun.jvm.hotspot.code.CompressedStream.L;

public class Array {
    public static void main(String[] args) {
//        BigDecimal sellPrice=new BigDecimal(380.2);
        BigDecimal setNum=new BigDecimal(3);
//        BigDecimal aveSellPrice = new BigDecimal(126.733333);
        BigDecimal aveSellPrice = new BigDecimal(126.666667);

        BigDecimal sellPrice = aveSellPrice.multiply(setNum);
        sellPrice = sellPrice.setScale(1, BigDecimal.ROUND_HALF_UP);
//        System.out.println(sellPrice);
        String a = new BigDecimal("380.2").stripTrailingZeros().toPlainString();
        System.out.println(new BigDecimal(a));


//        aveSellPrice.setScale(6,BigDecimal.ROUND_HALF_UP);
//        System.out.println(sellPrice.divide(setNum,6,BigDecimal.ROUND_HALF_UP).doubleValue());
//        System.out.println(aveSellPrice);



    }
}
