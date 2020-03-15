package com.rice.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印
 */
public class TestReentrant {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock(false);
        Lock lock1 = new ReentrantLock(false);
        Condition notEmpty = lock.newCondition();
        Condition notNull = lock.newCondition();
        Queue<Integer> queue = new LinkedList();
        queue.offer(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                while (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("冲冲冲!!!");
                    notNull.signal();
                }
                lock.unlock();
            }
        }).start();

        Thread.sleep(200);

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock1.lock();
                while (queue.isEmpty()) {
                    queue.offer(1);
                    try {
                        notNull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("后退！！！");
                    notEmpty.signal();
                }
                lock1.unlock();
            }
        }).start();
    }


}
