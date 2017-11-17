package com.andkantor.snowfox.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andkantor.snowfox.stock.model.StockInfo;
import com.andkantor.snowfox.stock.service.StockCache;

@RestController
@RequestMapping("/v1/stock")
public class StockController {

    @Autowired
    private StockCache stockCache;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<List<StockInfo>> getStockInfo(@RequestBody List<Long> productIds) {
        return new ResponseEntity<>(stockCache.get(productIds), HttpStatus.OK);
    }
}
