package com.rice.util;

import com.rice.entity.Dog;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class MyQueue {

    public static void take(ArrayBlockingQueue arrayBlockingQueue) throws InterruptedException {
        System.out.println("begin take");
        System.out.println(arrayBlockingQueue.take());
        System.out.println("end take");

    }

    public static BlockingQueue testOffer(){
        BlockingQueue<Dog> blockingQueue=new ArrayBlockingQueue<Dog>(2);
        Dog dog=new Dog("小明",20);
        Dog dog1=new Dog("小红",30);
        Dog dog2=new Dog("小刚",40);
        blockingQueue.add(dog);
        blockingQueue.add(dog1);
        blockingQueue.add(dog1);
        blockingQueue.add(dog2);
        return blockingQueue;


    }

    public static BlockingQueue testPut() throws InterruptedException {
        BlockingQueue<Dog> blockingQueue=new ArrayBlockingQueue<Dog>(2);
        BlockingQueue<Dog> linkedBlockingQueue=new LinkedBlockingQueue<>(2);

        Dog dog=new Dog("小明",20);
        Dog dog1=new Dog("小红",30);
        Dog dog2=new Dog("小刚",40);
        blockingQueue.put(dog);
        blockingQueue.poll();
        blockingQueue.put(dog1);
        blockingQueue.put(dog1);
        blockingQueue.put(dog2);
        return blockingQueue;


    }
    public static BlockingQueue testPool(BlockingQueue<Dog> blockingQueue) throws InterruptedException {
        SynchronousQueue synchronousQueue=new SynchronousQueue();
        PriorityBlockingQueue priorityBlockingQueue=new PriorityBlockingQueue();
        priorityBlockingQueue.take();
        return null;

    }


    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue=new ArrayBlockingQueue(10);
        arrayBlockingQueue.offer(2);//    对应 poll   arrayBlockingQueue.poll();   boolean
        arrayBlockingQueue.add(2);    //    对应 remove   arrayBlockingQueue.remove();  跑异常
        arrayBlockingQueue.put(1); //    对应 take   arrayBlockingQueue.take();  阻塞

        arrayBlockingQueue.peek();  // 直接返回空 返回空
        arrayBlockingQueue.poll();
        arrayBlockingQueue.take();
        arrayBlockingQueue.remove();

    }
}
