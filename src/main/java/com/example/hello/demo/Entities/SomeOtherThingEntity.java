package com.example.hello.demo.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SomeOtherThingEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String thing;
}
