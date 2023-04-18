package com.example.service.impl;

import com.example.entity.OrderEntity;
import com.example.projection.ProductPopularProjection;
import com.example.projection.ProductProjection;
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

    @Override
    public List<ProductProjection> getOrderByUserId(Long user_id) {
        List<OrderEntity> entities = orderRepository.findProductByUserIdAndStatusIsFalse(user_id);
        List<ProductProjection> products = entities.stream()
                .map(this::orderEntityToProductProjection)
                .collect(Collectors.toList());
        return products;
    }

    private ProductProjection orderEntityToProductProjection(OrderEntity entity){
        return new ProductProjection() {
            @Override
            public Long getId() {
                return entity.getProduct().getId();
            }

            @Override
            public String getName() {
                return entity.getProduct().getName();
            }

            @Override
            public String getGia() {
                return entity.getProduct().getGia();
            }

            @Override
            public int getSoLuong() {
                return 0;
            }

            @Override
            public String getMoTa() {
                return null;
            }

            @Override
            public int getQuantity() {
                return entity.getQuantity();
            }

            @Override
            public Long getCategoryId() {
                return null;
            }
        };
    }
}
