package com.example.converter;

import com.example.dto.OrderDTO;
import com.example.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public OrderDTO toDTO(OrderEntity entity){
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        return dto;
    }
    public OrderEntity toEntity(OrderDTO dto){
        OrderEntity entity = new OrderEntity();
        entity.setQuantity(entity.getQuantity());
        return entity;
    }

    public OrderEntity toEntity(OrderEntity entity, OrderDTO dto){
        entity.setQuantity(entity.getQuantity());
        return entity;
    }

}
