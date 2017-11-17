package com.andkantor.snowfox.stock.model;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SnowFoxStyle
@Value.Immutable
@JsonSerialize(as = ImmutableStockChangeMessage.class)
@JsonDeserialize(as = ImmutableStockChangeMessage.class)
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
