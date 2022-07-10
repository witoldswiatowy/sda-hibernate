package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany
    @JoinTable( //tym możemy zmienić nazwę tabeli pośredniczącej, ale nie musimy tego robić
            name = "student_school_inna_nazwa",
            joinColumns = @JoinColumn(name = "student_id_2_inna_nazwa"),
            inverseJoinColumns = @JoinColumn(name = "school_id_2_inna_nazwa")
    )
    Set<School> schools = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public void addSchool(School school) {
        this.schools.add(school);
    }
}