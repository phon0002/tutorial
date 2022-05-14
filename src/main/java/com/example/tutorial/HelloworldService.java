package com.example.tutorial;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HelloworldService {

    private static int count = 0;

    @Retry(name = "hello-retry")
    public String getHello() {
        if (count < 5) {
            System.err.println("Test" + count);
            count++;
            throw new RuntimeException("File Not Found.");
        }

        return "Hello world!";
    }
}
