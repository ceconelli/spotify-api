package com.example.service;

import com.example.dto.PlaylistDTO;

import java.util.List;

public interface PlaylistService {

    PlaylistDTO createPlaylist(PlaylistDTO playlistDTO);

    PlaylistDTO findById(Long id);

    Long deletePlaylist(Long id);

    List<PlaylistDTO> getAllPlaylists();

    PlaylistDTO updatePlaylist(PlaylistDTO playlistDTO);
}
