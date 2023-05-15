package com.example.service;

import com.example.dto.ProductDTO;
import com.example.entity.ProductEntity;
import com.example.projection.ProductProjection;

import java.util.List;

public interface IProductService {

//    List<ProductDTO> getAllByCategoryId(Long id);
    List<ProductProjection> getAllByCategoryId(Long id, int page, int size);

    List<ProductProjection> getAll(int page, int size);

    List<ProductProjection> getPopularProduct(int n);

    ProductProjection getDetailProduct(Long id);



}
