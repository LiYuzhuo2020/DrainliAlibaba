package com.nacos.controller;

import com.nacos.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Drainli
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private User user ;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return user ;
    }

}
