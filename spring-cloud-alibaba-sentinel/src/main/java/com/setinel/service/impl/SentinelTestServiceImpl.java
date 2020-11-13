package com.setinel.service.impl;

import com.setinel.service.SentinelTestService;
import com.setinel.util.SentinelRulesUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @Author: Drainli
 **/
@Service
public class SentinelTestServiceImpl implements SentinelTestService {

    @Override
    public Mono<String> one() {

        //配置限流规则
        SentinelRulesUtils utils = new SentinelRulesUtils() ;
        utils.initFlowRules();

        return Mono.just("one");
    }

}
