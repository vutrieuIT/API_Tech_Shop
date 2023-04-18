package com.example.service.impl;

import com.example.converter.UserConverter;
import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO dto) {
        UserEntity entity = userRepository.findByUserName(dto.getUserName());
        if (entity == null){
            entity = userRepository.save(userConverter.toEntity(dto));
            dto = userConverter.toDTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public UserDTO login(String username, String password) {
        UserEntity entity = userRepository.findByUserNameAndPassword(username, password);
        if (entity == null){
            return null;
        } else {
            return userConverter.toDTO(entity);
        }
    }
}
