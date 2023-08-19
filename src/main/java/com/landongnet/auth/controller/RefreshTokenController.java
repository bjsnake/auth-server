package com.landongnet.auth.controller;

import com.github.snake.rock.common.model.R;
import com.github.snake.rock.web.controller.BaseController;
import com.landongnet.auth.model.dto.LoginDTO;
import com.landongnet.auth.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author snake
 * @description
 * @since 2023/8/18 17:12
 */
@Api(tags = "刷新令牌")
@RestController
@RequiredArgsConstructor
@RequestMapping
public class RefreshTokenController extends BaseController {

    private final LoginService loginService;

    @GetMapping(value = "/refreshToken")
    @ApiOperation("刷新令牌")
    public ResponseEntity<R<LoginDTO>> refreshToken(@RequestParam("refreshToken") String refreshToken){
        return success(loginService.refreshToken(refreshToken));
    }
}
