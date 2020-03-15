package com.rice.util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {





    public static void main(String[] args) throws InterruptedException {


        ReentrantLock lock = new ReentrantLock(false);
        Condition myCondition1 = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    myCondition1.await();
                    System.out.println(Thread.currentThread().getName()+"====");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                  lock.unlock();
                }



            }
        });

        Thread.sleep(10000);
        lock.lock();
        myCondition1.signal();
        lock.unlock();
        System.out.println( Thread.currentThread().getName()+"====");
    }

}
