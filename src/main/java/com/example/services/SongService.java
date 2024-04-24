package com.example.services;

import com.example.dtos.PlaylistRequestDTO;
import com.example.dtos.SongDTO;

import java.util.List;

public interface SongService {

    SongDTO createSong(SongDTO songDTO);

    List<SongDTO> getAllSongs();

    SongDTO findById(Long id);

    Long deleteSong(Long id);

    SongDTO updateSong(SongDTO songDTO);
}
