package com.andkantor.snowfox.web.service;

import static com.andkantor.snowfox.web.model.stock.Warehouse.warehouse;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.andkantor.snowfox.web.model.base.Product;
import com.andkantor.snowfox.web.model.stock.StockInfoList;
import com.andkantor.snowfox.web.model.stock.Warehouse;

@Component
public class StockService {

    @Value("${snowfox.stock-service-url}")
    private String stockServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Warehouse getStockInfo(List<Product> products) {
        List<Long> productIds = products.stream()
                .map(Product::id)
                .collect(toList());
        HttpEntity<List> request = new HttpEntity<>(productIds);

        ResponseEntity<StockInfoList> response = restTemplate
                .exchange(stockServiceUrl + "/v1/stock", HttpMethod.POST, request, StockInfoList.class);

        return warehouse(response.getBody());
    }
}
