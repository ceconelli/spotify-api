package com.example.service;

import com.example.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    UserDTO createUser(UserDTO useDTO);

//    List<UserDTO> findAll();

    UserDTO findById(Long id);

//    void delete(Long id);
}
