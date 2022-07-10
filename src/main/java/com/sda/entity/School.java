package com.sda.entity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "school")
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany(mappedBy = "schools", cascade = CascadeType.PERSIST) //a ten "cascade = ..." może być tu lub tu, albo i tu i tu,
                                                                    // tylko wtedy pilnujemy na czym robimy persist
    Set<Student> students = new HashSet<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent (Student student) {
        students.add(student);
        student.addSchool(this); //to zawsze musi być po stronie NIE_WŁAŚCICIELA relacji
    }
}
