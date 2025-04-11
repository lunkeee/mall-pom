package org.example.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("用户ID（雪花算法）")
    private Long userId;

    @ApiModelProperty("登录账号")
    private String username;

    @ApiModelProperty("加密密码（bcrypt）")
    private String password;

    @ApiModelProperty("手机号（AES加密存储）")
    private String mobile;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像URL")
    private String avatar;

    @ApiModelProperty("状态（0禁用/1正常/2逻辑注销）")
    @TableLogic(value = "2")
    private Integer status;

    @ApiModelProperty("最后登录时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty("数据插入时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @ApiModelProperty("数据修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

//    @ApiModelProperty("逻辑删除标志")
//    @TableLogic
//    private Boolean deleted;
}

