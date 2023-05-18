package com.example.service;

import com.example.dto.Order1;
import com.example.dto.UserOrder;
import com.example.projection.OrderProjection;
import com.example.projection.ProductProjection;

import java.util.List;

public interface IOrderService {
    List<Long> findTopProduct(int n);
    List<OrderProjection> getOrderByUserId(Long user_id);
    void saveOrder(UserOrder userOrder);

    void deleteOrder(List<Long> orderId);
}
