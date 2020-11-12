package com.drainli.provider.service;

import com.drainli.alibaba.api.service.IHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author : drainli
 * @Date : 2020/9/8 14:08
 * @Description: springCloud alibaba 服务提供者
 * @Version: 1.0
 **/
@Service(cluster = "failfast",loadbalance = "roundrobin")
public class IHelloServiceProvider implements IHelloService {

    public String sayHelloTo(String name) {
        return "Hello " + name ;
    }
}
