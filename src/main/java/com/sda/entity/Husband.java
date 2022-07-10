package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "husband")
@Setter
@Getter
@NoArgsConstructor
public class Husband {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String name;
    @OneToOne
    Wife wife;

    public Husband(String name) {
        this.name = name;
    }
}
