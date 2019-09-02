package com.rice.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
@Slf4j
public class ThreadPool {
    public static  void a() {

        int corePoolSize = 8;
        int maximumPoolSize = 8;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2048);

//        BlockingQueue<Runnable> workQueue = null;
//        ThreadFactory threadFactory = null;
        RejectedExecutionHandler handler = null;
//        RejectedExecutionHandler rejectionHandler = null;
          RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandler() {
              @Override
              public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                  System.out.println("快乐小面馆");
              }
          };

        ThreadPoolExecutor th = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue , rejectionHandler);
        List<Runnable> runnableList=Lists.newArrayList();
        runnableList.add(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println("我是第"+i+"个小朋友");
                }
            }
        });
        runnableList.add(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println("我是第"+i+"个小朋友");
                }
            }
        });
        th.submit(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println("我是第"+i+"个小朋友");
                }
            }
        });
        th.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public static void main(String[] args) {
        a();
        for(int i=0;i<1000;i++){
            System.out.println("你是第"+i+"个小朋友");
        }

    }
}
