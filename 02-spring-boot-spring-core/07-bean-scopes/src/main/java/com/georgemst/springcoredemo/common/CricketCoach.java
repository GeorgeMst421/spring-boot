package com.georgemst.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //Marks the class as a Spring Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override 
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!!!!!";
    }
}
