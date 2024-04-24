package com.example.controllers;

import com.example.dtos.SongDTO;
import com.example.services.SongService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Tag(name = "Songs Controller")
@Controller("/songs")
@Validated
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @Get("/{id}")
    @Operation(summary = "Get song info", description = "Get song info by id")
    @ApiResponses(
            @ApiResponse(description = "Return song info", responseCode = "200")
    )
    public HttpResponse<SongDTO> findById(@PathVariable Long id) {
        return HttpResponse.ok(songService.findById(id));
    }

    @Get
    @Status(HttpStatus.OK)
    public HttpResponse<List<SongDTO>> findAll() {
        return HttpResponse.ok(songService.getAllSongs());
    }

    @Post("/createSong")
    @Status(HttpStatus.CREATED)
    public HttpResponse<SongDTO> createSong(@Body @Valid SongDTO songDTO) {
        return HttpResponse.ok(songService.createSong(songDTO));
    }

    @Put("/updateSong")
    @Status(HttpStatus.OK)
    public HttpResponse<SongDTO> updateSong(@Body @Valid SongDTO songDTO) {
        return HttpResponse.ok(songService.updateSong(songDTO));
    }

    @Delete("/deleteSongById")
    @Status(HttpStatus.OK)
    public HttpResponse<Long> deleteSong(@QueryValue Long id) {
        return HttpResponse.ok(songService.deleteSong(id));
    }

}
