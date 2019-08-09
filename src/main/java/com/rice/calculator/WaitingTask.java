package com.rice.calculator;

import java.util.concurrent.CountDownLatch;

public class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = ++counter;   //设置线程id
    private final CountDownLatch latch;  //线程中必须要有CountDownLatch的引用,为了跟Task进行通信

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "WaitingTask--" + id;
    }
}
