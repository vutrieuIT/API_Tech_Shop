package com.example.service.impl;

import com.example.converter.ProductConverter;
import com.example.dto.ProductDTO;
import com.example.entity.ProductEntity;
import com.example.projection.ProductProjection;
import com.example.repository.ProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

//    @Override
//    public List<ProductDTO> getAllByCategoryId(Long id) {
//        List<ProductEntity> entities = productRepository.findAllByCategoryId(id);
//        List<ProductDTO> dtos = new ArrayList<>();
//        for(ProductEntity entity :entities){
//            dtos.add(productConverter.toDTO(entity));
//        }
//        return dtos;
//    }

    @Override
    public List<ProductProjection> getAllByCategoryId(Long id) {
        List<ProductEntity> entities = productRepository.findAllByCategoryId(id);
        return entities.stream()
                .map(ProductProjection::from)
                        .collect(Collectors.toList());

    }

    @Override
    public List<ProductProjection> getAll() {
        List<ProductEntity> entities = productRepository.findAll();
        return entities.stream()
                .map(ProductProjection::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductProjection> getPopularProduct(List<Long> ids) {
        return productRepository.findAllById(ids)
                .stream().map(ProductProjection::from)
                .collect(Collectors.toList());
    }

    @Override
    public ProductProjection getDetailProduct(Long id) {
        ProductEntity entity = productRepository.findById(id).orElse(null);
        return ProductProjection.from(entity);
    }
}
