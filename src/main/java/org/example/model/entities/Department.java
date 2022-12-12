package org.example.model.entities;


import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private  Integer id;
    private String name;

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
