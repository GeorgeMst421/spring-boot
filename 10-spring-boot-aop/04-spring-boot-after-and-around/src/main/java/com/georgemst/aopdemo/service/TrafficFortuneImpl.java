package com.georgemst.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {
        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //return a fortune
        return "Expect heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {

        if(tripWire){
            throw new RuntimeException("Major Accident! Highway is closed");
        }

        return getFortune();
    }
}
