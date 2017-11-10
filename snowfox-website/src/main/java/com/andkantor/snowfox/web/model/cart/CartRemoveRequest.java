package com.andkantor.snowfox.web.model.cart;

import javax.validation.constraints.NotNull;

public class CartRemoveRequest {

    @NotNull(message = "productId must be set")
    private Long productId;

    public CartRemoveRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
