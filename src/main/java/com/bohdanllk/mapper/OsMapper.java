package com.bohdanllk.mapper;

import com.bohdanllk.dto.OsDTO;
import com.bohdanllk.model.Os;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OsMapper {

    OsMapper INSTANCE = Mappers.getMapper(OsMapper.class);

    OsDTO osToDTO(Os os);

    Os dtoToOs(OsDTO osDTO);

    List<OsDTO> osListToDTO(List<Os> osList);

}
