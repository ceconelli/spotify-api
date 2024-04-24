package com.example.services.impl;

import com.example.dtos.PlaylistRequestDTO;
import com.example.dtos.SongDTO;
import com.example.domain.ArtistEntity;
import com.example.domain.PlaylistEntity;
import com.example.domain.SongEntity;
import com.example.exceptions.NotFoundException;
import com.example.mappers.SongMapper;
import com.example.repositories.ArtistEntityRepository;
import com.example.repositories.PlaylistEntityRepository;
import com.example.repositories.SongEntityRepository;
import com.example.services.SongService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongEntityRepository songEntityRepository;
    private final ArtistEntityRepository artistEntityRepository;
    private final PlaylistEntityRepository playlistEntityRepository;
    private final SongMapper songMapper;

    @Override
    @Transactional
    public SongDTO findById(Long id) {
        return songMapper.toDTO(songEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Artist not found by id " + id)));
    }

    @Override
    @Transactional
    public Long deleteSong(Long id) {
        songEntityRepository.deleteById(id);
        return id;
    }

    @Override
    @Transactional
    public SongDTO updateSong(SongDTO songDTO) {
        SongEntity songToBeUpdated = songEntityRepository.findById(songDTO.id()).orElseThrow(
                () -> new NotFoundException("Song not found for id " + songDTO.id()));
        ArtistEntity newArtistEntity = artistEntityRepository.findById(songDTO.artistId()).orElseThrow(
                () -> new NotFoundException("Song not found for id " + songDTO.id())
        );
        songToBeUpdated.setAlbum(songDTO.album());
        songToBeUpdated.setArtist(newArtistEntity);
        songToBeUpdated.setTitle(songDTO.title());
        songToBeUpdated.setYear(songDTO.year());
        songToBeUpdated.setGenre(songDTO.genre());

        songEntityRepository.update(songToBeUpdated);
        return songMapper.toDTO(songToBeUpdated);
    }

    @Override
    @Transactional
    public SongDTO createSong(SongDTO songDTO) {
        SongEntity newSong = songEntityRepository.save(songMapper.toEntity(songDTO));
        return songMapper.toDTO(newSong);
    }

    @Override
    @Transactional
    public List<SongDTO> getAllSongs() {
        List<SongEntity> songEntities = songEntityRepository.findAll();
        return songMapper.toDTOs(songEntities);
    }
}
