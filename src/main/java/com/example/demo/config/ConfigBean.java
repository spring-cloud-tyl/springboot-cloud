package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author tangyulin
 * @description
 * @createdate 10/30/2018
 */
@Configuration
@PropertySource("classpath:config/dudu.properties")
@ConfigurationProperties(prefix = "com.dudu")
public class ConfigBean {

    private String name;
    private String title;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
