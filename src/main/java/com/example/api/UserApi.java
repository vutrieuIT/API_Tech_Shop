package com.example.api;

import com.example.dto.UserDTO;
import com.example.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;
    @PostMapping("register")
    public UserDTO register(@ModelAttribute UserDTO dto){
        return userService.register(dto);
    }
    @PostMapping("/login")
    public UserDTO login(@RequestParam("userName") String username,
                         @RequestParam("password") String password){
        return userService.login(username,password);
    }
}
