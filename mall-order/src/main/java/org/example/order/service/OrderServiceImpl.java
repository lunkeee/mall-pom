package org.example.order.service;


import lombok.extern.slf4j.Slf4j;
import org.example.order.modules.Request.OrderCreateRequest;
import org.example.order.modules.Response.OrderCreateResponse;
import org.example.user.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private UserService userService;

    @Override
    @Transactional
    public OrderCreateResponse createOrder(OrderCreateRequest request) {
        //1、获取用户信息

        //2、获取商品信息，检验、锁定库存
        //3、计算总价
        //4、生成订单实体
        return null;
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
