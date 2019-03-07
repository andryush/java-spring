package com.arakelyan.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport2.properties")
public class TestConfig {

    @Bean
    public FortuneService testFortuneService() {
        return new TestFortuneService();
    }

    @Bean
    public Coach testCoach() {
        return new TestCoach(testFortuneService());
    }

}
