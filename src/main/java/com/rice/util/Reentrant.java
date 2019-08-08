package com.rice.util;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
    AbstractQueuedSynchronizer a;
    ReentrantLock lock=new ReentrantLock();

    public void getMyLock(){
        lock.lock();
        try{

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
