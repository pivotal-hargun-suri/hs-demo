package com.example.hello.demo.Services;

import com.example.hello.demo.Entities.SomeOtherThingEntity;
import com.example.hello.demo.Repositories.SomeOtherThingReposiory;
import com.example.hello.demo.models.SomeOtherThing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SomeOtherThingServiceImpl implements SomeOtherThingService {

    @Autowired
    private SomeOtherThingReposiory someOtherThingReposiory;

    public List<SomeOtherThing> getAllSomeOtherThing() {
        List<SomeOtherThing> someOtherThings = new ArrayList<SomeOtherThing>();
        someOtherThingReposiory.findAll().forEach(someOtherThingEntity -> {
            someOtherThings.add(new SomeOtherThing(((SomeOtherThingEntity)someOtherThingEntity).getName(),
                                                    ((SomeOtherThingEntity)someOtherThingEntity).getThing())); });
        return someOtherThings;
    }

    public void setSomeOtherThing() {
        SomeOtherThingEntity someOtherThingEntity = new SomeOtherThingEntity();
        someOtherThingEntity.setName("Some Name");
        someOtherThingEntity.setThing("Some Thing");
        someOtherThingReposiory.save(someOtherThingEntity);
    }


    public SomeOtherThing getSomeOtherThingById(Integer id) {
        SomeOtherThing someOtherThing = new SomeOtherThing();
        someOtherThingReposiory.findById(id).ifPresent(someOtherThingEntity -> {
            someOtherThing.setName(someOtherThingEntity.getName());
            someOtherThing.setThing(someOtherThingEntity.getThing()); });

        return someOtherThing;
    }
}