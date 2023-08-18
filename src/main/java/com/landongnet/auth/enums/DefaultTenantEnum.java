package com.landongnet.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DefaultTenantEnum {
    /**
     * 默认租户
     */
    Y(1),
    /**
     * 非默认租户
     */
    N(0),

    ;

    private Integer code;


}