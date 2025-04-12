package org.example.product.modules.DO;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName("product_category")
public class ProductCategory {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("类目ID（雪花算法）")
    private Long categoryId;

    @ApiModelProperty("父类目ID")
    private Long parentId;

    @ApiModelProperty("状态（0禁用/1启用）")
    private Integer status = 1; // 默认启用状态

    @ApiModelProperty("类目名称")
    private String categoryName;

    @ApiModelProperty("层级（1/2/3）")
    private Integer level;

    @ApiModelProperty("排序权重")
    private Integer sort = 0;

    @ApiModelProperty("类目图标")
    private String icon;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    // 可添加非数据库字段用于树形结构展示
    @TableField(exist = false)
    private List<ProductCategory> children;

}
