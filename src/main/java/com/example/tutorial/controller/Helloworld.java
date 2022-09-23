package com.example.tutorial.controller;

import com.example.tutorial.HelloworldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @Autowired
    private HelloworldService service;

    @GetMapping(value = "/helloworld", produces = "application/json")
    public @ResponseBody String getHelloworld() {
        return service.getHello();
    }

    @GetMapping(value = "/test", produces = "application/json")
    public @ResponseBody String test() {
        return "test3";
    }
}


