package com.bohdanllk;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "os")
public class Os {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;


    @Column(name = "name")
    private String name;


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Os(String name) {
        this.name = name;
    }

    public Os() {
    }

    @Override
    public String toString() {
        return String.format("OS [id = %s, name = %s]", id.toString(), name);
    }
}
