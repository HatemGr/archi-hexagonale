package com.hexagonalarchi.demo.domain.models;

import com.hexagonalarchi.demo.domain.DomainException;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private UUID id;
    private OrderStatus status;
    private List<OrderItem> orderItems;
    private BigDecimal price;

    public Order(UUID id, Product product) {
        this.id = id;
        this.orderItems = new ArrayList<>(List.of((new OrderItem(product))));
        this.status = OrderStatus.CREATED;
        this.price = product.getPrice();
    }

    public void complete() {
        this.status = OrderStatus.COMPLETED;
    }

    public void addOrder(Product product) {
        orderItems.add(new OrderItem(product));
        price = price.add(product.getPrice());
    }

    public void removeOrder(UUID id)  {
        final OrderItem orderItem = getOrderItem(id);
        orderItems.remove(orderItem);

        price = price.subtract(orderItem.getPrice());
    }

    private OrderItem getOrderItem(final UUID id) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getProductId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() -> new DomainException("Product with " + id + " doesn't exist."));
    }
}
