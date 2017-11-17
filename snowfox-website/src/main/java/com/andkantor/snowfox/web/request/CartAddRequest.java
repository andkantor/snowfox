package com.andkantor.snowfox.web.request;

import javax.validation.constraints.NotNull;

public class CartAddRequest {

    @NotNull(message = "productId must be set")
    private Long productId;

    @NotNull(message = "quantity must be set")
    private Long quantity;

    public CartAddRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
