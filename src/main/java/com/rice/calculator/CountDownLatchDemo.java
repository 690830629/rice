package com.rice.calculator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static final int SIZE = 10;   //定义被等待线程数目
    CountDownLatch countDownLatch = new CountDownLatch(SIZE);

    private static final ExecutorService executorService;

    static {
        executorService = Executors.newCachedThreadPool();

    }

    public void executeFirstTask() {
        TaskRunnable taskRunnable = new TaskRunnable(countDownLatch);
        executorService.submit(taskRunnable);

    }


    public void executeWaitingTask() {
        WaitingTask waitingTaskRunnable = new WaitingTask(countDownLatch);
        executorService.submit(waitingTaskRunnable);

    }

    public static void main(String[] args) {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        for (int i = 0; i < 5; i++) {
            countDownLatchDemo.executeWaitingTask();
        }
        for (int i = 0; i < 20; i++) {
            countDownLatchDemo.executeFirstTask();
        }

    }
}
