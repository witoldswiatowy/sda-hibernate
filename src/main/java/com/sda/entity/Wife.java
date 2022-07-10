package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "wife")
@Setter
@Getter
@NoArgsConstructor
public class Wife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String name;
    @OneToOne(mappedBy = "wife")
    Husband husband;

    public Wife(String name) {
        this.name = name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
        this.husband.setWife(this);
    }
}
