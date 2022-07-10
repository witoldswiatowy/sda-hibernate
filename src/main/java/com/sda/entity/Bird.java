package com.sda.entity;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Bird {

    @Id
    @GeneratedValue
    UUID id;
    String name;

    public Bird(String name) {
        this.name = name;
    }
}
