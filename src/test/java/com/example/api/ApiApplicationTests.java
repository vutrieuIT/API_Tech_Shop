package com.example.api;

import com.example.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApiApplicationTests {

    @Autowired
    private IOrderService orderService;
    @Test
    void contextLoads() {
        List<Long> ids = orderService.findTopProduct(10);
        for (Long id : ids){
            System.out.println(id);
        }
    }

}
