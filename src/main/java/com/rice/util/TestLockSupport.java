package com.rice.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class TestLockSupport {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=null;
        LockSupport.park();
        Class<LockSupport> fff = LockSupport.class;
        LockSupport.unpark(thread);
        LockSupport.parkNanos(5L);
        CountDownLatch countDownLatch=new CountDownLatch(10);
        countDownLatch.await();
    }
}
