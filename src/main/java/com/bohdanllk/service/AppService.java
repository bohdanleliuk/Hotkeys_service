package com.bohdanllk.service;

import com.bohdanllk.dto.AppDTO;
import com.bohdanllk.dto.AppWithHotkeysDTO;

import java.util.UUID;

public interface AppService extends BaseService<AppDTO> {
    AppWithHotkeysDTO getWithHotkeys(UUID id);
}
