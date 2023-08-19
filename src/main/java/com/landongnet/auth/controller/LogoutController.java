package com.landongnet.auth.controller;

import com.github.snake.rock.common.constants.CommonCons;
import com.github.snake.rock.common.constants.StringPool;
import com.github.snake.rock.common.model.R;
import com.github.snake.rock.security.utils.SecurityUtil;
import com.github.snake.rock.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author snake
 * @description
 * @since 2023/8/18 17:02
 */
@Api(tags = "统一登出")
@RestController
@RequiredArgsConstructor
@RequestMapping
public class LogoutController extends BaseController {

    private final ConsumerTokenServices consumerTokenServices;

    @GetMapping(value = "/logout",headers = CommonCons.HEADER_AUTHORIZATION)
    @ApiOperation("统一登出")
    public ResponseEntity<R<Boolean>> logout() {
        String token = SecurityUtil.getCurrentTokenValue();
        token = StringUtils.replace(token, "bearer ", StringPool.EMPTY);
        consumerTokenServices.revokeToken(token);
        return success(Boolean.TRUE);
    }
}
