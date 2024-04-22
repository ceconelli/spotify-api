package com.example.service.impl;

import com.example.dto.ArtistDTO;
import com.example.entity.ArtistEntity;
import com.example.exception.NotFoundException;
import com.example.mapper.ArtistMapper;
import com.example.repository.ArtistEntityRepository;
import com.example.service.ArtistService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistEntityRepository artistEntityRepository;
    private final ArtistMapper artistMapper;

    @Override
    @Transactional
    public ArtistDTO findById(Long id) {
        return artistMapper.toDTO(artistEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Artist not found by id " + id)));
    }

    @Override
    @Transactional
    public ArtistDTO createArtist(ArtistDTO artistDTO) {
        ArtistEntity newArtist = artistEntityRepository.save(artistMapper.toEntity(artistDTO));
        return artistMapper.toDTO(newArtist);
    }
}
