package com.bohdanllk.parser;

import com.bohdanllk.dto.AppDTO;
import com.bohdanllk.dto.HotkeyDTO;
import com.bohdanllk.dto.OsDTO;
import com.bohdanllk.dto.ParserDTO;
import com.bohdanllk.exception.ParserException;
import com.bohdanllk.service.AppService;
import com.bohdanllk.service.HotkeyService;
import com.bohdanllk.service.OsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParseHtml {
    private final OsService osService;
    private final AppService appService;

    public ParseHtml(OsService osService, AppService appService, HotkeyService hotkeyService) {
        this.osService = osService;
        this.appService = appService;
    }

    //Parse List of Hotkey from first table on url from parserDTO
    public List<HotkeyDTO> parseListHotkey(ParserDTO parserDTO) {
        String url = Optional.ofNullable(parserDTO.getUrl()).orElseThrow(() -> new ParserException("url can't be null"));

        Optional.ofNullable(parserDTO.getOsList()).orElseThrow(() -> new ParserException("osList can't be null"));
        List<OsDTO> osList = parserDTO.getOsList().stream().map(x -> osService.get(UUID.fromString(x))).toList();

        UUID appId = Optional.ofNullable(parserDTO.getAppId())
                .map(x -> UUID.fromString(x))
                .orElseThrow(() -> new ParserException("app_id can't be null"));
        AppDTO appDTO = appService.get(appId);


        List<String> parseList = null;
        Integer columnSize = osList.size() + 1;
        try {
            parseList = parseListFromURL(url, columnSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean reverseFields = parserDTO.isReverseFields();

        return convertToHotkeyList(parseList, osList, appDTO, reverseFields);
    }


    //Parse List of String from first table on url from parserDTO
    private List<String> parseListFromURL(String url, Integer columnSize) throws IOException {

        List<String> result = new ArrayList<String>();
        Document doc = Jsoup.connect(url).get();
        Elements tables = doc.select("tbody");
        Elements rows = tables.get(0).select("tr");
        for (Element row : rows) {
            Elements columns = row.select("td");
            for (Element column : columns) {
                if (column.text() != null && columns.size() == columnSize) {
                    result.add(column.text());
                }
            }
        }
        return result;
    }

    //Convert List of String to List of Hotkeys
    private List<HotkeyDTO> convertToHotkeyList(List<String> parseList, List<OsDTO> osList, AppDTO appDTO, boolean reverseFields) {

        List<HotkeyDTO> hotkeyList = new ArrayList<>();

        Integer columnSize = osList.size() + 1;

        for (int i = 0; i < parseList.size(); i += columnSize) {
            for (int j = 0; j < osList.size(); j++) {
                HotkeyDTO hotkey = new HotkeyDTO();
                hotkey.setApp(appDTO);
                hotkey.setOs(osList.get(j));
                if (!reverseFields) {
                    hotkey.setDescription(parseList.get(i));
                    hotkey.setCombination(parseList.get(i + 1 + j));
                } else {
                    hotkey.setDescription(parseList.get(i + columnSize - 1));
                    hotkey.setCombination(parseList.get(i + j));
                }
                hotkeyList.add(hotkey);
            }

        }
        return hotkeyList;
    }
}
