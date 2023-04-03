package com.example.exercise_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ExerciseSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseSpringBootApplication.class, args);
    }

}
