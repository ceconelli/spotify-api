package com.example.services.impl;

import com.example.domain.*;
import com.example.dtos.PlaylistDTO;
import com.example.dtos.PlaylistSongDTO;
import com.example.dtos.SongDTO;
import com.example.dtos.PlaylistRequestDTO;
import com.example.exceptions.NotFoundException;
import com.example.mappers.PlaylistMapper;
import com.example.mappers.PlaylistSongMapper;
import com.example.mappers.SongMapper;
import com.example.repositories.PlaylistEntityRepository;
import com.example.repositories.PlaylistSongEntityRepository;
import com.example.repositories.SongEntityRepository;
import com.example.repositories.UserEntityRepository;
import com.example.services.PlaylistService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Singleton
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistEntityRepository playlistEntityRepository;
    private final UserEntityRepository userEntityRepository;
    private final PlaylistSongEntityRepository playlistSongEntityRepository;
    private final SongEntityRepository songEntityRepository;
    private final PlaylistMapper playlistMapper;
    private final PlaylistSongMapper playlistSongMapper;

    @Override
    @Transactional
    public PlaylistDTO findById(Long id) {
        return playlistMapper.toDTO(playlistEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Playlist not found by id " + id)));
    }

    @Override
    @Transactional
    public PlaylistDTO createPlaylist(PlaylistDTO playlistDTO) {
        UserEntity user = userEntityRepository.findById(playlistDTO.userId()).orElseThrow(
                () -> new NotFoundException("User not found for id " + playlistDTO.userId())
        );
        PlaylistEntity newPlaylist = playlistEntityRepository.save(playlistMapper.toEntity(playlistDTO));
        return playlistMapper.toDTO(newPlaylist);
    }

    @Override
    @Transactional
    public Long deletePlaylist(Long id) {
        playlistEntityRepository.deleteById(id);
        return id;
    }

    @Override
    @Transactional
    public List<PlaylistDTO> getAllPlaylists() {
        List<PlaylistEntity> allPlaylists =  playlistEntityRepository.findAll();
        return playlistMapper.toDTOs(allPlaylists);
    }

    @Override
    @Transactional
    public PlaylistDTO updatePlaylist(PlaylistDTO playlistDTO) {
        PlaylistEntity playlistEntityToBeUpdated = playlistEntityRepository.findById(playlistDTO.id()).orElseThrow(
                () -> new NotFoundException("Playlist not found by id " + playlistDTO.id()));
        playlistEntityToBeUpdated.setDescription(playlistDTO.description());
        playlistEntityToBeUpdated.setName(playlistDTO.name());

        playlistEntityRepository.update(playlistEntityToBeUpdated);
        return playlistMapper.toDTO(playlistEntityToBeUpdated);
    }

    @Override
    @Transactional
    public List<PlaylistSongDTO> getSongsInPlaylist(Long playlistId) {
        PlaylistEntity playlistEntity = playlistEntityRepository.findById(playlistId).orElseThrow(
                () -> new NotFoundException("Playlist not found for id " + playlistId)
        );
        Set<PlaylistSongEntity> playlistSongEntities =  playlistEntity.getSongs();

        return playlistSongMapper.toPlaylistSongDTOList(playlistSongEntities.stream().toList());
    }

    @Override
    @Transactional
    public PlaylistRequestDTO addSongToPlaylist(PlaylistRequestDTO playlistRequestDTO) {
        PlaylistEntity playlist = playlistEntityRepository.findById(playlistRequestDTO.playlistId()).orElseThrow(
                () -> new NotFoundException("Playlist not found for id " + playlistRequestDTO.playlistId())
        );

        SongEntity song = songEntityRepository.findById(playlistRequestDTO.songId()).orElseThrow(
                () -> new NotFoundException("Song not found for id " + playlistRequestDTO.songId())
        );

        PlaylistSongEntity playlistSong = new PlaylistSongEntity(
                new PlaylistSongId(playlistRequestDTO.playlistId(), playlistRequestDTO.songId()), playlist, song);
        playlistSongEntityRepository.save(playlistSong);
        return playlistRequestDTO;
    }

    @Override
    @Transactional
    public void removeSongFromPlaylist(PlaylistRequestDTO playlistRequestDTO) {
        PlaylistEntity playlist = playlistEntityRepository.findById(playlistRequestDTO.playlistId()).orElseThrow(
                () -> new NotFoundException("Playlist not found for id " + playlistRequestDTO.playlistId())
        );
        playlist.getSongs().removeIf(song -> song.getId().getSongId().equals(playlistRequestDTO.songId()));

    }
}
