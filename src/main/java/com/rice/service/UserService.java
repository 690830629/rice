package com.rice.service;

import com.rice.entity.User;

import java.util.List;

public interface UserService {
     List<User> getUserInfo();

     User selectByPrimaryKey(Integer userId);

}
