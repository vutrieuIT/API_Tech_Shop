package com.example.service.impl;

import com.example.converter.CategoryConverter;
import com.example.dto.CategoryDTO;
import com.example.entity.CategoryEntity;
import com.example.repository.CategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;
    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (CategoryEntity e: categoryEntities) {
            categoryDTOS.add(categoryConverter.toDTO(e));
        }
        return categoryDTOS;
    }
}
