package com.weimin.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class App2Starter {
    public static void main(String[] args) {
        SpringApplication.run(App2Starter.class, args);
    }
}
