package com.example.service.impl;

import com.example.projection.ProductPopularProjection;
import com.example.repository.OrderRepository;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Long> findTopProduct(int n) {
        Pageable pageable = PageRequest.of(0, n);
        List<ProductPopularProjection> results = orderRepository.findTopProducts(pageable);
        List<Long> topProductIds = new ArrayList<>();
        for (ProductPopularProjection result : results) {
            topProductIds.add(result.getProductId());
            System.out.println(result.getTotalQuantity());
        }
        return topProductIds;
    }
}
