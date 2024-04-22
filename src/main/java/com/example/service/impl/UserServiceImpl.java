package com.example.service.impl;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.exception.NotFoundException;
import com.example.mapper.UserMapper;
import com.example.repository.UserEntityRepository;
import com.example.service.UserService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDTO findById(Long id) {
        return userMapper.fromUserEntityToUserDTO(userEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found by id " + id)));
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity newUser = userEntityRepository.save(userMapper.fromUserDTOToUserEntity(userDTO));
        return userMapper.fromUserEntityToUserDTO(newUser);
    }
}
