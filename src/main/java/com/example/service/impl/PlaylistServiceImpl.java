package com.example.service.impl;

import com.example.dto.PlaylistDTO;
import com.example.entity.PlaylistEntity;
import com.example.exception.NotFoundException;
import com.example.mapper.PlaylistMapper;
import com.example.repository.PlaylistEntityRepository;
import com.example.service.PlaylistService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistEntityRepository playlistEntityRepository;
    private final PlaylistMapper playlistMapper;

    @Override
    @Transactional
    public PlaylistDTO findById(Long id) {
        return playlistMapper.toDTO(playlistEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Playlist not found by id " + id)));
    }

    @Override
    @Transactional
    public PlaylistDTO createPlaylist(PlaylistDTO playlistDTO) {
        PlaylistEntity newPlaylist = playlistEntityRepository.save(playlistMapper.toEntity(playlistDTO));
        return playlistMapper.toDTO(newPlaylist);
    }
}
