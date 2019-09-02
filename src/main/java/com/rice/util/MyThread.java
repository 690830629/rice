package com.rice.util;

public class MyThread {

    public static void main(String[] args) {
        try {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            };
            Thread t1 = new Thread(task);
            Thread t2 = new Thread(task);
            t1.start();
            t2.start();
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            ;
        }

    }

}
