package com.example.Springbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody

//  instead of these two annotation you can use rest controller
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String displayHello(){
        return "Hello world";
    }
}
