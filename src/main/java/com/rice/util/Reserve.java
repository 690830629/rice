package com.rice.util;

import com.google.common.collect.Lists;
import com.rice.entity.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Reserve {
     public static void a(){
         List<User> userLists= Lists.newArrayList();
             User user=new User();
             user.setAge(10);
             user.setName("张飞");
             User user1=new User();
             user1.setAge(18);
             user1.setName("赵云");
             User user2=new User();
             user2.setName("马超");
             user2.setAge(4);
         userLists.add(user);
         userLists.add(user1);
         userLists.add(user2);
         Collections.sort(userLists, new Comparator<User>() {
             @Override
             public int compare(User user1, User user2) {
                 return user2.getAge()-user1.getAge();
             }
         });
         for(User usertt:userLists){
             System.out.println(usertt.toString());
         }
     }

    public static void main(String[] args) {
        a();

    }
}
