package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.UserService;
import io.micronaut.http.HttpResponse;
import io.reactivex.Single;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Optional;

@Controller("/user")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Get("/{id}")
    @Operation(summary = "Get user info", description = "Get user info by id")
    @ApiResponses(
            @ApiResponse(description = "Return user info", responseCode = "200")
    )
    public HttpResponse<UserDTO> findById(@PathVariable Long id) {
        return HttpResponse.ok(userService.findById(id));
    }

    @Post
    @Status(HttpStatus.CREATED)
    public HttpResponse<UserDTO> createUser(@Body @Valid UserDTO userDTO) {
        return HttpResponse.ok(userService.createUser(userDTO));
    }
}
