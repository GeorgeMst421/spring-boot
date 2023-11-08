package com.georgemst.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenissCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Swing that god damn raketa gamw to xristo sou";
    }
}
