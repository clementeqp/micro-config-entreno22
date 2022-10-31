package com.usuario.srv.service;

import com.usuario.srv.entity.UserDB;
import com.usuario.srv.events.UserCreatedEvent;
import com.usuario.srv.events.Event;
import com.usuario.srv.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class UserDBEventService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.user.name:users}")
    private String topicUser;

    public void publish(UserDB user) {

        UserCreatedEvent created = new UserCreatedEvent();
        created.setData(user);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicUser, created);
    }



}
