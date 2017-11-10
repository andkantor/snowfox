package com.andkantor.snowfox.stock.repository;

import com.andkantor.snowfox.stock.model.QuantityChange;

public interface StockRepository {

    long get(long productId);

    void increment(QuantityChange increment);

    boolean decrement(QuantityChange decrement);

}
