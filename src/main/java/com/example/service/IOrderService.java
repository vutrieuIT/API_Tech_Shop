package com.example.service;

import java.util.List;

public interface IOrderService {
    List<Long> findTopProduct(int n);
}
