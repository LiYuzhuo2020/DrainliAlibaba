package com.nacos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author: Drainli
 **/
@Component
@ConfigurationProperties(prefix = "user")
public class User implements Serializable {

    private final long SERIA_VERSION = 1l ;

    private String name ;

    private int age ;

    private String height ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
