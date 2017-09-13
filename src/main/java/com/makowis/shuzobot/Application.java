package com.makowis.shuzobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.makowis.shuzobot"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}