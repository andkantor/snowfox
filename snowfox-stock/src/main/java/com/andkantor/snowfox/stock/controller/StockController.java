package com.andkantor.snowfox.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andkantor.snowfox.stock.model.QuantityChange;
import com.andkantor.snowfox.stock.model.QuantityChangeResponse;
import com.andkantor.snowfox.stock.repository.StockRepository;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(@RequestParam int productId) {
        return "Quantity: " + stockRepository.get(productId);
    }

    @RequestMapping(value = "/increment", method = RequestMethod.POST)
    public ResponseEntity<QuantityChangeResponse> increment(@RequestBody QuantityChange quantityChange) {
        stockRepository.increment(quantityChange);
        QuantityChangeResponse response = QuantityChangeResponse.successfulResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/decrement", method = RequestMethod.POST)
    public ResponseEntity<QuantityChangeResponse> decrement(@RequestBody QuantityChange quantityChange) {
        QuantityChangeResponse response;
        if (stockRepository.decrement(quantityChange)) {
            response = QuantityChangeResponse.successfulResponse();
        } else {
            response = QuantityChangeResponse.unsuccessfulResponse("Not enough products in stock to fulfill the request");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
