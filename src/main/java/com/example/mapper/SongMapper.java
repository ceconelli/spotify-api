package com.example.mapper;

import com.example.dto.SongDTO;
import com.example.entity.SongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SongMapper {

    SongMapper MAPPER = Mappers.getMapper(SongMapper.class) ;

    List<SongDTO> toDTOs(List<SongEntity> songEntities);

    SongDTO toDTO(SongEntity songEntity);

    @Mapping(target = "artist.id", source = "artistId")
    SongEntity toEntity(SongDTO songDTO);

}
