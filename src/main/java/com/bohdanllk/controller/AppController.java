package com.bohdanllk.controller;

import com.bohdanllk.dto.AppDTO;
import com.bohdanllk.dto.AppWithHotkeysDTO;
import com.bohdanllk.service.AppService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    //get all apps list
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppDTO> allApps() {
        return appService.getAll();
    }

    //get app by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AppDTO getApp(@PathVariable UUID id) {
        return appService.get(id);
    }

    @GetMapping(value = "/{id}/hotkeys", produces = MediaType.APPLICATION_JSON_VALUE)
    public AppWithHotkeysDTO getAppWithHotkeys(@PathVariable UUID id) {
        return appService.getWithHotkeys(id);
    }

    //create app
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createApp(@RequestBody AppDTO appDTO) {
        appService.add(appDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppDTO update(@RequestBody AppDTO AppDTO) {
        appService.update(AppDTO);
        return AppDTO;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable UUID id) {
        appService.delete(id);
    }

}
