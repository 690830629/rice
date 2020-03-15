package com.rice.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            int j=i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    throw  new RuntimeException("f我出错了"+j);
                }
            });
        }


//
//        Thread.sleep(10000);
//        executorService.shutdown();
//
//
//
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("java");
//            }
//        });
//        Thread thread=new Thread();
//        thread.start();
//        executorService.isShutdown();
//        executorService.shutdown();
//        executorService.shutdownNow();
//        executorService.awaitTermination(10,TimeUnit.MILLISECONDS);
    }
}
