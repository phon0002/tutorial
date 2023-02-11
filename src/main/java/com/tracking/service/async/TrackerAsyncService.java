package com.tracking.service.async;

import com.tracking.service.TrackerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class TrackerAsyncService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TrackerAsyncService.class);

   @Autowired
   private TrackerService service;

   @Override
    public void run(String... args) throws Exception {
        // Start the clock
       long start = System.currentTimeMillis();

       // Kick of multiple, asynchronous lookups
       CompletableFuture<String> user1 = service.getTrack("user 1");
       CompletableFuture<String> user2 = service.getTrack("user 2");

       // Wait until they are all done
       CompletableFuture.allOf(user1, user2).join();

       // Print results, including elapsed time
       log.info("Elapsed time: " + (System.currentTimeMillis() - start));
       System.err.println(user1.get());
       log.info("--> " + user1.get());
       log.info("--> " + user2.get());
    }

}
