package com.hexagonalarchi.demo.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hexagonalarchi.demo.domain.models.Product;
import org.jetbrains.annotations.NotNull;

public class AddProductRequest {
    @NotNull
    private Product product;

    @JsonCreator
    public AddProductRequest(@JsonProperty("product") final Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
