package com.cognizant.calculatenetworth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CalculateNetworthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculateNetworthApplication.class, args);
    }

}
