package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "dog")
public class Dog {

    @Id                                                     //ustawia wartosc niżej jako primery key
    @GeneratedValue (strategy = GenerationType.IDENTITY)    //to jest auto_increment
    Long id;
    String name;
    Integer age;
    String race;

    public Dog(String name, Integer age, String race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }
}
