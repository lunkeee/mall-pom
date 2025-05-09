package org.example.order.service;

import org.example.order.modules.Request.OrderCreateRequest;
import org.example.order.modules.Response.OrderCreateResponse;

public interface OrderService {

    /**
     * 创建订单
     *
     * @return OrderCreateResponse 订单基本信息
     */
    public OrderCreateResponse createOrder(OrderCreateRequest request);


    /**
     * 获取订单详情
     *
     * @return List<ProductSPU> 订单基本信息
     */
    public String getOrderDetail();

    /**
     * 获取订单列表
     *
     * @return List<ProductSPU> 订单基本信息
     */
    public String getOrderList();

    /**
     * 取消订单
     *
     * @return Boolean 是否取消成功
     */
    public String cancelOrder();

    void send(String testRabbitmq);
}
