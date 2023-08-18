package com.landongnet.auth.controller;

import com.github.snake.rock.web.controller.BaseController;
import com.github.snake.rock.web.model.R;
import com.landongnet.auth.model.bo.LoginBO;
import com.landongnet.auth.model.dto.LoginDTO;
import com.landongnet.auth.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author snake
 * @description
 * @since 2023/8/17 22:20
 */
@Api(tags = "统一登录")
@AllArgsConstructor
@RestController
public class LoginController extends BaseController {

    private final LoginService loginService;

    @PostMapping(value = "/login")
    @ApiOperation("统一登录登录")
    public ResponseEntity<R<LoginDTO>> login(@Validated(LoginBO.Login.class) @RequestBody LoginBO loginBo){
        return success(loginService.login(loginBo));
    }

}
