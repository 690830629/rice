package com.rice.calculator;

import com.rice.entity.User;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkQueue {

    private static final ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(10);
    }

    public static List<User> getUserInfo() throws Exception {
        Task task = new Task();
        Future<List<User>> future = executorService.submit(task);
        List<User> userList = future.get();
        return userList;
    }

    public static void main(String[] args) throws Exception {
        List<User> userList = getUserInfo();
        for(int i=0;i<userList.size();i++){
            System.out.println(userList.get(i));
        }
    }

}
