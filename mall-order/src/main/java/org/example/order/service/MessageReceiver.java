package org.example.order.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(queues = "myQueue")
    public void receive(String message) {
        System.out.println("Received: " + message);
    }
}