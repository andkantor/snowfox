package com.andkantor.snowfox.web.model.stock;

import static com.andkantor.snowfox.web.model.stock.StockInfo.noStockInfo;

import java.util.List;
import java.util.Map;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.andkantor.snowfox.web.model.base.Product;

@SnowFoxStyle
@Value.Immutable
public interface Warehouse {

    Map<Long, StockInfo> stockInfoMap();

    default Long remainingQuantityFor(Product product) {
        return stockInfoMap()
                .getOrDefault(product.id(), noStockInfo(product.id()))
                .quantity();
    }

    static Warehouse warehouse(List<StockInfo> stockInfoList) {
        Builder builder = builder();
        stockInfoList.forEach(stockInfo -> builder.putStockInfoMap(stockInfo.productId(), stockInfo));
        return builder.build();
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableWarehouse.Builder {
    }
}
