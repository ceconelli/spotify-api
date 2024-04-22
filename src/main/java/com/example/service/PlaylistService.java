package com.example.service;

import com.example.dto.PlaylistDTO;

public interface PlaylistService {

    PlaylistDTO createPlaylist(PlaylistDTO playlistDTO);

    PlaylistDTO findById(Long id);
}
