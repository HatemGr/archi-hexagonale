package com.hexagonalarchi.demo.domain.service;

import com.hexagonalarchi.demo.domain.models.Order;
import com.hexagonalarchi.demo.domain.models.Product;
import com.hexagonalarchi.demo.domain.ports.OrderRepository;
import com.hexagonalarchi.demo.domain.service.OrderService;

import java.util.UUID;

public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DomainOrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID createOrder(final Product product) {
        final Order order = new Order(UUID.randomUUID(), product);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public void addProduct(final UUID id, final Product product) {
        final Order order = getOrder(id);
        order.addOrder(product);

        orderRepository.save(order);
    }

    @Override
    public void completeOrder(final UUID id) {
        final Order order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(final UUID id, final UUID productId) {
        final Order order = getOrder(id);
        order.removeOrder(productId);

        orderRepository.save(order);
    }

    private Order getOrder(UUID id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order with given id doesn't exist"));
    }
}
