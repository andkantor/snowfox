package com.andkantor.snowfox.stock.repository;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.andkantor.snowfox.stock.model.Operation;
import com.andkantor.snowfox.stock.model.StockChange;

@Repository
public class DefaultStockRepository implements StockRepository {

    @Resource(name="redisTemplate")
    private ValueOperations<Long, String> valueOps;

    @Override
    public long get(long productId) {
        String quantity = valueOps.get(productId);
        return quantity == null
                ? 0L
                : Long.parseLong(quantity);
    }

    @Override
    public boolean update(long productId, StockChange stockChange) {
        if (stockChange.operation().equals(Operation.INCREMENT)) {
            increment(productId, stockChange);
            return true;
        }

        if (stockChange.operation().equals(Operation.DECREMENT)) {
            Long newValue = decrement(productId, stockChange);
            if (newValue >= 0) {
                return true;
            }

            increment(productId, stockChange);
        }

        return false;
    }

    private void increment(long productId, StockChange stockChange) {
        valueOps.increment(productId, stockChange.quantity());
    }

    private Long decrement(long productId, StockChange stockChange) {
        return valueOps.increment(productId, -stockChange.quantity());
    }
}
