package com.springboot.practice.dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {

        return "Let's play Baseball from BaseballCoach :-)";
    }
}
