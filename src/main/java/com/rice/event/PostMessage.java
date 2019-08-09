package com.rice.event;

import com.google.common.eventbus.EventBus;
import com.rice.entity.Dog;
import com.rice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMessage {
    @Autowired
    private AcceptMessage acceptMessage;
    private  static EventBus eventBus;
    static {
        eventBus=new EventBus();
    }

    public void postMessage() {
        User user = new User();
        user.setName("王蕾CEO");
        user.setAge(26);
        Dog dog=new Dog();
        dog.setName("旺财");
        dog.setAge(1);
        eventBus.register(acceptMessage);
        eventBus.post(user);
        eventBus.post(dog);
    }

}
