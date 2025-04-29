package org.example.order.modules.DO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单商品明细实体类
 */
public class OrderDetail {
    /**
     * 明细ID
     */
    private Long detailId;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * SKU ID
     */
    private Long skuId;

    /**
     * 冗余商品名称
     */
    private String skuName;

    /**
     * 冗余商品图片
     */
    private String skuImage;

    /**
     * 下单时价格
     */
    private BigDecimal skuPrice;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 小计金额
     */
    private BigDecimal subtotal;

    /**
     * 冗余规格信息(JSON格式)
     */
    private String specs;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}