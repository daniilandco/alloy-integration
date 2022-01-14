package com.github.daniilandco.alloyintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AlloyIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlloyIntegrationApplication.class, args);
    }

}
