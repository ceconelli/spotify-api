package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;

@Introspected
@Serdeable
public record ArtistDTO(Long id,
                        @NotEmpty(message = "Artist should have a name") String artistName,
                        @NotEmpty(message = "Artist should have a description") String description) {
}
