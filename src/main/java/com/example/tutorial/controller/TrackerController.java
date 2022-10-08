package com.example.tutorial.controller;

import com.example.tutorial.service.TrackerService;
import com.example.tutorial.events.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TrackerController {

    private TrackerService service;
    private KafkaProducer producer;

    @GetMapping(value = "/helloworld", produces = "application/json")
    public @ResponseBody String getHelloworld() {
        return service.getHello();
    }

    @GetMapping(value = "/test", produces = "application/json")
    @Transactional(timeout = 1)
    public @ResponseBody String test() {
        producer.send("test", "test");

        return "test3";
    }
}


