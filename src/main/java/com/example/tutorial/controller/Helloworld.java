package com.example.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @GetMapping(value = "/helloworld", produces = "application/json")
    public @ResponseBody String getHelloworld() {
        return "Hello Wrold";
    }
}


