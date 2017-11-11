package com.andkantor.snowfox.stock.repository;

import com.andkantor.snowfox.stock.model.StockChange;

public interface StockRepository {

    long get(long productId);

    boolean update(long productId, StockChange stockChange);

}
