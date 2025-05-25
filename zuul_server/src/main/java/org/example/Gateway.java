package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gateway {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Gateway.class);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }
}