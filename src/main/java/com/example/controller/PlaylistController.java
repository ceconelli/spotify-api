package com.example.controller;

import com.example.dto.PlaylistDTO;
import com.example.dto.SongDTO;
import com.example.service.PlaylistService;
import com.example.service.SongService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

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

    @Get("/{id}")
    @Operation(summary = "Get song info", description = "Get song info by id")
    @ApiResponses(
            @ApiResponse(description = "Return song info", responseCode = "200")
    )
    public HttpResponse<PlaylistDTO> findById(@PathVariable Long id) {
        return HttpResponse.ok(playlistService.findById(id));
    }

    @Post("/createPlaylist")
    @Status(HttpStatus.CREATED)
    public HttpResponse<PlaylistDTO> createPlaylist(@Body @Valid PlaylistDTO playlistDTO) {
        return HttpResponse.ok(playlistService.createPlaylist(playlistDTO));
    }

    @Delete("/deletePlaylistById/{id}")
    public HttpResponse<Long> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return HttpResponse.ok(id);
    }

    @Put("/editPlaylist")
    public HttpResponse<PlaylistDTO> editPlaylist(@Body @Valid PlaylistDTO playlistDTO) {
        return HttpResponse.ok(playlistService.updatePlaylist(playlistDTO));
    }
}
