package com.example.projection;

import com.example.entity.OrderEntity;

public interface OrderProjection {

    Long getOrderId();
    String getProductName();

    Integer getQuantity();

    Integer getTotalMoney();

    String getImage();

    static OrderProjection from (OrderEntity orderEntity){

        return new OrderProjection() {
            @Override
            public Long getOrderId() {
                return orderEntity.getId();
            }

            @Override
            public String getProductName() {
                return orderEntity.getProduct().getName();
            }

            @Override
            public Integer getQuantity() {
                return orderEntity.getQuantity();
            }

            @Override
            public Integer getTotalMoney() {
                return orderEntity.getTotal_money();
            }

            @Override
            public String getImage() {
                return orderEntity.getProduct().getImage();
            }
        };
    }

}
