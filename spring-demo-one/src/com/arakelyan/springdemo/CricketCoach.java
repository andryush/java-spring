package com.arakelyan.springdemo;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public CricketCoach() {

        System.out.println("Cricket Coach: Inside no-args constructor");

    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Cricket Coach: Inside setter method");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("Cricket Coach: inside EMAIL setter");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("Cricket Coach: Inside TEAM setter");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Nice shot!";
    }

    @Override
    public String getDailyFortune() {
        return "For cricket " + fortuneService.getFortune();
    }
}
