package com.bohdanllk.dto;

import java.util.UUID;

public class OsDTO {

    private UUID id;

    private String name;


    //Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Constructors
    public OsDTO() {
    }

    public OsDTO(String name) {
        this.name = name;
    }

    //Methods
    @Override
    public String toString() {
        return String.format("OS [os = %s]", name);
    }

}
