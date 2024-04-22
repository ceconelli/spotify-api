package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Introspected
@Serdeable
public record PlaylistSongDTO(
                              @Min(value = 0, message = "You must pass a playlist ID") Long playlistId,
                              @Min(value = 0, message = "You must pass a song ID") Long songId) {
}
