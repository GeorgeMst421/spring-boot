package com.georgemst.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component //Marks the class as a Spring Bean
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override 
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes cricket coaaaaach!!!!!!!!";
    }

    //define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartUpStuff " + getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("In doMyCleanUpStuff" + getClass().getSimpleName() );
    }
}
