package com.rice.SpringBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitBean implements InitializingBean {

    @Autowired
    private MyFactoryBean myFactoryBean;

    private String name;
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        System.out.println(myFactoryBean);
    }
}
