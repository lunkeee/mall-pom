package org.example.common.enums;


import lombok.Getter;

@Getter
public enum UserSexEnum {
    /** 男性 */
    MALE(1, "男"),
    /** 女性 */
    FEMALE(2, "女"),
    /** 未知 */
    UNKNOWN(0, "未知");

    private final Integer code;
    private final String desc;

    UserSexEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}