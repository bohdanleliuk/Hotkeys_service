package com.bohdanllk.mapper;

import com.bohdanllk.dto.HotkeyDTO;
import com.bohdanllk.model.Hotkey;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotkeyMapper {

    HotkeyDTO hotkeyToDTO(Hotkey hotkey);

    Hotkey dtoToHotkey(HotkeyDTO hotkeyDTO);

    List<HotkeyDTO> hotkeyListToDTO(List<Hotkey> hotkeyList);

    List<Hotkey> dtoToHotkeyList(List<HotkeyDTO> hotkeyDTOList);

}
