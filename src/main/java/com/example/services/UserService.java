package com.example.services;

import com.example.dtos.PlaylistDTO;
import com.example.dtos.UserDTO;
import jakarta.validation.constraints.Email;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO useDTO);

    UserDTO findById(Long id);

    List<UserDTO> getAllUsers();

    Long deleteUser(Long id);

    UserDTO updateUser(UserDTO useDTO);

    UserDTO changeEmail(Long id, Email email);

    List<PlaylistDTO> getUserPlaylists(Long userId);
}
