package com.andkantor.snowfox.stock.model;

import org.apache.commons.lang3.Validate;
import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SnowFoxStyle
@Value.Immutable
@JsonDeserialize(as = ImmutableStockChange.class)
public interface StockChange {

    Operation operation();
    Long quantity();

    @Value.Check
    default void checkQuantity() {
        Validate.isTrue(quantity() >= 0, "Quantity must be greater or equal to 0");
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableStockChange.Builder {
    }

}
