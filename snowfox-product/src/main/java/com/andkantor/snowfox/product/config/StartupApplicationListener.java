package com.andkantor.snowfox.product.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.andkantor.snowfox.product.model.Currency;
import com.andkantor.snowfox.product.model.Price;
import com.andkantor.snowfox.product.model.Product;
import com.andkantor.snowfox.product.repository.ProductRepository;

@Component
public class StartupApplicationListener {

    @Autowired
    ProductRepository productRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Arrays.asList(
                product("Apple", 20),
                product("Banana", 25),
                product("Cherry", 10),
                product("Grape", 30),
                product("Kiwi", 20),
                product("Mango", 18),
                product("Orange", 22)
        ).forEach(productRepository::save);
    }

    private Product product(String name, double priceAmount) {
        Product product = new Product();

        Price price = new Price();
        price.setAmount(priceAmount);
        price.setCurrency(Currency.EUR);

        product.setName(name);
        product.setDescription("Lorem ipsum dolor sit amet...");
        product.setPrice(price);

        return product;
    }
}
