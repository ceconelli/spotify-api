package com.example.service;

import com.example.dto.ArtistDTO;

import java.util.List;

public interface ArtistService {

    ArtistDTO createArtist(ArtistDTO useDTO);

    List<ArtistDTO> getAllArtists();

    ArtistDTO findById(Long id);

    Long deleteArtist(Long id);
}
