package com.example.mapper;

import com.example.dto.PlaylistDTO;
import com.example.dto.PlaylistSongDTO;
import com.example.dto.SongDTO;
import com.example.entity.PlaylistEntity;
import com.example.entity.PlaylistSongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PlaylistSongMapper {

    PlaylistSongMapper MAPPER = Mappers.getMapper(PlaylistSongMapper.class) ;

    PlaylistSongDTO toDTO(PlaylistSongEntity entity) ;

    @Mapping(target = "playlistEntity.id", source = "playlistId")
    @Mapping(target = "songEntity.id", source = "songId")
    PlaylistSongEntity toEntity(PlaylistSongDTO dto) ;

}
