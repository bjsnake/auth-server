package com.landongnet.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author snake
 * @description
 * @since 2023/8/18 15:51
 */
@Getter
@AllArgsConstructor
public enum SupperAdminEnum {
    /**
     *
     */
    SUPPER(1),
    /**
     * 非默认租户
     */
    ORDINARY(0),

    ;

    private Integer code;
}
