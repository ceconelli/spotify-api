package com.example.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Introspected
@Serdeable
public record PlaylistDTO(Long id,
                          @NotEmpty(message = "Playlist should have a title") String name,
                          @NotEmpty(message = "Playlist should have an description") String description,
                          @Min(value = 0, message = "Playlist should have an owner") Long userId) {
}
