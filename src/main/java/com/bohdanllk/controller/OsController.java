package com.bohdanllk.controller;

import com.bohdanllk.dto.OsDTO;
import com.bohdanllk.service.OsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/os")
public class OsController {

    private final OsService osService;

    public OsController(OsService osService) {
        this.osService = osService;
    }

    //get all oses list
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OsDTO> all() {
        return osService.getAll();
    }

    //get os by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OsDTO get(@PathVariable UUID id) {
        return osService.get(id);
    }

    //create os
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody OsDTO osDTO) {
        osService.add(osDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OsDTO update(@RequestBody OsDTO osDTO) {
        osService.update(osDTO);
        return osDTO;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable UUID id) {
        osService.delete(id);
    }
}
