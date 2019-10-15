package com.rice.util;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread {
    static ReentrantLock   lock=new ReentrantLock(true);

    public static void main(String[] args) {

        try {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try{
                        for (int i = 0; i < 2; i++) {
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName());
                        }

                    }catch(Exception e){
                        System.out.println("-=====");
                    }
                    finally {
                        lock.unlock();
                    }

                }
            };

            Thread t1 = new Thread(task);
            Thread t2 = new Thread(task);
            t1.start();
            t2.start();
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            ;
        }

    }

}
