package com.drainli.alibaba.consumer.service;

import com.drainli.alibaba.api.service.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : drainli
 * @Date : 2020/9/8 14:29
 * @Description: direct by drainli
 * @Version: 1.0
 **/
@RestController
public class IEchoController {

    @Reference
    IHelloService iHelloService ;

    @GetMapping("/echo")
    public String echoString(String name) {
        return iHelloService.sayHelloTo(name) ;
    }
}
