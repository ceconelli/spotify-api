package com.example.services.impl;

import com.example.dtos.PlaylistDTO;
import com.example.dtos.UserDTO;
import com.example.domain.UserEntity;
import com.example.exceptions.NotFoundException;
import com.example.mappers.PlaylistMapper;
import com.example.mappers.UserMapper;
import com.example.repositories.UserEntityRepository;
import com.example.services.UserService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;
    private final PlaylistMapper playlistMapper;

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

    @Override
    @Transactional
    public List<UserDTO> getAllUsers() {
        List<UserEntity> allUsers = userEntityRepository.findAll();
        return userMapper.map(allUsers);
    }

    @Override
    @Transactional
    public Long deleteUser(Long id) {
        userEntityRepository.deleteById(id);
        return id;
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity userToBeUpdated =  userEntityRepository.findById(userDTO.id()).orElseThrow(
                () -> new NotFoundException("User not found for id " + userDTO.id())
        );

        userToBeUpdated.setEmail(userDTO.email());
        userToBeUpdated.setUsername(userDTO.username());
        userToBeUpdated.setFirstname(userDTO.firstname());
        userToBeUpdated.setLastname(userDTO.lastname());

        userEntityRepository.update(userToBeUpdated);
        return userMapper.fromUserEntityToUserDTO(userToBeUpdated);
    }

    @Override
    @Transactional
    public UserDTO changeEmail(Long id, Email email) {
        UserEntity userToBeUpdated =  userEntityRepository.findById(id).orElseThrow();
        userToBeUpdated.setEmail(String.valueOf(email));
        return userMapper.fromUserEntityToUserDTO(userEntityRepository.update(userToBeUpdated));
    }

    @Override
    @Transactional
    public List<PlaylistDTO> getUserPlaylists(Long userId) {
        UserEntity owner =  userEntityRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User not found for id " + userId)
        );
        return playlistMapper.toDTOs(owner.getPlaylists());
    }
}
