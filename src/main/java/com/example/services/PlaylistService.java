package com.example.services;

import com.example.dtos.PlaylistDTO;
import com.example.dtos.PlaylistSongDTO;
import com.example.dtos.SongDTO;
import com.example.dtos.PlaylistRequestDTO;

import java.util.List;

public interface PlaylistService {

    PlaylistDTO createPlaylist(PlaylistDTO playlistDTO);

    PlaylistDTO findById(Long id);

    Long deletePlaylist(Long id);

    List<PlaylistDTO> getAllPlaylists();

    PlaylistDTO updatePlaylist(PlaylistDTO playlistDTO);

    List<PlaylistSongDTO> getSongsInPlaylist(Long playlistId);

    PlaylistRequestDTO addSongToPlaylist(PlaylistRequestDTO playlistRequestDTO);

    void removeSongFromPlaylist(PlaylistRequestDTO playlistRequestDTO);
}
