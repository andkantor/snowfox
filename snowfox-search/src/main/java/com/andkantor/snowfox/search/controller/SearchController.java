package com.andkantor.snowfox.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andkantor.snowfox.search.model.product.Currency;
import com.andkantor.snowfox.search.model.product.Price;
import com.andkantor.snowfox.search.model.product.Product;
import com.andkantor.snowfox.search.repository.ProductRepository;

@RestController
@RequestMapping("/v1/search")
public class SearchController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> search(String criteria) {
        List<Product> products = repository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> create(@PathVariable Long id) {
        Product product = Product.builder()
                .id(id)
                .name("first product")
                .description("lorem ipsum")
                .price(Price.builder()
                        .amount(1000L)
                        .currency(Currency.EUR)
                        .build())
                .build();

        repository.save(product);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
