package com.tracking.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
public class TrackerService {

    private static int count = 0;

    @Cacheable(value = "trackCache")
    public List<String> getTrack() {
        return null;
    }

    @Async
    public CompletableFuture<String> getTrack(String user) throws InterruptedException {
        Thread.sleep(1000L);
        // Artificial delay of 1s for demonstration purposes
        return CompletableFuture.completedFuture(user + " wait Time.");
    }

    @Retry(name = "hello-retry")
    public String getHello() {
        //if (count < 5) {
        //    log.error("Test" + count);
         //   count++;
          //  throw new RuntimeException("File Not Found.");
        //}

        return "Hello world!";
    }

    // TODO: Rate Limit
    // TODO: NoSQL & Dynamno Calls
    // TODO: Usage of Redis Calls
    // TODO: Map MySQL (RDS)
    // TODO: Use NonBlocking - Mono & Reactive
    // TODO: Lombok builder example
    // TODO: Concurrent and Async
}
