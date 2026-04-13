package com.example.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class LifecycleBeanExample {

    public LifecycleBeanExample() {
        System.out.println("1. Instantiation: Bean Constructor Called");
    }

    @PostConstruct
    public void init() {
        System.out.println("2. Initialization: @PostConstruct Method Called");
    }

    public void doWork() {
        System.out.println("3. Usage: Bean is performing its duties");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("4. Destruction: @PreDestroy Method Called");
    }
}
