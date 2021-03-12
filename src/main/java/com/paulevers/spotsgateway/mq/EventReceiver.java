package com.paulevers.spotsgateway.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventReceiver {

    private Logger log = LoggerFactory.getLogger(EventReceiver.class);

    @RabbitListener(queues = "${workshop.rabbitmq.queue}")
    public void receive(String event) {
        System.out.println("received the event!");
        log.info("Received event in email document generation: {}", event);
        // Convert to object.
        // Do with it whatever you please.
    }
}

