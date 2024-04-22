package com.example.service;

import com.example.dto.PlaylistDTO;
import com.example.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO useDTO);

    UserDTO findById(Long id);

    List<UserDTO> getAllUsers();

    Long deleteUser(Long id);

    UserDTO updateUser(UserDTO useDTO);

    UserDTO changePassword(Long id, String newPassword);

    List<PlaylistDTO> getUserPlaylists(Long userId);
}
