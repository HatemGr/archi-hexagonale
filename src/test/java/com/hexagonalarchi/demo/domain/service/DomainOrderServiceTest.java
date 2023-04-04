package com.hexagonalarchi.demo.domain.service;

import com.hexagonalarchi.demo.domain.models.Order;
import com.hexagonalarchi.demo.domain.models.Product;
import com.hexagonalarchi.demo.domain.ports.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DomainOrderServiceTest {
    private OrderRepository orderRepository;
    private DomainOrderService tested;
    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        tested = new DomainOrderService(orderRepository);
    }

    @Test
    void shouldCreateOrder_thenSaveIt() {
        final Product product = new Product(UUID.randomUUID(), BigDecimal.TEN, "productName");

        final UUID id = tested.createOrder(product);

        verify(orderRepository).save(ArgumentMatchers.any(Order.class));
        assertNotNull(id);
    }
}