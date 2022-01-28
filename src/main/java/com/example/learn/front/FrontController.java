package com.example.learn.front;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/front")
public class FrontController {


    @GetMapping("test1")
    public String test1(){
        return "test1";
    }
}
