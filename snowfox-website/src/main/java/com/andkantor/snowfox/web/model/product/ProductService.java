package com.andkantor.snowfox.web.model.product;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getProducts() {
        // TODO extract url to configuration
        ProductPageResponse response = restTemplate
                .getForObject("http://product-service:5001/v1/products", ProductPageResponse.class);

        return response.getEmbedded().getItems();
    }

    public List<Product> getProducts(Collection<Long> productIds) {
        return getProducts();
    }

    public List<Product> searchProducts(String criteria) {
        return getProducts();
    }
}
