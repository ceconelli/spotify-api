package com.example.controller;

import com.example.dto.ArtistDTO;
import com.example.dto.UserDTO;
import com.example.service.ArtistService;
import com.example.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller("/artist")
@Validated
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @Get("/{id}")
    @Operation(summary = "Get artist info", description = "Get artist info by id")
    @ApiResponses(
            @ApiResponse(description = "Return artist info", responseCode = "200")
    )
    public HttpResponse<ArtistDTO> findById(@PathVariable Long id) {
        return HttpResponse.ok(artistService.findById(id));
    }

    @Post
    @Status(HttpStatus.CREATED)
    public HttpResponse<ArtistDTO> createUser(@Body @Valid ArtistDTO artistDTO) {
        return HttpResponse.ok(artistService.createArtist(artistDTO));
    }
}
