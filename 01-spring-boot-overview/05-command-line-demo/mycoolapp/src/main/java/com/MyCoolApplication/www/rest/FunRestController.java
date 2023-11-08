package com.MyCoolApplication.www.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World this is george";
    }

    //expose new endpoint
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5km now!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "you are gonna be Famous and the whole world will know your name";
    }
}
