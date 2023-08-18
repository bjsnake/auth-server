package com.landongnet.auth.controller;

import com.github.snake.rock.common.constants.CommonCons;
import com.github.snake.rock.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

/**
 * @author snake
 * @description
 * @since 2023/8/17 22:17
 */
@Api(tags = "用户信息")
@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController extends BaseController {

    @ApiOperation("获取用户信息")
    @GetMapping(value = "/user",headers = CommonCons.HEADER_AUTHORIZATION)
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
