package com.andkantor.snowfox.stock.model;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;

@SnowFoxStyle
@Value.Immutable
public interface StockChangeMessage {

    Long productId();
    StockChange stockChange();
    Long currentQuantity();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableStockChangeMessage.Builder {
    }
}
