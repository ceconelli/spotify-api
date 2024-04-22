package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Introspected
@Serdeable
public record UserDTO(Long id,
                      @NotEmpty(message = "User should have a userName") String username,
                      @NotEmpty(message = "User should have a email") String email,
                      @NotEmpty(message = "User should have a email") String password,
                      @NotEmpty(message = "User should have a email") String firstname,
                      @NotEmpty(message = "User should have a email") String lastname) {
}
