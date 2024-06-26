package com.example.controllers;

import com.example.dtos.PlaylistDTO;
import com.example.dtos.UserDTO;
import com.example.services.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@Tag(name = "Users Controller")
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

    @Delete("/deleteUserById/{id}")
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
    public HttpResponse<UserDTO> changePassword(@PathVariable Long id, @Body Email email) {
        return HttpResponse.ok(userService.changeEmail(id, email));
    }

    @Get("/getPlaylistsFromUser/{id}")
    @Status(HttpStatus.OK)
    public HttpResponse<List<PlaylistDTO>> getUserPlaylists(@PathVariable Long id) {
        return HttpResponse.ok(userService.getUserPlaylists(id));
    }


}
