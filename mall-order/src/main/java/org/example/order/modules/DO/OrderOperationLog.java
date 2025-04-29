package org.example.order.modules.DO;

import java.time.LocalDateTime;

/**
 * 订单状态变更日志实体类
 */
public class OrderOperationLog {
    /**
     * 日志ID
     */
    private Long logId;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 操作人类型（1用户/2系统/3客服）
     */
    private Integer operatorType;

    /**
     * 操作人ID
     */
    private Long operatorId;

    /**
     * 操作类型（create/pay/cancel）
     */
    private String action;

    /**
     * 操作备注
     */
    private String note;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

}
