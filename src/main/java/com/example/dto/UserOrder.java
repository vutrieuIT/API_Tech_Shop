package com.example.dto;

import java.util.List;

public class UserOrder {
    private Long user_id;
    private List<Order1> orders;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<Order1> getOrders() {
        return orders;
    }

    public void setOrders(List<Order1> orders) {
        this.orders = orders;
    }
}

