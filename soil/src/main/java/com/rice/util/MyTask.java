package com.rice.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

public class MyTask extends TimerTask implements Runnable {

    private ArrayBlockingQueue arrayBlockingQueue;

    private  static int i;

    private Timer timer;

    public MyTask() {

    }

    public MyTask(ArrayBlockingQueue arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }


    @Override
    public void run() {
        arrayBlockingQueue.add(3);
        i++;
        System.out.println("增加到了"+i+"个");
        timer = new Timer();
        timer.schedule(new MyTask(arrayBlockingQueue), 5000);
    }
}


