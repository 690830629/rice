package com.rice.util;

import com.google.common.collect.Lists;
import com.rice.entity.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Generic {
    private static void unSafeAdd(List list,Object object){
        list.add(object);
    }
    private static void safeAdd(List<Object> list,Object object){
        list.add(object);
    }
    private static int unSafeNumElementsInCommon(Set s1,Set s2){
        int result=0;
        for(Object o1:s1){
            if(s2.contains(o1)){
                result++;
            }
        }
        return result;
    }
    private static int SafeNumElementsInCommon(Set<?> s1,Set<?> s2){
        int result=0;
        for(Object o1:s1){
            if(s2.contains(o1)){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        {

            List<User> listUser= Lists.newArrayList();
            for(int i=0;i<10;i++)
            {
                User user=new User();
                user.setAge(i);
                listUser.add(user);
            }
            for(User user:listUser){
                System.out.println("之前"+user.getAge());
            }
           for(User user:listUser){
                if(user.getAge()==2 || user.getAge()==4){
                    listUser.remove(user);
                    break;
                }
           }
            for(User user:listUser){
                System.out.println("之后"+user.getAge());
            }

        }
    }

}
