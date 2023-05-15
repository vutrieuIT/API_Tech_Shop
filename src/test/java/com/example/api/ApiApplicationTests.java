package com.example.api;

import com.example.entity.ProductEntity;
import com.example.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@SpringBootTest
class ApiApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Test
    void contextLoads() {
        Pageable pageable = PageRequest.of(0,2);
        Page<ProductEntity> productEntities = productRepository.findAll(pageable);
        for (ProductEntity e: productEntities){
            System.out.println(e.getId());
        }
    }

}
