package com.andkantor.snowfox.web.model.stock;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SnowFoxStyle
@Value.Immutable
@JsonSerialize(as = ImmutableStockInfo.class)
@JsonDeserialize(as = ImmutableStockInfo.class)
public interface StockInfo {

    Long productId();
    Long quantity();

    static StockInfo stockInfo(Long productId, Long quantity) {
        return builder()
                .productId(productId)
                .quantity(quantity)
                .build();
    }

    static StockInfo noStockInfo(Long productId) {
        return stockInfo(productId, 0L);
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableStockInfo.Builder {
    }
}
