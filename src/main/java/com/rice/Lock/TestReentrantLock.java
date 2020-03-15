package com.rice.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {


    public static void main(String[] args) throws InterruptedException {

        Lock lock=new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {

                lock.lock();

                lock.lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("唤醒了不错");
                lock.unlock();
                lock.unlock();
            }
        }).start();
        Thread.sleep(10000);
        lock.lock();
        condition.signal();
        lock.unlock();

    }
}
