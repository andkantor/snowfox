package com.andkantor.snowfox.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andkantor.snowfox.stock.model.StockChange;
import com.andkantor.snowfox.stock.model.StockChangeResponse;
import com.andkantor.snowfox.stock.repository.StockRepository;

@RestController
@RequestMapping("/product/{id}/stock")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable Long id) {
        return "Quantity: " + stockRepository.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<StockChangeResponse> post(@PathVariable Long id, @RequestBody StockChange stockChange) {
        StockChangeResponse response;
        if (stockRepository.update(id, stockChange)) {
            response = StockChangeResponse.builder()
                    .success(true)
                    .errorMessage("")
                    .build();
        } else {
            response = StockChangeResponse.builder()
                    .success(false)
                    .errorMessage("Not enough products in stock to fulfill the request")
                    .build();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
