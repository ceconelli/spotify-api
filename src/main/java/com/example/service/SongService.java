package com.example.service;

import com.example.dto.AddSongToPlaylistDTO;
import com.example.dto.SongDTO;

import java.util.List;

public interface SongService {

    SongDTO createSong(SongDTO songDTO);

    List<SongDTO> getAllSongs();

    SongDTO findById(Long id);

    Long deleteSong(Long id);

    SongDTO updateSong(SongDTO songDTO);

    Long addSongToPlaylist(AddSongToPlaylistDTO songToPlaylistDTO);
}
