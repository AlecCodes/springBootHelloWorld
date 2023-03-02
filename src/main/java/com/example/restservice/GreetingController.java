package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//RestContorller marks the class as a controller which returns a domain object
//Meaning, this returns a Greeting object as JSON
@RestController
public class GreetingController{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    //Greeting is the type of obj returned , so we use it here instead of void
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}