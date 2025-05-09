package org.example.modules.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductSKUResponse {

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

    @ApiModelProperty("库存")
    private Integer stock = 0;

    @ApiModelProperty("SKU主图")
    private String image;

}
