package com.rice.event;

import com.google.common.eventbus.Subscribe;
import com.rice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AcceptMessage {
    @Subscribe
    public void handleWith(User user) {
        System.out.println("接受大到消息了"+user);
    }

}
