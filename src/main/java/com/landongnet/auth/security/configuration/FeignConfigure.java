package com.landongnet.auth.security.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author snake
 * @description
 * @since 2023/8/17 16:06
 */
@Configuration
public class FeignConfigure {
    /**
     * Feign调用的日志输出级别
     * @return
     */
    @Bean
    Logger.Level  getLogger(){
        return Logger.Level.FULL;
    }

    /**
     * 随机调用服务的负载均衡算法
     * @return
     */
//    @Bean
//    IRule getIRule(){
//        return new RandomRule();
//    }
}
