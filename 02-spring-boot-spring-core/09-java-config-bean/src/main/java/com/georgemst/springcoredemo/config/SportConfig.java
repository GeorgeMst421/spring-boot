package com.georgemst.springcoredemo.config;

import com.georgemst.springcoredemo.common.Coach;
import com.georgemst.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")  // aquatic is the beanID
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
