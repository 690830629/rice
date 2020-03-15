package com.rice.jdk;

public class MyThread {

    public  static void testThread(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    i++;
                }
            }
        });
    }

    public static void main(String[] args) {
        testThread();
        Thread.currentThread().isInterrupted();

    }
}
