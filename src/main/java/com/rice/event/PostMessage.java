package com.rice.event;

import com.google.common.eventbus.EventBus;
import com.rice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class PostMessage {
    private EventBus eventBus;

    public void postMessage() {
        User user = new User();
        user.setName("王蕾CEO");
        user.setAge(26);
        eventBus.post(user);
    }

}
