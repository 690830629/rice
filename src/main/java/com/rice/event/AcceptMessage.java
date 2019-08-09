package com.rice.event;

import com.google.common.eventbus.Subscribe;
import com.rice.entity.Dog;
import com.rice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AcceptMessage {
    @Subscribe
    public void handleWith(User user) {
        System.out.println("接受到消息了"+user);
    }

    @Subscribe
    public void handleWith(Dog dog) {
        System.out.println("接受到消息了"+dog);
    }

}
