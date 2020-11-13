package com.setinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: Drainli
 **/
@SpringBootApplication
@EnableScheduling
public class SetinelStartupApplication {
    public static void main(String[] args) {
        SpringApplication.run(SetinelStartupApplication.class,args) ;
    }
}
