package com.example.mapper;

import com.example.dto.SongDTO;
import com.example.entity.ArtistEntity;
import com.example.entity.SongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.Optional;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SongMapper {

    SongMapper MAPPER = Mappers.getMapper(SongMapper.class) ;

//    @Mapping(target = "durationInSeconds", source = "durationInSeconds")
//    @Mapping(target = "title", source = "title")
//    @Mapping(target = "artist", source = "artist")
//    @Mapping(target = "genre", source = "genre")
//    @Mapping(target = "year", source = "year")
//    @Mapping(target = "album", source = "album")
    SongDTO toDTO(SongEntity songEntity);

//    @Mapping(target = "durationInSeconds", source = "durationInSeconds")
//    @Mapping(target = "title", source = "title")
//    @Mapping(target = "artist", source = "artist")
//    @Mapping(target = "genre", source = "genre")
//    @Mapping(target = "year", source = "year")
//    @Mapping(target = "album", source = "album")
    SongEntity toEntity(SongDTO songDTO);

}
