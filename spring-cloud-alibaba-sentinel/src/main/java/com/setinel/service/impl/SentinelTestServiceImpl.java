package com.setinel.service.impl;

import com.setinel.service.SentinelTestService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @Author: Drainli
 **/
@Service
public class SentinelTestServiceImpl implements SentinelTestService {

    @Override
    public Mono<String> one() {
        return Mono.just("one");
    }

}
