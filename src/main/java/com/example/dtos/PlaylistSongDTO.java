package com.example.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Introspected
@Serdeable
public record PlaylistSongDTO(
                              @NotEmpty(message = "Song should have a title") String title,
                              @NotEmpty(message = "Song should have an artist") String artistName,
                              @NotEmpty(message = "Song should have an album") String album) {
}
