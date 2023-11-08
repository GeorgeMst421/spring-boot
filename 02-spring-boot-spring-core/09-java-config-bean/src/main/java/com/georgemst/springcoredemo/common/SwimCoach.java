package com.georgemst.springcoredemo.common;

import org.springframework.context.annotation.Bean;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor " +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "You must swim swim swim and do not forget to swim";
    }
}
