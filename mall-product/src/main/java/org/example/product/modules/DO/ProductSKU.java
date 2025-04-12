package org.example.product.modules.DO;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("product_sku")
public class ProductSKU {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("库存单元ID（雪花算法）")
    private Long skuId;

    @ApiModelProperty("关联SPU")
    private Long spuId;

    @ApiModelProperty("SKU编码（条形码）")
    private String skuCode;

    @ApiModelProperty("规格属性（如{\"颜色\":\"红\",\"尺寸\":\"XL\"}）")
    @TableField(typeHandler = com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler.class)
    private String specs;

    @ApiModelProperty("销售价")
    private BigDecimal price;

    @ApiModelProperty("成本价")
    private BigDecimal costPrice;

    @ApiModelProperty("库存")
    private Integer stock = 0;

    @ApiModelProperty("库存预警值")
    private Integer stockWarning = 10;

    @ApiModelProperty("SKU主图")
    private String image;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}
