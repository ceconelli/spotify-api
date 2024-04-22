package com.example.service;

import com.example.dto.ArtistDTO;

public interface ArtistService {

    ArtistDTO createArtist(ArtistDTO useDTO);

//    List<UserDTO> findAll();

    ArtistDTO findById(Long id);

//    void delete(Long id);
}
