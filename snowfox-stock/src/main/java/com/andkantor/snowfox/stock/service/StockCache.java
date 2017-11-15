package com.andkantor.snowfox.stock.service;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.andkantor.snowfox.stock.model.StockInfo;

@Component
public class StockCache {

    private Map<Long, Long> productQuantities;

    public StockCache() {
        productQuantities = new HashMap<>();
    }

    public StockCache(Map<Long, Long> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public List<StockInfo> get(List<Long> productIds) {
        return productIds.stream()
                .map(productId -> createStockInfo(productId, productQuantities.getOrDefault(productId, 0L)))
                .collect(toList());
    }

    public void update(Long productId, Long quantity) {
        productQuantities.put(productId, quantity);
    }

    private StockInfo createStockInfo(Long productId, Long quantity) {
        return StockInfo.builder()
                .productId(productId)
                .quantity(quantity)
                .build();
    }
}
