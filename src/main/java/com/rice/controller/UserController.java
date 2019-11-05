package com.rice.controller;

import com.rice.SpringBean.MyFactoryBean;
import com.rice.entity.User;
import com.rice.event.PostMessage;
import com.rice.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostMessage postMessage;
    @Autowired
    private MyFactoryBean myFactoryBean;


    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    private List<User> getUserInfo() {
        try {
            List<User>  userList= userService.getUserInfo();
            return userList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test() {

        System.out.println("fff");
        System.out.println(myFactoryBean);
    }

    @RequestMapping(value = "getUserInfo1", method = RequestMethod.GET)
    private User selectByPrimaryKey(
            @RequestParam(value = "userId", defaultValue = "0") String userId) {
        try {
            System.out.println("进来了吗额");
            return userService.selectByPrimaryKey(Integer.parseInt(userId));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
