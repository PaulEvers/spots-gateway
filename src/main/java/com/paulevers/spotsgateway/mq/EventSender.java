package com.paulevers.spotsgateway.mq;

import com.paulevers.spotsgateway.mq.events.IRabbitEvent;
import com.paulevers.spotsgateway.mq.events.RequestAllSpotsEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class EventSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    private void sendMessage(IRabbitEvent event, String exchange, String routingkey) {
        RequestAllSpotsEvent requestAllSpotsEvent = new RequestAllSpotsEvent();
        requestAllSpotsEvent.setSpotName("John Doe");
        rabbitTemplate.convertAndSend(exchange, routingkey, requestAllSpotsEvent);
        ResponseEntity.ok().build();
    }
}
