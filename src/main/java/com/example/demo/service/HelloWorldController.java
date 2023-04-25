package com.example.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: baodan
 * @date: 2023/4/25
 * @version: 1.1.0
 **/
@RestController
public class HelloWorldController {


    @RequestMapping("/")
    public String sayHello(){
        return "Hello,World!";
    }
}
