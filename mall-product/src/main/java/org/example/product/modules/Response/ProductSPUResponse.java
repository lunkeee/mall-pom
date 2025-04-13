package org.example.product.modules.Response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class ProductSPUResponse {

    @ApiModelProperty("标准产品单元ID（雪花算法）")
    private Long spuId;

    @ApiModelProperty("商品名称")
    private String spuName;

    @ApiModelProperty("类目ID")
    private Long categoryId;

    @ApiModelProperty("主图URL")
    private String mainImage;

    @ApiModelProperty("总销量")
    private Integer sales = 0;

    // 需要查product_sku表
    @ApiModelProperty("SKU最低销售价")
    private BigDecimal price;
}
