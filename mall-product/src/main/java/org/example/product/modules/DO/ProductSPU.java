package org.example.product.modules.DO;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("product_spu")
public class ProductSPU {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("标准产品单元ID（雪花算法）")
    private Long spuId;

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

    @ApiModelProperty("状态（0下架/1上架）")
    private Integer status = 1;

    @ApiModelProperty("最后修改时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty("数据插入时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @ApiModelProperty("数据修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}
