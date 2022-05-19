package com.bohdanllk.service;

import com.bohdanllk.dto.HotkeyDTO;
import com.bohdanllk.model.Hotkey;

import java.util.List;

public interface HotkeyService extends BaseService<HotkeyDTO> {
    void addList(List<HotkeyDTO> hotkeyDTO);
}
