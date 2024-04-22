package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@Controller("/users")
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

    @Get
    @Status(HttpStatus.OK)
    public HttpResponse<List<UserDTO>> getAllUsers() {
        return HttpResponse.ok(userService.getAllUsers());
    }

    @Post("/createUser")
    @Status(HttpStatus.CREATED)
    public HttpResponse<UserDTO> createUser(@Body @Valid UserDTO userDTO) {
        return HttpResponse.ok(userService.createUser(userDTO));
    }

    @Delete("/deleteUserById")
    @Status(HttpStatus.OK)
    public HttpResponse<Long> deleteUser(@QueryValue Long id) {
        return HttpResponse.ok(userService.deleteUser(id));
    }

    @Put("/editUser")
    @Status(HttpStatus.OK)
    public HttpResponse<UserDTO> updateUser(@Body @Valid UserDTO userDTO) {
        return HttpResponse.ok(userService.updateUser(userDTO));
    }

    @Patch("/updateUserPassword/{id}")
    @Status(HttpStatus.OK)
    public HttpResponse<UserDTO> changePassword(@PathVariable Long id, @Body String newPassword) {
        return HttpResponse.ok(userService.changePassword(id, newPassword));
    }


}
