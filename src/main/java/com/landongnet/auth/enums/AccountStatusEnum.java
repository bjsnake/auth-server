package com.landongnet.auth.enums;

import com.github.snake.rock.web.exception.UnknownEnumException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author snake
 * @description
 * @since 2023/8/18 00:13
 */
@Getter
@AllArgsConstructor
public enum AccountStatusEnum {

    NORMAL(0),

    DISABLE(1),

    ;

    private Integer code;


    public static AccountStatusEnum getEnum(Integer channel){
        for (AccountStatusEnum obj : values()) {
            if(obj.getCode().equals(channel)){
                return obj;
            }
        }
        throw new UnknownEnumException("错误枚举值");
    }
}
