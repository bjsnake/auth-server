package com.landongnet.auth.enums;

import com.github.snake.rock.web.exception.UnknownEnumException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author snake
 */

@Getter
@AllArgsConstructor
public enum ChannelEnum {

    /**
     * 员工PC
     */
    EMP(1),
    /**
     * 会员
     */
    MEMBER(2),


    ;

    private Integer code;


    public static ChannelEnum getEnum(Integer channel){
        for (ChannelEnum obj : values()) {
            if(obj.getCode().equals(channel)){
                return obj;
            }
        }
        throw new UnknownEnumException("错误枚举值");
    }
}
