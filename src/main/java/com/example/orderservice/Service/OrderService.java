package com.example.orderservice.Service;

import com.example.orderservice.entity.Order;
import java.util.List;

public interface OrderService {
    Order createOrder (Order order);
    Order getOrderById (Long id);
    List<Order> getOrdersByOrderId(Long userId);
    List<Order> getOrdersByUserId(Long userId);
}
