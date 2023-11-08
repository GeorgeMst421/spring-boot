package com.MyCoolApplication.www.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties for coach name and team name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose endpoint for the coach and team name

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team Name: "+ teamName;
    }

    //Expose the "/" that returns Hello World

    @GetMapping("/")
    public String sayHello(){
        return "Hello World this is george";
    }

    //expose new endpoints
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5km now!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "you are gonna be Famous and the whole world will know your name";
    }
}
