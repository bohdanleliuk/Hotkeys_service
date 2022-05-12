package com.bohdanllk.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;

public class ParseHtml {


    public List<String> parseToList(String page) throws IOException {
        List<String> result = new ArrayList<String>();
        org.jsoup.nodes.Document doc = Jsoup.connect(page).get();
        org.jsoup.select.Elements rows = doc.select("tr");
        for(org.jsoup.nodes.Element row :rows)
        {
            org.jsoup.select.Elements columns = row.select("td");
            for (org.jsoup.nodes.Element column : columns)
            {
                if (columns.size() != 3) continue;
                if (column.text() != null) {
                    result.add(column.text());
                }
            }
        }
        return result;
    }

    public void addParseHotkeysToDataBase(List<String> parseList, String os1, String os2, String app) {
        OsServiceImpl hs = new OsServiceImpl();
        List<String> descriptions = new ArrayList<>();
        List<String> combinationOs1 = new ArrayList<>();
        List<String> combinationOs2 = new ArrayList<>();

        for (int i = 0; i < parseList.size(); i++) {
            if ((i + 3) % 3 == 0) {
                descriptions.add(parseList.get(i));
            } else if ( (i + 3) % 3 == 1) {
                combinationOs1.add(parseList.get(i));
            } else if (((i + 3) % 3 == 2)) {
                combinationOs2.add(parseList.get(i));
            }
        }

        for (int i = 0; i < descriptions.size(); i++) {
            System.out.println(i + " " + descriptions.get(i));
            System.out.println(i + " " + combinationOs1.get(i));
            System.out.println(i + " " + combinationOs2.get(i));
        }
    }

}
