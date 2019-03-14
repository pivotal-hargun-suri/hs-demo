package com.example.hello.demo.controllers;

import com.example.hello.demo.models.Something;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class RootController {
    private Something something = new Something();
    @Value("${current-profile}") String profile;

    @RequestMapping("/")
    public Something Something() {
        something.setMessage("Profile set: " + profile);
        return something;
    }
}
