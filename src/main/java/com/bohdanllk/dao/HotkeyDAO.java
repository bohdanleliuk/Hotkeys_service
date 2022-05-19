package com.bohdanllk.dao;

import com.bohdanllk.model.Hotkey;

import java.util.List;


public interface HotkeyDAO extends BaseDAO<Hotkey> {
    void addList(List<Hotkey> hotkeyList);
}
