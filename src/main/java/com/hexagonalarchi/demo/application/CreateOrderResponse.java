package com.hexagonalarchi.demo.application;

import java.util.UUID;

public class CreateOrderResponse {
    private final UUID id;

    public CreateOrderResponse(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
