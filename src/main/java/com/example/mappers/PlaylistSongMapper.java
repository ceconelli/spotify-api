package com.example.mappers;

import com.example.domain.PlaylistEntity;
import com.example.domain.PlaylistSongEntity;
import com.example.dtos.PlaylistDTO;
import com.example.dtos.PlaylistSongDTO;
import com.example.dtos.SongDTO;
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
public interface PlaylistSongMapper {

    PlaylistSongMapper MAPPER = Mappers.getMapper(PlaylistSongMapper.class) ;

    List<PlaylistSongDTO> toPlaylistSongDTOList(List<PlaylistSongEntity> playlistSongEntities);

    @Mapping(target = "title", source = "song.title")
    @Mapping(target = "artistName", source = "song.artist.artistName")
    @Mapping(target = "album", source = "song.album")
    PlaylistSongDTO toPlaylistSongDTO(PlaylistSongEntity playlistSongEntity);

}
