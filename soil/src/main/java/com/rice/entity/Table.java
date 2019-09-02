package com.rice.entity;

import com.google.common.collect.HashBasedTable;

public class Table {
    public HashBasedTable a() {
        HashBasedTable<String, String, Object> table = HashBasedTable.create();
        table.put("黎明", "javase", 80);
        table.put("黎明", "oracle", 100);
        table.put("郭富城", "javase", 90);
        table.put("刘德华", "oracle", 95);
        return table;

    }
}
