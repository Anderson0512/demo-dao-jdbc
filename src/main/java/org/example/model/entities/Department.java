package org.example.model.entities;


import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class Departments {
    private  Integer id;
    private String name;

    public Departments(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
