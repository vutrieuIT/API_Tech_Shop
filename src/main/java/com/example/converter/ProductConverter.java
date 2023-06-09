package com.example.converter;

import com.example.dto.ProductDTO;
import com.example.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO toDTO(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGia(entity.getGia());
        dto.setImage(entity.getImage());
        dto.setSoLuong(entity.getSoLuong());
        dto.setMoTa(entity.getMoTa());
        return dto;
    }

    public ProductEntity toEntity(ProductDTO dto){
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.getName());
        entity.setGia(dto.getGia());
        entity.setImage(dto.getImage());
        entity.setSoLuong(dto.getSoLuong());
        entity.setMoTa(dto.getMoTa());
        return entity;
    }
    public ProductEntity toEntity(ProductEntity entity, ProductDTO dto){
        entity.setName(dto.getName());
        entity.setGia(dto.getGia());
        entity.setImage(dto.getImage());
        entity.setSoLuong(dto.getSoLuong());
        entity.setMoTa(dto.getMoTa());
        return entity;
    }
}
