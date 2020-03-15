package com.rice.Lock;

public class AddThread implements Runnable {

    private MyThreadTask task;

    public AddThread(MyThreadTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.add();
    }
}
