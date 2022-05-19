package com.bohdanllk.controller;

import com.bohdanllk.dto.ParserDTO;
import com.bohdanllk.parser.ParseHtml;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/parser")
public class ParserController {

    public final ParseHtml parseHtml;

    public ParserController(ParseHtml parseHtml) {
        this.parseHtml = parseHtml;
    }

    @PostMapping()
    public void printAll(@RequestBody ParserDTO parserDTO) throws IOException {
        parseHtml.parseToList(parserDTO);
    }
}
