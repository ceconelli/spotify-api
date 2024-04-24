package com.example.mappers;

import com.example.dtos.ArtistDTO;
import com.example.domain.ArtistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ArtistMapper {

    List<ArtistDTO> toArtistDTOList(List<ArtistEntity> artistEntities);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "artistName", source = "artistName")
    ArtistDTO toDTO(ArtistEntity artistEntity);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "artistName", source = "artistName")
    ArtistEntity toEntity(ArtistDTO artistDTO);
}
