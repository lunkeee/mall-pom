package org.example.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.common.enums.UserSexEnum;

import java.time.LocalDate;

@Data
public class UserEditVO {
    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("性别")
    private UserSexEnum sex;

    @ApiModelProperty("生日")
    private LocalDate birthday;
}