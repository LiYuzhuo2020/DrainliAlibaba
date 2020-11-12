package com.drainli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Drainli
 * @Date: 2020/11/3 10:10
 * @Description: nacos服务注册端
 * @Version: 1.0
 **/
@SpringBootApplication
//@EnableDiscoveryClient
public class NacosServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosServerApplication.class,args) ;
    }
}
