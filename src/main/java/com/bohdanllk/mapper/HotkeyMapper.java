package com.bohdanllk.mapper;

import com.bohdanllk.dto.AppDTO;
import com.bohdanllk.dto.HotkeyDTO;
import com.bohdanllk.dto.OsDTO;
import com.bohdanllk.model.App;
import com.bohdanllk.model.Hotkey;
import com.bohdanllk.model.Os;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface HotkeyMapper {

    HotkeyMapper INSTANCE = Mappers.getMapper(HotkeyMapper.class);

    HotkeyDTO hotkeyToDTO(Hotkey hotkey);

    Hotkey dtoToHotkey(HotkeyDTO hotkeyDTO);

    List<HotkeyDTO> hotkeyListToDTO(List<Hotkey> hotkeyList);

    List<Hotkey> dtoToHotkeyList(List<HotkeyDTO> hotkeyDTOList);

}
