package com.example.service.impl;

import com.example.dto.ArtistDTO;
import com.example.dto.SongDTO;
import com.example.entity.ArtistEntity;
import com.example.entity.SongEntity;
import com.example.exception.NotFoundException;
import com.example.mapper.ArtistMapper;
import com.example.mapper.SongMapper;
import com.example.repository.ArtistEntityRepository;
import com.example.repository.SongEntityRepository;
import com.example.service.ArtistService;
import com.example.service.SongService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongEntityRepository songEntityRepository;
    private final ArtistEntityRepository artistEntityRepository;
    private final SongMapper songMapper;

    @Override
    @Transactional
    public SongDTO findById(Long id) {
        return songMapper.toDTO(songEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Artist not found by id " + id)));
    }

    @Override
    @Transactional
    public SongDTO createSong(SongDTO songDTO) {
        SongEntity newSong = songEntityRepository.save(songMapper.toEntity(songDTO));
        return songMapper.toDTO(newSong);
    }
}
