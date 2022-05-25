package com.bohdanllk.dto;

import java.util.List;

public class ParserDTO {
    private String url;
    private List<String> osList;
    private String appId;

    private boolean reverseFields;

    public boolean isReverseFields() {
        return reverseFields;
    }

    public void setReverseFields(boolean reverseFields) {
        this.reverseFields = reverseFields;
    }

    public ParserDTO() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getOsList() {
        return osList;
    }

    public void setOsList(List<String> osList) {
        this.osList = osList;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
