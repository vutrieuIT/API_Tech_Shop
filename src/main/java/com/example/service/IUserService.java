package com.example.service;

import com.example.dto.UserDTO;

public interface IUserService {
    UserDTO register(UserDTO dto);
    UserDTO login(String username, String password);
}
