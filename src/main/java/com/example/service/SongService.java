package com.example.service;

import com.example.dto.SongDTO;

public interface SongService {

    SongDTO createSong(SongDTO songDTO);

//    List<UserDTO> findAll();

    SongDTO findById(Long id);

//    void delete(Long id);
}
