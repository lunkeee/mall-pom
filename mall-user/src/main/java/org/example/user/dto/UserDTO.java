package org.example.user.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.common.enums.UserSexEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("user")
public class UserDTO {

    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("性别")
    private UserSexEnum sex;
    @ApiModelProperty("生日")
    private LocalDate birthday;
    @ApiModelProperty("逻辑删除标志")
    @TableLogic
    private Boolean deleted;
    @ApiModelProperty("数据插入时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @ApiModelProperty("数据修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmt1Modified;

}
