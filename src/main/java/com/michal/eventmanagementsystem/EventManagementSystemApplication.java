package com.michal.eventmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EventManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementSystemApplication.class, args);
    }

}
