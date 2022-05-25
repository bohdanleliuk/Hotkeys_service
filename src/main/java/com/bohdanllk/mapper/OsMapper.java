package com.bohdanllk.mapper;

import com.bohdanllk.dto.OsDTO;
import com.bohdanllk.model.Os;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OsMapper {

    OsDTO osToDTO(Os os);

    Os dtoToOs(OsDTO osDTO);

    List<OsDTO> osListToDTO(List<Os> osList);

}
