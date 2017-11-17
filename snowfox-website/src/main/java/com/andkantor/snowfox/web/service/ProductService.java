package com.andkantor.snowfox.web.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.andkantor.snowfox.web.model.base.Product;
import com.andkantor.snowfox.web.response.ProductPageResponse;

@Component
public class ProductService {

    @Value("${snowfox.product-service-url}")
    private String productServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getProducts() {
        // TODO extract url to configuration
        ProductPageResponse response = restTemplate
                .getForObject(productServiceUrl + "/v1/products", ProductPageResponse.class);

        return response.embedded().items();
    }

    public List<Product> getProducts(Collection<Long> productIds) {
        return getProducts();
    }

    public List<Product> searchProducts(String criteria) {
        return getProducts();
    }
}
