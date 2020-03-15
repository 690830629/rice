package com.rice.util;

import com.rice.entity.Animal;
import com.rice.entity.Dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.ServiceLoader;

public class MyProxy {

    public static void main(String[] args) {
//        Animal dog=new Dog("小明",20);
//
//        Class<? extends Animal> dogClass = dog.getClass();
//        Animal fff = (Animal) Proxy.newProxyInstance(dogClass.getClassLoader(), dogClass.getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("代理了你");
//                method.invoke(dog);
//                return null;
//            }
//        });
//        fff.jump();
        ServiceLoader<Animal> ffff = ServiceLoader.load(Animal.class);
        System.out.println(ffff);
        Iterator<Animal> ggg = ffff.iterator();
        while (ggg.hasNext()){
            System.out.println(ggg.next());
        }

    }



}
