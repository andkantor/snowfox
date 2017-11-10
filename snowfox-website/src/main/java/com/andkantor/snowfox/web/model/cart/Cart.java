package com.andkantor.snowfox.web.model.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Cart {

    private Map<Long, Long> productQuantities = new HashMap<>();

    public Cart() {
    }

    public Collection<Long> getProductIds() {
        return productQuantities.keySet();
    }

    public Long getQuantity(Long productId) {
        return productQuantities.get(productId);
    }

    public void addProduct(Long productId, Long quantity) {
        if (productQuantities.containsKey(productId)) {
            productQuantities.put(productId, productQuantities.get(productId) + quantity);
        } else {
            productQuantities.put(productId, quantity);
        }
    }

    public void removeProduct(Long productId) {
        productQuantities.remove(productId);
    }
}
