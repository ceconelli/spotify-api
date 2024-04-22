package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Introspected
@Serdeable
public record SongDTO(Long id,
                      @NotEmpty(message = "Song should have a title") String title,
                      @Min(value = 1, message = "Song should have a duration") int durationInSeconds,
                      @NotEmpty(message = "Song should have an artist") String artist,
                      @NotEmpty(message = "Song should have an album") String album,
                      @Min(value = 1, message = "Song should have an year") int year,
                      @NotEmpty(message = "Song should have an genre") String genre ) {
}
