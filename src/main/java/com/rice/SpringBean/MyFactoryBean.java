package com.rice.SpringBean;

import com.rice.entity.Dog;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {

    private String name;

    private int age;
    @Override
    public Object getObject() throws Exception {
        Dog dog=new Dog();
        return dog;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
