package com.example.converter;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;

public class UserConverter {

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setSDT(entity.getSDT());
        dto.setAvatar(entity.getAvatar());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setSDT(dto.getSDT());
        entity.setAvatar(dto.getAvatar());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public UserEntity toEntity(UserEntity entity, UserDTO dto){
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setSDT(dto.getSDT());
        entity.setAvatar(dto.getAvatar());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
