package com.rice.controller;

import com.rice.entity.User;
import com.rice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    private List<User> getUserInfo() {
        try {
            return userService.getUserInfo();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Map test() {
        Map map = new HashMap<String, Object>();
        map.put("name", "rice");
        map.put("age", 24);
        return map;
    }

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    private User selectByPrimaryKey(
            @RequestParam(value = "userId", defaultValue = "0") String userId) {
        try {
            return userService.selectByPrimaryKey(Integer.parseInt(userId));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
