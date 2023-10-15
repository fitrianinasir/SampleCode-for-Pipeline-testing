package com.springboot.practice.controller;

import com.springboot.practice.dependency.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CoachController {

    private Coach myCoach;

    @PostConstruct
    public void prepareMyStuff(){
        System.out.println("Preparing all the configuration and resources");
    }

    @PreDestroy
    public void cleanUpMyStuff(){
        System.out.println("Cleaning up all configuration and resources");
    }

    @Autowired
    //define a constructor for dependency injection
    public CoachController(@Qualifier("tennisCoach") Coach theCoach){
        myCoach = theCoach;
    }
    @GetMapping("/get-workout")
    public String getWorkout(){
        return myCoach.getDailyWorkout();
    }
}
