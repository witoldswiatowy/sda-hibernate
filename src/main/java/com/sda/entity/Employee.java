package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_table")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    Long id;
    @Column(nullable = false)
    String name;
    @Column(name = "password")
    String secret;
    @Column(length = 9, unique = true)
    String telephoneNumber; //telephone_number
    @Transient
    Long age;
    @Temporal(TemporalType.DATE)
    Date birthDate;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Lob
    String description;
    @Embedded
    Address address;

    public Employee(String name, String secret, String telephoneNumber, Long age, Date birthDate, Gender gender, String description) {
        this.name = name;
        this.secret = secret;
        this.telephoneNumber = telephoneNumber;
        this.age = age;
        this.birthDate = birthDate;
        this.gender = gender;
        this.description = description;
    }
}
