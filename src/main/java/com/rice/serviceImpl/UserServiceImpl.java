package com.rice.serviceImpl;

import com.rice.dao.UserDao;
import com.rice.entity.User;
import com.rice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUserInfo() {
       return  userDao.getUserInfo();
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        User user=new User();
        user.setAge(22);
        user.setName("wanglei");
        return user;
    }
}
