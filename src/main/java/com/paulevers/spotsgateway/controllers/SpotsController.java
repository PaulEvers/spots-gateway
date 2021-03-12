package com.paulevers.spotsgateway.controllers;

import com.paulevers.spotsgateway.mq.events.RequestAllSpotsEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotsController {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Value("${workshop.rabbitmq.exchange}")
    private String exchange;
    @Value("${workshop.rabbitmq.routingkey}")
    private String routingkey;

    @GetMapping(value = "/spots")
    public ResponseEntity spots() {
        RequestAllSpotsEvent requestAllSpotsEvent = new RequestAllSpotsEvent();
        requestAllSpotsEvent.setSpotName("John Doe");
        rabbitTemplate.convertAndSend(exchange, routingkey, requestAllSpotsEvent);
        return ResponseEntity.ok().build();
    }
}
