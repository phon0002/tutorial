package com.example.tutorial.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TrackerService {

    private static int count = 0;

    @Retry(name = "hello-retry")
    public String getHello() {
        if (count < 5) {
            log.error("Test" + count);
            count++;
            throw new RuntimeException("File Not Found.");
        }

        return "Hello world!";
    }

    // TODO: slf4j logging
    // TODO: Rate Limit
    // TODO: NoSQL & Dynamno Calls
    // TODO: Usage of Redis Calls
    // TODO: MySQL (RDS)
}
