package com.bohdanllk.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "os")
public class Os {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @NotNull(message = "os name should be not null!")
    @Size(max = 30, message = "Max size of os name is 30!")
    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "os", targetEntity=Hotkey.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hotkey> hotkeys;


    //Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Hotkey> getHotkeys() {
        return hotkeys;
    }


    //Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHotkeys(List<Hotkey> hotkeys) {
        this.hotkeys = hotkeys;
    }


    //Constructors
    public Os() {
    }

    public Os(String name) {
        this.name = name;
    }

    public Os(String name, List<Hotkey> hotkeys) {
        this.name = name;
        this.hotkeys = hotkeys;
    }


    //Methods
    @Override
    public String toString() {
        return String.format("OS [os = %s]", name);
    }
}
