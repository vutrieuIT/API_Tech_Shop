package com.example.service;

import com.example.dto.ProductDTO;
import com.example.entity.ProductEntity;
import com.example.projection.ProductProjection;

import java.util.List;

public interface IProductService {

//    List<ProductDTO> getAllByCategoryId(Long id);
    List<ProductProjection> getAllByCategoryId(Long id);

    List<ProductProjection> getAll();

    List<ProductProjection> getPopularProduct(List<Long> ids);

    ProductProjection getDetailProduct(Long id);



}
