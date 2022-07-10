package com.sda.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Tiger { //ale lepiej używąć natywnych rozwiązan, tego nie

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "myTabGen")
    @TableGenerator(name = "myTabGen", table = "table_id", allocationSize = 10)
    Long id;
    String name;

    public Tiger(String name) {
        this.name = name;
    }

}
