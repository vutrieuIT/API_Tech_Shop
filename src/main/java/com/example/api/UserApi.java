package com.example.api;

import com.example.dto.UserDTO;
import com.example.projection.ProductProjection;
import com.example.service.impl.OrderService;
import com.example.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;
    @PostMapping("register")
    public UserDTO register(@ModelAttribute UserDTO dto){
        return userService.register(dto);
    }
    @PostMapping("/login")
    public UserDTO login(@RequestParam("userName") String username,
                         @RequestParam("password") String password){
        return userService.login(username,password);
    }

    @PostMapping("/{id}/order")
    public List<ProductProjection> getOrder(@PathVariable("id") Long id){
        return orderService.getOrderByUserId(id);
    }

}
