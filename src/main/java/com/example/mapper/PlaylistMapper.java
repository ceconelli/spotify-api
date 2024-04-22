package com.example.mapper;

import com.example.dto.PlaylistDTO;
import com.example.dto.SongDTO;
import com.example.entity.PlaylistEntity;
import com.example.entity.SongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {SongDTO.class, PlaylistDTO.class}
)
public interface PlaylistMapper {

    PlaylistMapper MAPPER = Mappers.getMapper(PlaylistMapper.class) ;

    PlaylistDTO toDTO(PlaylistEntity entity) ;

    @Mapping(target = "songs", ignore = true)
    @Mapping(target = "user.id" , source = "userId")
    PlaylistEntity toEntity(PlaylistDTO dto) ;

}
