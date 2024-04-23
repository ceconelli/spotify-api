package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Introspected
@Serdeable
public record AddSongToPlaylistDTO(
                                   @Min(value = 0, message = "Playlist Id is mandatory") Long playlistId,
                                   @Min(value = 0, message = "Song Id is mandatory") Long songId) {
}
