package com.example.controllers;

import com.example.dtos.PlaylistDTO;
import com.example.dtos.PlaylistSongDTO;
import com.example.dtos.SongDTO;
import com.example.dtos.PlaylistRequestDTO;
import com.example.services.PlaylistService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Tag(name = "Playlists Controller")
@Controller("/playlists")
@Validated
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @Get
    @Status(HttpStatus.OK)
    public HttpResponse<List<PlaylistDTO>> getAllPlaylists() {
        return HttpResponse.ok(playlistService.getAllPlaylists());
    }

    @Get("/{playlistId}")
    public HttpResponse<PlaylistDTO> findById(@PathVariable Long playlistId) {
        return HttpResponse.ok(playlistService.findById(playlistId));
    }

    @Post("/createPlaylist")
    @Status(HttpStatus.CREATED)
    public HttpResponse<PlaylistDTO> createPlaylist(@Body @Valid PlaylistDTO playlistDTO) {
        return HttpResponse.ok(playlistService.createPlaylist(playlistDTO));
    }

    @Delete("/deletePlaylistById/{playlistId}")
    public HttpResponse<Long> deletePlaylist(@PathVariable Long playlistId) {
        playlistService.deletePlaylist(playlistId);
        return HttpResponse.ok(playlistId);
    }

    @Put("/editPlaylist")
    public HttpResponse<PlaylistDTO> editPlaylist(@Body @Valid PlaylistDTO playlistDTO) {
        return HttpResponse.ok(playlistService.updatePlaylist(playlistDTO));
    }

    @Get("/getSongsInPlaylist/{playlistId}")
    public HttpResponse<List<PlaylistSongDTO>> getSongsInPlaylist(@PathVariable Long playlistId) {
        return HttpResponse.ok(playlistService.getSongsInPlaylist(playlistId));
    }

    @Post("/addSongToPlaylist")
    @Status(HttpStatus.CREATED)
    public HttpResponse<PlaylistRequestDTO> addSongToPlaylist(@Body @Valid PlaylistRequestDTO playlistRequestDTO) {
        return HttpResponse.ok(playlistService.addSongToPlaylist(playlistRequestDTO));
    }
}
