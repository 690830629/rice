package com.rice.SpringBean;

import com.rice.entity.Dog;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglib implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---------------");
        //这个obj的引用是由CGLib给我们new出来的
        //cglib new出来以后的对象，是被代理对象的子类
        //在new子类之前，实际上默认先调用了我们super()方法的，
        //new子类的同时，必须先new出来父类，这就相当于是间接的持有了我们父类的引用
        //子类重写了父类的所有的方法
        //我们改变子类对象的某些属性，是可以间接的操作父类的属性的
        methodProxy.invokeSuper(o,objects);//这里是调父类的（子类死循环）
        System.out.println("---------------");
        return null;
    }
    public Object getInstance(Class clazz)throws Exception{
        Enhancer enhancer = new Enhancer();
        //告诉cglib，生成的子类需要继承哪个类
        enhancer.setSuperclass(clazz);
        //设置回调
        enhancer.setCallback(this);
        //生成源代码
        //编译成class文件
        //加载到JVM中，并返回被代理对象
        return enhancer.create();
    }
    public static void main(String[] args) throws Exception {
        Dog dog=  (Dog)new MyCglib().getInstance(Dog.class);
        dog.jump();
    }

}
