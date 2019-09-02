package com.rice.util;

import java.util.concurrent.ArrayBlockingQueue;

public class MyQueue {

    public static void take(ArrayBlockingQueue arrayBlockingQueue) throws InterruptedException {
        System.out.println("begin take");
        System.out.println(arrayBlockingQueue.take());
        System.out.println("end take");

    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        MyTask myTask = new MyTask(arrayBlockingQueue);
        Thread thread = new Thread(myTask);
        thread.start();
        while(true){
            take(arrayBlockingQueue);
        }
    }
}
