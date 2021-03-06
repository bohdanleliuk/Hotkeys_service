package com.bohdanllk.mapper;

import com.bohdanllk.dto.AppDTO;
import com.bohdanllk.dto.AppWithHotkeysDTO;
import com.bohdanllk.model.App;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppMapper {

    AppDTO appToDTO(App app);

    App dtoToApp(AppDTO appDTO);

    AppWithHotkeysDTO appToDTOWithHotkeys(App app);

    //Lists
    List<AppWithHotkeysDTO> appListToDTOWithHotkeys(List<App> appList);

    List<AppDTO> appListToDTO(List<App> appList);

}
