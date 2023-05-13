package com.example.converter;

import com.example.dto.CategoryDTO;
import com.example.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO toDTO(CategoryEntity entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setImage(entity.getImage());
        return dto;
    }

    public CategoryEntity toEntity(CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }

    public CategoryEntity toEntity(CategoryEntity entity, CategoryDTO dto){
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        return entity;
    }
}
