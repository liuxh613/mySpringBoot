package com.lxh.myboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/hello212")
    public String sayHello(){
        return "hello212";
    }

    @RequestMapping("/hello3")
    public String sayHello3(){
        return "hello3";
    }
}
