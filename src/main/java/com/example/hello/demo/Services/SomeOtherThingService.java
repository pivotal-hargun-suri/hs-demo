package com.example.hello.demo.Services;

import com.example.hello.demo.models.SomeOtherThing;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SomeOtherThingService {
    public List<SomeOtherThing> getAllSomeOtherThing();
    public void setSomeOtherThing();
    public SomeOtherThing getSomeOtherThingById(Integer id);
}