package com.rice.Lock;

import com.rice.util.MyThread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadTask {

    private final Lock lock = new ReentrantLock();

    private final Condition addCondition = lock.newCondition();

    private final Condition subCondition = lock.newCondition();


    private static int num = 0;
    private List<String> lists = new LinkedList<String>();

    public void add() {
        lock.lock();

        try {
            while (lists.size() == 10) {//当集合已满,则"添加"线程等待
                addCondition.await();
            }

            num++;
            lists.add("add Banana" + num);
            System.out.println("The Lists Size is " + lists.size());
            System.out.println("The Current Thread is " + Thread.currentThread().getName());
            System.out.println("==============================");
            this.subCondition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {//释放锁
            lock.unlock();
        }
    }


    public void sub() {
        lock.lock();

        try {
            while (lists.size() == 0) {//当集合为空时,"减少"线程等待
                subCondition.await();
            }

            String str = lists.get(0);
            lists.remove(0);
            System.out.println("The Token Banana is [" + str + "]");
            System.out.println("The Current Thread is " + Thread.currentThread().getName());
            System.out.println("==============================");
            num--;
            addCondition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyThreadTask task = new MyThreadTask();

        Thread t1 = new Thread(new AddThread(task));
        Thread t3 = new Thread(new AddThread(task));
        Thread t7 = new Thread(new AddThread(task));
        Thread t8 = new Thread(new AddThread(task));
        Thread t2 = new Thread(new SubThread(task));
        Thread t4 = new Thread(new SubThread(task));
        Thread t5 = new Thread(new SubThread(task));
        Thread t6 = new Thread(new SubThread(task));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
