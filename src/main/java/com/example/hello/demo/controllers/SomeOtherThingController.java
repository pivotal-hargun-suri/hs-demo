package com.example.hello.demo.controllers;

import com.example.hello.demo.Services.SomeOtherThingService;
import com.example.hello.demo.models.SomeOtherThing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sot")
public class SomeOtherThingController {

    @Autowired
    private SomeOtherThingService someOtherThingService;

    @GetMapping
    public List<SomeOtherThing> getSomeOtherThings() {
        return someOtherThingService.getAllSomeOtherThing();
    }

    @PostMapping
    public void postSomeOtherThings() {
        someOtherThingService.setSomeOtherThing();
    }

    @GetMapping("/{id}")
    public SomeOtherThing getSomeOtherThingById(@PathVariable("id") Integer id) {
        return someOtherThingService.getSomeOtherThingById(id);
    }
}
