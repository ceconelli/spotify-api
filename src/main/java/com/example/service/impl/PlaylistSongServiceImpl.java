package com.example.service.impl;

import com.example.dto.PlaylistDTO;
import com.example.dto.PlaylistSongDTO;
import com.example.entity.PlaylistEntity;
import com.example.entity.PlaylistSongEntity;
import com.example.exception.NotFoundException;
import com.example.mapper.PlaylistMapper;
import com.example.mapper.PlaylistSongMapper;
import com.example.repository.PlaylistEntityRepository;
import com.example.repository.PlaylistSongEntityRepository;
import com.example.service.PlaylistService;
import com.example.service.PlaylistSongService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class PlaylistSongServiceImpl implements PlaylistSongService {

    private final PlaylistSongEntityRepository playlistSongEntityRepository;
    private final PlaylistSongMapper playlistSongMapper;


    @Override
    @Transactional
    public PlaylistSongDTO addSongToPlaylist(PlaylistSongDTO playlistSongDTO) {
        PlaylistSongEntity newPlaylist = playlistSongEntityRepository.save(playlistSongMapper.toEntity(playlistSongDTO));
        return playlistSongMapper.toDTO(newPlaylist);
    }
}
