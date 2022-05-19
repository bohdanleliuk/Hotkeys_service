package com.bohdanllk.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.bohdanllk.dto.AppDTO;
import com.bohdanllk.dto.HotkeyDTO;
import com.bohdanllk.dto.OsDTO;
import com.bohdanllk.dto.ParserDTO;
import com.bohdanllk.model.App;
import com.bohdanllk.model.Hotkey;
import com.bohdanllk.model.Os;
import com.bohdanllk.service.*;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class ParseHtml {
    private final OsService osService;
    private final AppService appService;
    private final HotkeyService hotkeyService;

    public ParseHtml(OsService osService, AppService appService, HotkeyService hotkeyService) {
        this.osService = osService;
        this.appService = appService;
        this.hotkeyService = hotkeyService;
    }

    private final Integer COLUMN_SIZE = 3;

    public List<Hotkey> parseToList(ParserDTO parserDTO) throws IOException {
        String page = parserDTO.getPage();
        OsDTO osDTO1 = osService.get(UUID.fromString(parserDTO.getOs1Id()));
        OsDTO osDTO2 = osService.get(UUID.fromString(parserDTO.getOs2Id()));
        AppDTO appDTO = appService.get(UUID.fromString(parserDTO.getAppId()));

        List<String> result = new ArrayList<String>();
        org.jsoup.nodes.Document doc = Jsoup.connect(page).get();
        org.jsoup.select.Elements tables = doc.select("tbody");
        for (org.jsoup.nodes.Element table : tables) {
            org.jsoup.select.Elements rows = doc.select("tr");
            for (org.jsoup.nodes.Element row : rows) {
                org.jsoup.select.Elements columns = row.select("td");
                for (org.jsoup.nodes.Element column : columns) {
                    if (column.text() != null && columns.size() == COLUMN_SIZE) {
                        result.add(column.text());
                    }
                }
            }
            break;
        }

        List<HotkeyDTO> hotkeyList = new ArrayList<>();

        for (int i = 0; i < result.size(); i = i + 3) {
            HotkeyDTO hotkey1 = new HotkeyDTO();
            HotkeyDTO hotkey2 = new HotkeyDTO();

            hotkey1.setDescription(result.get(i));
            hotkey2.setDescription(result.get(i));

            hotkey1.setCombination(result.get(i + 1));
            hotkey2.setCombination(result.get(i + 2));

            hotkey1.setOs(osDTO1);
            hotkey2.setOs(osDTO2);

            hotkey1.setApp(appDTO);
            hotkey2.setApp(appDTO);

            hotkeyList.add(hotkey1);
            hotkeyList.add(hotkey2);
        }

        hotkeyService.addList(hotkeyList);

        return null;
    }
}
