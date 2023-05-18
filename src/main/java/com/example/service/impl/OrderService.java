package com.example.service.impl;

import com.example.dto.Order1;
import com.example.dto.UserOrder;
import com.example.entity.OrderEntity;
import com.example.entity.ProductEntity;
import com.example.entity.UserEntity;
import com.example.projection.OrderProjection;
import com.example.projection.ProductPopularProjection;
import com.example.projection.ProductProjection;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;
import com.example.service.IOrderService;
import com.example.service.IProductService;
import com.example.service.IUserService;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
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
    public List<OrderProjection> getOrderByUserId(Long user_id) {
        List<OrderEntity> entities = orderRepository.findProductByUserId(user_id);
        List<OrderProjection> orders = entities.stream()
                .map(OrderProjection::from)
                .collect(Collectors.toList());
        return orders;
    }

    @Override
    public void saveOrder(UserOrder userOrder) {
        UserEntity userEntity = userRepository.findById(userOrder.getUser_id()).get();
        for (Order1 order1 : userOrder.getOrders()){
            ProductEntity product = productRepository.findById(order1.getProduct_id()).get();
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setUser(userEntity);
            orderEntity.setProduct(product);
            orderEntity.setQuantity(order1.getQuantity());
            orderEntity.setTotal_money(order1.getTotal_money());
            orderRepository.save(orderEntity);
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
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
            public Integer getTotalMoney() {
                return entity.getTotal_money();
            }

            @Override
            public String getImage() {
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
