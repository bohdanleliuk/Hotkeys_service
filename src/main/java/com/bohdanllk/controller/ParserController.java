package com.bohdanllk.controller;

import com.bohdanllk.dto.ParserDTO;
import com.bohdanllk.parser.ParseHtml;
import com.bohdanllk.service.HotkeyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/parser")
public class ParserController {

    private final ParseHtml parseHtml;

    private final HotkeyService hotkeyService;

    public ParserController(ParseHtml parseHtml, HotkeyService hotkeyService) {
        this.parseHtml = parseHtml;
        this.hotkeyService = hotkeyService;
    }

    @PostMapping()
    public void printAll(@RequestBody ParserDTO parserDTO) throws IOException {
        hotkeyService.addList(parseHtml.parseListHotkey(parserDTO));
    }
}
