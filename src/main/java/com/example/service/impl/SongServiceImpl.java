package com.example.service.impl;

import com.example.dto.AddSongToPlaylistDTO;
import com.example.dto.ArtistDTO;
import com.example.dto.SongDTO;
import com.example.entity.ArtistEntity;
import com.example.entity.PlaylistEntity;
import com.example.entity.SongEntity;
import com.example.exception.NotFoundException;
import com.example.mapper.ArtistMapper;
import com.example.mapper.SongMapper;
import com.example.repository.ArtistEntityRepository;
import com.example.repository.PlaylistEntityRepository;
import com.example.repository.SongEntityRepository;
import com.example.service.ArtistService;
import com.example.service.SongService;
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

    @Override
    @Transactional
    public Long addSongToPlaylist(AddSongToPlaylistDTO songToPlaylistDTO) {
        SongEntity songEntity = songEntityRepository.findById(songToPlaylistDTO.songId()).orElseThrow(
                () -> new NotFoundException("Song not found for id " + songToPlaylistDTO.songId())
        );

        PlaylistEntity playlistEntity = playlistEntityRepository.findById(songToPlaylistDTO.playlistId()).orElseThrow(
                () -> new NotFoundException("Playlist not found for id " + songToPlaylistDTO.playlistId())
        );

        playlistEntity.getSongs().add(songEntity);
        playlistEntityRepository.save(playlistEntity);
        return songEntity.getId();
    }
}
