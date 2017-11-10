package com.andkantor.snowfox.stock.model;

public class QuantityChange {

    public long productId;
    public long quantity;

    public QuantityChange() {
    }

    public QuantityChange(long productId, long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public long productId() {
        return productId;
    }

    public long quantity() {
        return quantity;
    }

    public QuantityChange negate() {
        return new QuantityChange(productId, -quantity);
    }
}
