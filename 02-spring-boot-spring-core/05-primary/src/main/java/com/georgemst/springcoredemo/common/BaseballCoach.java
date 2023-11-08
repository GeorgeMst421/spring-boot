package com.georgemst.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Hit the god damn ball you piece of shit";
    }
}
