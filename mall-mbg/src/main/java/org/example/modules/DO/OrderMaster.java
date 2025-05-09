package org.example.modules.DO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderMaster {
    /**
     * 订单ID（时间戳+用户ID哈希）
     */
    private Long orderId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 订单编号（可读性号）
     */
    private String orderNo;

    /**
     * 订单总额
     */
    private BigDecimal totalAmount;

    /**
     * 实付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 运费
     */
    private BigDecimal freightAmount;

    /**
     * 优惠券抵扣
     */
    private BigDecimal couponAmount;

    /**
     * 支付方式（1微信/2支付宝）
     */
    private Integer paymentType;

    /**
     * 状态（0待支付/1已支付/2已发货/3已完成/4已取消）
     */
    private Integer status;

    /**
     * 收货地址ID
     */
    private Long addressId;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
