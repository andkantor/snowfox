package com.andkantor.snowfox.stock.model;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;

@SnowFoxStyle
@Value.Immutable
public interface StockChangeResponse {

    boolean success();
    String errorMessage();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableStockChangeResponse.Builder {
    }
}
