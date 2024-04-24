package com.example.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotEmpty;

@Introspected
@Serdeable
public record UserDTO(Long id,
                      @NotEmpty(message = "User should have a username") String username,
                      @NotEmpty(message = "User should have a email") String email,
                      @NotEmpty(message = "User should have a first name") String firstname,
                      @NotEmpty(message = "User should have a last name") String lastname) {
}
