package com.setinel.controller;

import com.alibaba.csp.sentinel.adapter.reactor.SentinelReactorTransformer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.setinel.service.SentinelTestService;
import io.netty.util.concurrent.BlockingOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author: Drainli
 **/
@RestController
public class TestController {

    @Autowired
    private SentinelTestService sentinelTestService ;

    @GetMapping("/mono")
    public Mono<String> mono() {
        return Mono.just("sentinel mono test")
                    .transform(new SentinelReactorTransformer<>("mono")) ;
    }

    @GetMapping("/flux")
    public Flux<String> flux() {
        return Flux.just("hello ","world");
    }

    @GetMapping("/one")
    @SentinelResource(value = "one",fallback = "oneFallback",blockHandler = "blockHandler")
    public Mono<String> one() throws InterruptedException {
       //Thread.sleep(30000); // 模拟异常，出发限流机制
        throw new RuntimeException("blocked ! ") ;
       // return sentinelTestService.one() ;
    }

    public Mono<String> oneFallback() {
        return Mono.just("one is down") ;
    }

    public Mono<String> blockHandler(String id, BlockingOperationException e) {
        System.out.println(e.getCause().toString());
        return Mono.just("the service has been blocked !");
    }

}
