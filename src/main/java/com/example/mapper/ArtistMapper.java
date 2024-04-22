package com.example.mapper;

import com.example.dto.ArtistDTO;
import com.example.entity.ArtistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ArtistMapper {

    @Mapping(target = "description", source = "description")
    @Mapping(target = "artistName", source = "artistName")
    ArtistDTO toDTO(ArtistEntity artistEntity);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "artistName", source = "artistName")
    ArtistEntity toEntity(ArtistDTO artistDTO);
}
