package org.example.modules.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductSPUResponse {

    @ApiModelProperty("标准产品单元ID（雪花算法）")
    private int spuId;

    @ApiModelProperty("商品名称")
    private String spuName;

    @ApiModelProperty("类目ID")
    private Long categoryId;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @ApiModelProperty("主图URL")
    private String mainImage;

    @ApiModelProperty("商品描述（富文本）")
    private String description;

    @ApiModelProperty("总销量")
    private Integer sales = 0;

    // 需要查product_sku表
    @ApiModelProperty("SKU最低销售价")
    private BigDecimal price;
}
