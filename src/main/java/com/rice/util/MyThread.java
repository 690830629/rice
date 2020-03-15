package com.rice.util;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread {

    public static void a(){

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("主线程结束");

    }



}
