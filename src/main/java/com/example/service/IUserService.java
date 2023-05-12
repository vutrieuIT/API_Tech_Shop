package com.example.service;

import com.example.dto.Response;
import com.example.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface IUserService {
    Response<UserDTO> register(UserDTO dto);
    Response<UserDTO> login(String username, String password);
    UserDTO updateAvatar(Long id, MultipartFile avatar, HttpServletRequest request) throws IOException;
}
