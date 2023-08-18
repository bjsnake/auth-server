package com.landongnet.auth;

import cn.hutool.core.util.StrUtil;
import com.github.snake.rock.security.annotation.EnableCloudResourceServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author snake
 * @since 2023/8/17 12:27
 */

@Slf4j
@EnableRedisHttpSession
@EnableCloudResourceServer
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.landongnet.auth.security.rest"})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AuthApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env) {
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StrUtil.isBlank(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("无法确定主机地址，使用默认值'localhost'.");
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}{}\n\t" +
                        "External: \thttp://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                serverPort,
                contextPath,
                hostAddress,
                serverPort,
                contextPath,
                env.getActiveProfiles());
    }
}
