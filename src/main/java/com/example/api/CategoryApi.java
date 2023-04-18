package com.example.api;

import com.example.dto.CategoryDTO;
import com.example.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<CategoryDTO> getAll(){
        return categoryService.getAll();
    }
}
