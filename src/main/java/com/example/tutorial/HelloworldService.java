package com.example.tutorial;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class HelloworldService {

    @Retry(name ="hello-retry")
    public String getHello(){
        return "Hello world!";
    }
}
