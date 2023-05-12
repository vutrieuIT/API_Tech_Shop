package com.example.service.impl;

import com.example.constant.Constant;
import com.example.converter.UserConverter;
import com.example.dto.Response;
import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public Response<UserDTO> register(UserDTO dto) {
        UserEntity entity = userRepository.findByUserName(dto.getUserName());
        Response response = new Response<>();
        if (entity == null){
            entity = userRepository.save(userConverter.toEntity(dto));
            dto = userConverter.toDTO(entity);
            response.setData(dto);
            return response;
        } else {
            response.setMessage("tên đăng nhập đã tồn tại");
            return response;
        }
    }

    @Override
    public Response<UserDTO> login(String username, String password) {
        UserEntity entity = userRepository.findByUserNameAndPassword(username, password);
        Response response = new Response<UserDTO>();
        if (entity == null){
            response.setMessage("tài khoản, hoặc mật khẩu không đúng");
            return response;
        } else {
            response.setData(userConverter.toDTO(entity));
            return response;
        }
    }

    @Override
    public UserDTO updateAvatar(Long id, MultipartFile avatar, HttpServletRequest request) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }

        UserEntity entity = userRepository.findById(id).get();
        if(entity != null){
            //random file name
            String originalFilename = avatar.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = id +"_" + UUID.randomUUID().toString().substring(0,10) + extension;
            //đường dân trên server
            Path file = CURRENT_FOLDER.resolve(staticPath)
                    .resolve(imagePath).resolve(fileName);
            // ghi file
            try (OutputStream os = Files.newOutputStream(file)) {
                os.write(avatar.getBytes());
            }
            // set url của ảnh
            entity.setAvatar(Constant.LOCALHOST+imagePath.resolve(fileName));
            userRepository.save(entity);
            return userConverter.toDTO(entity);
        } else {
            return null;
        }
    }
}
