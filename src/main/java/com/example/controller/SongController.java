package com.example.controller;

import com.example.dto.ArtistDTO;
import com.example.dto.SongDTO;
import com.example.service.ArtistService;
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

@Controller("/song")
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

    @Post
    @Status(HttpStatus.CREATED)
    public HttpResponse<SongDTO> createSong(@Body @Valid SongDTO songDTO) {
        return HttpResponse.ok(songService.createSong(songDTO));
    }
}
