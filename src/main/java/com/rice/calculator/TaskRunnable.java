package com.rice.calculator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskRunnable implements Runnable {
    private static int counter = 0;
    private final int id = ++counter;    //设置线程id
    //线程中必须要有CountDownLatch的引用，为了通知WaitTask计数器已经为0

    private  CountDownLatch latch;
    public TaskRunnable(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        try {
            doWork();      //这里睡眠1s，代表完成该线程的任务
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println(this + " completed");
    }

    public String toString() {
        return "Task--" + id;
    }
}
