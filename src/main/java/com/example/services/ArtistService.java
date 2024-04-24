package com.example.services;

import com.example.dtos.ArtistDTO;

import java.util.List;

public interface ArtistService {

    ArtistDTO createArtist(ArtistDTO useDTO);

    List<ArtistDTO> getAllArtists();

    ArtistDTO findById(Long id);

    Long deleteArtist(Long id);
}
