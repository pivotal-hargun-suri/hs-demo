package com.example.hello.demo.controllers;

import com.example.hello.demo.models.Something;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    private Something something = new Something();

    @RequestMapping("/")
    public Something Something() {
        return something;
    }
}
