package com.drainli.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @Author: Drainli
 * @Date: 2020/11/1 19:54
 * @Description: 简易springboot自动装配redis
 * @Version: 1.0
 **/
@Configuration
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {

    /**
    * 创建redisson 客户端
    * */
    @Bean
    public RedissonClient redissonClient (RedissonProperties redissonProperties) {
        Config config = new Config() ;
        String prefix = "redis://" ;
        if (redissonProperties.isSsl()){
            prefix = "rediss://" ;
        }
        SingleServerConfig singleServerConfig = config.useSingleServer()
                                                        .setAddress(prefix+redissonProperties.getHost()+":"+redissonProperties.getPort())
                                                        .setConnectTimeout(redissonProperties.getTimeout()) ;
        if (!StringUtils.isEmpty(redissonProperties.getPassword()))
            singleServerConfig.setPassword(redissonProperties.getPassword()) ;

        return Redisson.create(config) ;
    }


}
