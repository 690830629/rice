package com.rice.util;

public class MyThread {

    public static void main(String[] args) {
        try {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是谁");
                }
            };
            Thread t1 = new Thread(task);
            System.out.println("线程名称:" + Thread.currentThread().getName());
            t1.start();
//            Thread.sleep(5000);
            System.out.println(t1.getName());
        } catch (Exception e) {
            ;
        }

    }

}
