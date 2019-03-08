package com.example.hello.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Something {

    private long id;
    private String message;

//    public Something() {
//        this.id = 1;
//        this.message = "Something";
//    }
}
