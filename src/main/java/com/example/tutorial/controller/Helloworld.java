package com.example.tutorial.controller;

import com.example.tutorial.HelloworldService;
import com.example.tutorial.events.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Helloworld {

    @Autowired
    private HelloworldService service;

    @Autowired
    private KafkaProducer producer;

    @GetMapping(value = "/helloworld", produces = "application/json")
    public @ResponseBody String getHelloworld() {
        return service.getHello();
    }

    @GetMapping(value = "/test", produces = "application/json")
    @Transactional(timeout = 1)
    public @ResponseBody String test() {
        String message = "test";
        String topic = "test";

        producer.send(topic, message);


        return "test3";
    }
}


