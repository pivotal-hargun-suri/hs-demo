package com.example.hello.demo.Repositories;

import com.example.hello.demo.Entities.SomeOtherThingEntity;
import com.example.hello.demo.models.SomeOtherThing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SomeOtherThingReposiory extends JpaRepository<SomeOtherThingEntity, Integer> {
    public Optional<SomeOtherThingEntity> findByName(String name);
}