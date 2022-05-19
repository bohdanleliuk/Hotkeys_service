package com.bohdanllk.dto;

import com.bohdanllk.model.App;
import com.bohdanllk.model.Os;

import java.util.UUID;

public class ParserDTO {
    private String page;
    private String os1Id;
    private String os2Id;
    private String appId;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getOs1Id() {
        return os1Id;
    }

    public void setOs1Id(String os1Id) {
        this.os1Id = os1Id;
    }

    public String getOs2Id() {
        return os2Id;
    }

    public void setOs2Id(String os2Id) {
        this.os2Id = os2Id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public ParserDTO() {
    }

    public ParserDTO(String page, String os1Id, String os2Id, String appId) {
        this.page = page;
        this.os1Id = os1Id;
        this.os2Id = os2Id;
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "ParserDTO{" +
                "page='" + page + '\'' +
                ", os1Id='" + os1Id + '\'' +
                ", os2Id='" + os2Id + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }
}
