package com.rice.util;

import com.rice.entity.Dog;
public class FourThreadPool {
    private ThreadLocal<Dog> t=new ThreadLocal<>();


    public  void testThreadLocal() throws InterruptedException {
        Dog dog=new Dog("妮妮",19);
        System.out.println(Thread.currentThread().getName());
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                Dog dog=new Dog("哈哈",20);
                t.set(dog);
            }
        });
        t.set(dog);
        Thread.sleep(1000);
        thread.start();
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        FourThreadPool f=new FourThreadPool();
        f.testThreadLocal();
        Thread.sleep(1000);
        System.out.println(f.t.get());
    }


}
