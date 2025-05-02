package org.example.order.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public String createOrder() {
        return "";
    }

    @Override
    public String getOrderDetail() {
        return "";
    }

    @Override
    public String getOrderList() {
        return "";
    }

    @Override
    public String cancelOrder() {
        return "";
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend("myQueue", message);
        rabbitTemplate.convertAndSend("myQueue2", message);
        System.out.println("Sent: " + message);
    }

}
