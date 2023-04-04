package com.hexagonalarchi.demo.domain.ports;

import com.hexagonalarchi.demo.domain.models.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<Order> findById(UUID id);

    void save(Order order);
}
