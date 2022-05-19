package com.bohdanllk.dto;

import com.bohdanllk.model.Hotkey;

import java.util.List;
import java.util.UUID;

public class AppDTO {

    private UUID id;

    private String name;


    //Getters
    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    //Constructors
    public AppDTO() {}


    //Methods
    @Override
    public String toString() {
        return String.format("App [app = %s]", name);
    }
}
