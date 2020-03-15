package com.rice.util;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolUtil {
    private static final ThreadPoolExecutor executorService;

    static {

        executorService = new ThreadPoolExecutor(2, 3, 30L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(5),new ThreadPoolExecutor.CallerRunsPolicy());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    System.out.println("dataCenter shutdown executorService");
                    executorService.shutdown();
                } catch (Exception e) {
                    System.out.println("dataCenter shutdown executorService error");
                }
            }
        });
    }
    public   void testExecutorService() throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        executorService.prestartAllCoreThreads();
        Field field = executorService.getClass().getDeclaredField("workers");
//        Class<?> fieldType = field.getType();
//        Class<?> myClass = executorService.getClass().getDeclaringClass();
//        Class<?> tt = executorService.getClass().getEnclosingClass();
//        Class<?>[] bffb = executorService.getClass().getDeclaredClasses();

        Class<?> workerType = Class.forName("java.util.concurrent.ThreadPoolExecutor$Worker");
        field.setAccessible(true);
        HashSet<?> hashSet =(HashSet<?>) field.get(executorService);
        Iterator<?> itr = hashSet.iterator();
        while(itr.hasNext()){
            Object ffff = itr.next();
            if(ffff.getClass()==workerType){
                Field thread = workerType.getDeclaredField("thread");
                thread.setAccessible(true);
                Thread jian = (Thread)thread.get(ffff);
                System.out.println( jian.getName());

            }
        }
       for(int i=0;i<2;i++){
           int j=i;
           executorService.submit(new Runnable() {
               @Override
               public void run() {
                  throw  new RuntimeException("我抛出了异常"+j);
               }
           });
       }

        System.out.println();





    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        MyThreadPoolUtil myThreadPoolUtil=new MyThreadPoolUtil();
        myThreadPoolUtil.testExecutorService();
    }
}
