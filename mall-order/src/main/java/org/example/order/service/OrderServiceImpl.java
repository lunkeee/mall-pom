package org.example.order.service;


import lombok.extern.slf4j.Slf4j;
import org.example.common.config.feign.UserClientForOrder;
import org.example.modules.DO.User;
import org.example.modules.DTO.OrderCreateRequest;
import org.example.modules.VO.OrderCreateResponse;
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
    private UserClientForOrder userClientForOrder;

    @Override
    @Transactional
    public OrderCreateResponse createOrder(OrderCreateRequest request) {
        //1、获取用户信息
        User user = userClientForOrder.getUserById(request.getUserId());

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
