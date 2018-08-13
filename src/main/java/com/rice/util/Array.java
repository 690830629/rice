package com.rice.util;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            list.add(i);
        // list {0, 1, 2, 3, 4}
        for (int i = 0; i < list.size(); i++) {
            // index and number
            if (list.get(i) % 2 == 0) {
                list.remove(list.get(i));
            }
            System.out.println(list);
        }

    }
}
