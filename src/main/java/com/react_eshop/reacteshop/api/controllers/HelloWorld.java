package com.react_eshop.reacteshop.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloWorld {

    @GetMapping("")
    public String index(){
        return "Hello World";
    }
}
