package com.tracking.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TrackerService {

    private static int count = 0;

    @Cacheable(value = "trackCache")
    public List<String> getTrack(){
        return null;
    }
    @Retry(name = "hello-retry")
    public String getHello() {
        if (count < 5) {
            log.error("Test" + count);
            count++;
            throw new RuntimeException("File Not Found.");
        }

        return "Hello world!";
    }

    // TODO: Rate Limit
    // TODO: NoSQL & Dynamno Calls
    // TODO: Usage of Redis Calls
    // TODO: Map MySQL (RDS)
    // TODO: Use NonBlocking
}
