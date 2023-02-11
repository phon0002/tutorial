package com.tracking.controller;

import com.tracking.client.GreetingClient;
import com.tracking.service.TrackerService;
import com.tracking.events.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
@AllArgsConstructor
public class TrackerController {

    @Autowired
    private TrackerService service;
    @Autowired
    private KafkaProducer producer;

    @Autowired
    private GreetingClient client;

    @GetMapping(value = "/helloworld", produces = "application/json")
    public @ResponseBody String getHelloworld() {
        return service.getHello();
    }

    @GetMapping(value = "/helloworld2", produces = "application/json")
    public ResponseEntity getHelloworld2() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.just("test"));
    }
    @GetMapping(value = "/test", produces = "application/json")
    @Transactional(timeout = 1)
    public @ResponseBody String test() {
        producer.send("test", "test");

        return "test3";
    }
}