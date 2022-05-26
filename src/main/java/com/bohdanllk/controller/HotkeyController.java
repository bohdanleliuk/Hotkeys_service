package com.bohdanllk.controller;

import com.bohdanllk.dto.HotkeyDTO;
import com.bohdanllk.service.HotkeyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/hotkey")
public class HotkeyController {

    private final HotkeyService hotkeyService;

    public HotkeyController(HotkeyService hotkeyService) {
        this.hotkeyService = hotkeyService;
    }

    //get all hotkeys list
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotkeyDTO> allHotkey() {
        return hotkeyService.getAll();
    }

    //get hotkey by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HotkeyDTO getHotkey(@PathVariable UUID id) {
        return hotkeyService.get(id);
    }

    //create hotkey
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createHotkey(@RequestBody HotkeyDTO hotkeyDTO) {
        hotkeyService.add(hotkeyDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HotkeyDTO update(@RequestBody HotkeyDTO hotkeyDTO) {
        hotkeyService.update(hotkeyDTO);
        return hotkeyDTO;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable UUID id) {
        hotkeyService.delete(id);
    }
}
