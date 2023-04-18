package com.example.service;

import com.example.projection.ProductProjection;

import java.util.List;

public interface IOrderService {
    List<Long> findTopProduct(int n);
    List<ProductProjection> getOrderByUserId(Long user_id);
}
