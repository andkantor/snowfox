package com.andkantor.snowfox.stock.repository;

import com.andkantor.snowfox.stock.exception.NotEnoughQuantitiesException;
import com.andkantor.snowfox.stock.model.StockChange;

public interface StockRepository {

    long get(long productId);

    long update(long productId, StockChange stockChange) throws NotEnoughQuantitiesException;

}
