package com.andkantor.snowfox.web.model.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.andkantor.snowfox.web.model.product.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class StockService {

    @Value("${snowfox.stock-service-url}")
    private String stockServiceUrl;

    public List<StockInfo> getStockInfo(List<Product> products) {
        throw new NotImplementedException();
    }
}
