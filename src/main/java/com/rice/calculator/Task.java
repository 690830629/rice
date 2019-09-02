package com.rice.calculator;

import com.google.common.collect.Lists;
import com.rice.entity.User;

import java.util.List;
import java.util.concurrent.Callable;

public class Task implements Callable<List<User>> {
    @Override
    public List<User> call() throws Exception {
        List<User> userList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("我是" + i + i);
            userList.add(user);
        }
        return userList;
    }
}
