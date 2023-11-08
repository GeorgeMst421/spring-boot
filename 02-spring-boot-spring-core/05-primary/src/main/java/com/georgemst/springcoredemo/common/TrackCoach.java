package com.georgemst.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "O track coach leei na trekseis 50km twra gtxs";
    }
}
