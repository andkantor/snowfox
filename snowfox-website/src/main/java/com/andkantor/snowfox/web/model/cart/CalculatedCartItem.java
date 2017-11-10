package com.andkantor.snowfox.web.model.cart;

import com.andkantor.snowfox.web.model.base.Price;
import com.andkantor.snowfox.web.model.product.Product;

public class CalculatedCartItem {

    private Product product;
    private Long quantity;

    public CalculatedCartItem(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return product.getId();
    }

    public String getName() {
        return product.getName();
    }

    public Long getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return product.getPrice().multiply(quantity);
    }
}
