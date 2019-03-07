package com.arakelyan.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//Scope for prototype, no scope = singleton bean
//@Scope("prototype")
public class TennisCoach implements Coach {

//  Without setter and constructor injection. Autowire on a field
// Qualifier added for specify which IMPL to inject
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

//    Dependencies injection via constructor
/*    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
*/


//  Any method name can be with AUTOWIRED. not only SETTER
/*    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }
*/

    //Define init method
    @PostConstruct
    private void doForInit() {
        System.out.println(">> Tennis coach: Inside INIT method");
    }

    //Define destroy method
    @PreDestroy
    private void doForDestroy() {
        System.out.println(">> Tennis coach: Inside DESTROY method");
    }


    @Override
    public String getDailyWorkout() {
        return "Practice for AOPEN";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
