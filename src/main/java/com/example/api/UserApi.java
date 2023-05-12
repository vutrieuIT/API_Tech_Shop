package com.example.api;

import com.example.dto.Response;
import com.example.dto.UserDTO;
import com.example.projection.ProductProjection;
import com.example.service.impl.OrderService;
import com.example.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {


    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("register")
    public Response register(@ModelAttribute UserDTO dto) {
        return userService.register(dto);
    }

    @PostMapping("/login")
    public Response login(@RequestParam("userName") String username,
                          @RequestParam("password") String password) {
        return userService.login(username, password);
    }

    @PostMapping("/{id}/order")
    public List<ProductProjection> getOrder(@PathVariable("id") Long id) {
        return orderService.getOrderByUserId(id);
    }

    @PostMapping("/avatar")
    public UserDTO updateAvatar(@RequestParam("id") Long id,
                                @RequestParam("avatar") MultipartFile avatar,
                                HttpServletRequest request) throws IOException {
        return userService.updateAvatar(id, avatar, request);
    }
}
