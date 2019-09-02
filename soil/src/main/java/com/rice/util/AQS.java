package com.rice.util;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQS extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    public void getSynchronizer(){
         AbstractQueuedSynchronizer abstractQueuedSynchronizer;

    }
}
