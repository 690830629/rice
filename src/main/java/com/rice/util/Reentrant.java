package com.rice.util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock(false);

        Condition condition;
            lock.lock();
            try{

            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }

    }
