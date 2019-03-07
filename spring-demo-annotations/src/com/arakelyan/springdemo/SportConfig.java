package com.arakelyan.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.arakelyan.springdemo")

//Loading property file
@PropertySource("classpath:sport2.properties")
public class SportConfig {

    //Define BEAN for our SadFortuneService
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    //Define BEAN for our SwimCoach and inject dependencies
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
