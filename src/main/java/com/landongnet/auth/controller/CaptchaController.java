package com.landongnet.auth.controller;

import com.github.snake.rock.common.exception.ValidateCodeException;
import com.github.snake.rock.web.controller.BaseController;
import com.landongnet.auth.service.ValidateCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author snake
 * @description
 * @since 2023/8/18 17:10
 */
@Api(tags = "验证码相关")
@RestController
@RequiredArgsConstructor
@RequestMapping
public class CaptchaController extends BaseController {

    private final ValidateCodeService validateCodeService;

    @ApiOperation("生成图片验证码")
    @GetMapping("/image/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }
}
