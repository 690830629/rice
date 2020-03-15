package com.rice.SpringBean;

import com.rice.entity.Dog;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<Dog> {

    @Override
    public Dog getObject() throws Exception {
        Dog dog=new Dog("小明",200);

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
