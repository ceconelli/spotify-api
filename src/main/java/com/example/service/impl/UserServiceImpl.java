package com.example.service.impl;

import com.example.dto.PlaylistDTO;
import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.exception.NotFoundException;
import com.example.mapper.PlaylistMapper;
import com.example.mapper.UserMapper;
import com.example.repository.UserEntityRepository;
import com.example.service.UserService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

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
        userToBeUpdated.setPassword(userDTO.password());
        userToBeUpdated.setFirstname(userDTO.firstname());
        userToBeUpdated.setLastname(userDTO.lastname());

        userEntityRepository.update(userToBeUpdated);
        return userMapper.fromUserEntityToUserDTO(userToBeUpdated);
    }

    @Override
    @Transactional
    public UserDTO changePassword(Long id, String password) {
        UserEntity userToBeUpdated =  userEntityRepository.findById(id).orElseThrow();
        userToBeUpdated.setPassword(password);
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
