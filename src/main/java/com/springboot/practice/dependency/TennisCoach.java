package com.springboot.practice.dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Let's play tennis from TennisCoach :-)";
    }
}
