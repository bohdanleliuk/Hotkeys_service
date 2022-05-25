package com.bohdanllk.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"combination", "app_id", "os_id" }) })
public class Hotkey {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;


    @NotNull(message = "hotkey combination should be not null!")
    @Column(name = "combination")
    private String combination;

    @NotNull(message = "hotkey description should be not null!")
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name="app_id")
    private App app;

    @NotNull
    @ManyToOne
    @JoinColumn(name="os_id")
    private Os os;


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

    public App getApp() {
        return app;
    }

    public Os getOs() {return os;}


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

    public void setApp(App app) {
        this.app = app;
    }

    public void setOs(Os os) {this.os = os;}


    //Constructors
    public Hotkey() {
    }

    public Hotkey(String combination, String description) {
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
