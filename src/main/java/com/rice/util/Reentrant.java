package com.rice.util;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
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
