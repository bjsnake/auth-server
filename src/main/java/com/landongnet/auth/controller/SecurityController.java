package com.landongnet.auth.controller;

import com.github.snake.rock.common.constants.CommonCons;
import com.github.snake.rock.web.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

/**
 * @author snake
 * @description
 * @since 2023/8/17 22:17
 */
@RestController
@RequiredArgsConstructor
@RequestMapping
public class SecurityController extends BaseController {

  /**
   * 资源服务器校验端点
   * @param principal
   * @return
   */
  @GetMapping(value = "/user",headers = CommonCons.HEADER_AUTHORIZATION)
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
