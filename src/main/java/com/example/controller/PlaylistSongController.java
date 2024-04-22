package com.example.controller;

import com.example.dto.PlaylistDTO;
import com.example.dto.PlaylistSongDTO;
import com.example.service.PlaylistService;
import com.example.service.PlaylistSongService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller("/addToPlaylist")
@Validated
@RequiredArgsConstructor
public class PlaylistSongController {

    private final PlaylistSongService playlistSongService;

    @Post
    @Status(HttpStatus.CREATED)
    public HttpResponse<PlaylistSongDTO> addSongToPlaylist(@Body @Valid PlaylistSongDTO playlistSongDTO) {
        return HttpResponse.ok(playlistSongService.addSongToPlaylist(playlistSongDTO));
    }
}
