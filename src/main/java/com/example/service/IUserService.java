package com.example.service;

import com.example.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface IUserService {
    UserDTO register(UserDTO dto);
    UserDTO login(String username, String password);
    UserDTO updateAvatar(Long id, MultipartFile avatar, HttpServletRequest request) throws IOException;
}
