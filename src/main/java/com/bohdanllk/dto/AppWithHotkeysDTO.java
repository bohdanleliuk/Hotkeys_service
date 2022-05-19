package com.bohdanllk.dto;

import com.bohdanllk.model.Hotkey;

import java.util.List;
import java.util.UUID;

public class AppWithHotkeysDTO {
    private UUID id;

    private String name;

    private List<HotkeyDTO> hotkeys;


    //Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<HotkeyDTO> getHotkeys() {
        return hotkeys;
    }

    //Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHotkeys(List<HotkeyDTO> hotkeys) {
        this.hotkeys = hotkeys;
    }

    //Constructors
    public AppWithHotkeysDTO() {}


    //Methods
    @Override
    public String toString() {
        return String.format("App [app = %s]", name);
    }

}
