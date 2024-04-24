package com.example.mappers;

import com.example.dtos.PlaylistDTO;
import com.example.dtos.SongDTO;
import com.example.domain.PlaylistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {SongDTO.class, PlaylistDTO.class}
)
public interface PlaylistMapper {

    PlaylistMapper MAPPER = Mappers.getMapper(PlaylistMapper.class) ;

    List<PlaylistDTO> toDTOs(List<PlaylistEntity> entities);

    PlaylistDTO toDTO(PlaylistEntity entity);

    @Mapping(target = "songs", ignore = true)
    @Mapping(target = "user.id" , source = "userId")
    PlaylistEntity toEntity(PlaylistDTO dto);

}
