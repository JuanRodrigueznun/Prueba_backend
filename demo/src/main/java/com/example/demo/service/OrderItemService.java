package com.example.demo.service;

import com.example.demo.model.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        OrderItem existingOrderItem = orderItemRepository.findById(id).orElse(null);
        if (existingOrderItem != null) {
            existingOrderItem.setQuantity(orderItem.getQuantity());
            existingOrderItem.setUnitPrice(orderItem.getUnitPrice());
            existingOrderItem.setTotalPrice(orderItem.getTotalPrice());
            existingOrderItem.setOrder(orderItem.getOrder());
            existingOrderItem.setProduct(orderItem.getProduct());
            return orderItemRepository.save(existingOrderItem);
        } else {
            return null;
        }
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
