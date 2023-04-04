package com.hexagonalarchi.demo.domain.service;

import com.hexagonalarchi.demo.domain.models.Order;
import com.hexagonalarchi.demo.domain.models.Product;

import java.util.UUID;

public interface OrderService {
    UUID createOrder(Product product);

    void addProduct(UUID id, Product product);

    void completeOrder(UUID id);

    void deleteProduct(UUID id, UUID productId);
}
