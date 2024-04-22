package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    List<UserDTO> map(List<UserEntity> userEntities);

    UserDTO fromUserEntityToUserDTO(UserEntity userEntity);

    UserEntity fromUserDTOToUserEntity(UserDTO userDTO);
}
