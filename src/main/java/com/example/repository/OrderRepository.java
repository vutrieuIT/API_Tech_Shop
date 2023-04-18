package com.example.repository;

import com.example.entity.OrderEntity;
import com.example.projection.ProductPopularProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT o.product.id AS productId, SUM(o.quantity) AS totalQuantity FROM OrderEntity o GROUP BY o.product.id ORDER BY totalQuantity DESC")
    List<ProductPopularProjection> findTopProducts(Pageable pageable);
    List<OrderEntity> findProductByUserIdAndStatusIsFalse(Long id);
}
