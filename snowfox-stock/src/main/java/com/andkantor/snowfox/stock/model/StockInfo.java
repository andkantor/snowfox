package com.andkantor.snowfox.stock.model;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SnowFoxStyle
@Value.Immutable
@JsonDeserialize(as = ImmutableStockInfo.class)
public interface StockInfo {

    Long productId();
    Long quantity();

    static StockInfo.Builder builder() {
        return new StockInfo.Builder();
    }

    class Builder extends ImmutableStockInfo.Builder {
    }

}
