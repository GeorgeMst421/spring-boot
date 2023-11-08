package com.georgemst.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenissCoach implements Coach{

    public TenissCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swing that god damn raketa gamw to xristo sou";
    }
}
