package com.coche.srv.service;

import com.coche.srv.events.Event;
import com.coche.srv.events.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventsService {

    @KafkaListener(
            topics = "${topic.customer.name:users}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(UserCreatedEvent.class)) {
            UserCreatedEvent customerCreatedEvent = (UserCreatedEvent) event;
            log.info("Received Customer created event .... with Id={}, data={}",
                    customerCreatedEvent.getId(),
                    customerCreatedEvent.getData().toString());
        }
    }
}
