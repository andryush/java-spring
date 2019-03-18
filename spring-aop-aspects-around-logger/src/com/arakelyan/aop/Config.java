package com.arakelyan.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.arakelyan.aop")
@EnableAspectJAutoProxy
public class Config {
}
