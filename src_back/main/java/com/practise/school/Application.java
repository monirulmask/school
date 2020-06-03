package com.practise.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.practise.school","com.practise.common"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
