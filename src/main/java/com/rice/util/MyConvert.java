package com.rice.util;

import org.apache.commons.beanutils.ConvertUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyConvert {
        final Lock lock = new ReentrantLock();          //锁对象
        final Condition notFull  = lock.newCondition(); //写线程锁
        final Condition notEmpty = lock.newCondition(); //读线程锁

        final Object[] items = new Object[100];//缓存队列
        int putptr;  //写索引
        int takeptr; //读索引
        int count;   //队列中数据数目

        //写
        public void put(Object x) throws InterruptedException {
            lock.lock(); //锁定
            try {
                // 如果队列满，则阻塞<写线程>
                while (count == items.length) {
                    notFull.await();
                }
                // 写入队列，并更新写索引
                items[putptr] = x;
                if (++putptr == items.length) putptr = 0;
                ++count;

                // 唤醒<读线程>
                notEmpty.signal();
            } finally {
                lock.unlock();//解除锁定
            }
        }

        //读
        public Object take() throws InterruptedException {
            lock.lock(); //锁定
            try {
                // 如果队列空，则阻塞<读线程>
                while (count == 0) {
                    notEmpty.await();
                }

                //读取队列，并更新读索引
                Object x = items[takeptr];
                if (++takeptr == items.length) takeptr = 0;
                --count;

                // 唤醒<写线程>
                notFull.signal();
                return x;
            } finally {
                lock.unlock();//解除锁定
            }
        }

    public static void main(String[] args) {
        MyConvert convert=new MyConvert();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    convert.put("q");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    convert.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
