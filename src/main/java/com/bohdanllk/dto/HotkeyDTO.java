package com.bohdanllk.dto;

import com.bohdanllk.model.App;
import com.bohdanllk.model.Os;

import javax.persistence.*;
import java.util.UUID;

public class HotkeyDTO {

    private UUID id;

    private String combination;

    private String description;

    private AppDTO app;

    private OsDTO os;


    //Getters
    public UUID getId() {
        return id;
    }

    public String getCombination() {
        return combination;
    }

    public String getDescription() {
        return description;
    }

    public AppDTO getApp() {
        return app;
    }

    public OsDTO getOs() {
        return os;
    }


    //Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setCombination(String combination) {
        this.combination = combination;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setApp(AppDTO app) {
        this.app = app;
    }

    public void setOs(OsDTO os) {
        this.os = os;
    }

    //Constructors
    public HotkeyDTO() {
    }

    public HotkeyDTO(String combination, String description) {
        this.combination = combination;
        this.description = description;
    }

    //Methods
    @Override
    public String toString() {
        String str = os.toString() + " " + app.toString();
        return String.format(str + " Hotkey [combination = %s, description = %s]", combination.toString(), description.toString());
    }
}
