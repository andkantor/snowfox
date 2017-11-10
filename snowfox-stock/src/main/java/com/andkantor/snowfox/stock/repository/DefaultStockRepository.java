package com.andkantor.snowfox.stock.repository;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.andkantor.snowfox.stock.model.QuantityChange;

@Repository
public class DefaultStockRepository implements StockRepository {

    @Resource(name="redisTemplate")
    private ValueOperations<Long, String> valueOps;

    @Override
    public long get(long productId) {
        return Long.parseLong(valueOps.get(productId));
    }

    @Override
    public void increment(QuantityChange increment) {
        if (increment.quantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        valueOps.increment(increment.productId(), increment.quantity());
    }

    @Override
    public boolean decrement(QuantityChange decrement) {
        if (decrement.quantity() >= 0) {
            throw new IllegalArgumentException("Quantity must be less than 0");
        }

        Long value = Long.valueOf(valueOps.get(decrement.productId()));
        if (value + decrement.quantity() >= 0) {
            Long newValue = valueOps.increment(decrement.productId(), decrement.quantity());
            if (newValue >= 0) {
                return true;
            }

            increment(decrement.negate());
        }

        return false;
    }
}
