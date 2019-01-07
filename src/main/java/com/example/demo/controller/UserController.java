package com.example.demo.controller;

import com.example.demo.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangyulin
 * @description
 * @createdate 10/30/2018
 */
@RestController
public class UserController {

    @Autowired
    ConfigBean configBean;

    @RequestMapping("/")
    public String hello() {
        return configBean.getName() + "------1231221222-----" + configBean.getTitle();
    }
}
