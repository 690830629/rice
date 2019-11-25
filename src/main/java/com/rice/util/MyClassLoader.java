package com.rice.util;

import com.rice.entity.Dog;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MyClassLoader {

    private static Unsafe myUnsafe;

    static {
        Field f = null;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        f.setAccessible(true);
        try {
            myUnsafe = (Unsafe) f.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void filedOffset() throws NoSuchFieldException, IllegalAccessException {
        Dog dog = new Dog();
        dog.setName("旺财");
        dog.setAge(1);
        Field filedName = dog.getClass().getDeclaredField("name");
        long nameOffset = myUnsafe.objectFieldOffset(filedName);
        myUnsafe.putObject(dog, nameOffset, "旺财厉害");
        System.out.println(dog);
    }

    public static void arrayOffset() {
        Dog[] arrayDog = new Dog[10];
        for (int i = 0; i < arrayDog.length; i++) {
            Dog dog = new Dog();
            dog.setAge(i);
            dog.setName("我是第"+i+ "个旺财");
            arrayDog[i]=dog;
        }
        for (int i = 0; i < arrayDog.length; i++) {
            System.out.println(arrayDog[i].getName() + " 我的年龄是"+arrayDog[i].getAge());
        }
        int baseOffset = myUnsafe.arrayBaseOffset(arrayDog.getClass());
        int indexScale = myUnsafe.arrayIndexScale(arrayDog.getClass());
        System.out.println(baseOffset);
        System.out.println(indexScale);
        Dog dog = new Dog();
        dog.setAge(2222);
        dog.setName("fff");
        myUnsafe.putObject(arrayDog,(indexScale<<2)+baseOffset,dog);
        for (int i = 0; i < arrayDog.length; i++) {
            System.out.println(arrayDog[i].getName() + " 我的年龄是"+arrayDog[i].getAge());
        }
    }

    public static void main(String[] args) {
        arrayOffset();

    }
}
