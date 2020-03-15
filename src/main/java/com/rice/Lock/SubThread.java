package com.rice.Lock;

public class SubThread implements Runnable {

    private MyThreadTask task;

    public SubThread(MyThreadTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.sub();
    }
}
