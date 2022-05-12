package com.bohdanllk.controller;

import com.bohdanllk.model.App;
import com.bohdanllk.model.Hotkey;
import com.bohdanllk.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class HotkeyController {

    @Autowired
    private AppService appService;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/apps")
    public ResponseEntity<List<App>> allApps() {
        List<App> appList = appService.getAll();
        return ResponseEntity.ok().body(appList);
    }

    @GetMapping("/app")
    public ResponseEntity<App> allHotkeys() {
        App app = appService.get(UUID.fromString("5ee8b114-048a-4967-8b4c-64d7d2f38577"));
        return ResponseEntity.ok().body(app);
    }
}
