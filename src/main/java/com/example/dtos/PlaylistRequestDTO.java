package com.example.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Min;

@Introspected
@Serdeable
public record PlaylistRequestDTO(
                                   @Min(value = 0, message = "Playlist Id is mandatory") Long playlistId,
                                   @Min(value = 0, message = "Song Id is mandatory") Long songId) {
}
