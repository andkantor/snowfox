package com.andkantor.snowfox.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andkantor.snowfox.stock.exception.NotEnoughQuantitiesException;
import com.andkantor.snowfox.stock.model.StockChange;
import com.andkantor.snowfox.stock.model.StockChangeMessage;
import com.andkantor.snowfox.stock.repository.StockRepository;
import com.andkantor.snowfox.stock.service.ChangePublisher;

@RestController
@RequestMapping("/product/{id}/stock")
public class StockChangeController {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ChangePublisher changePublisher;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
        public String get(@PathVariable Long id) {
        return "Quantity: " + stockRepository.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String post(@PathVariable Long id, @RequestBody StockChange stockChange) throws NotEnoughQuantitiesException {
        long currentQuantity = stockRepository.update(id, stockChange);

        StockChangeMessage message = StockChangeMessage.builder()
                .productId(id)
                .stockChange(stockChange)
                .currentQuantity(currentQuantity)
                .build();

        changePublisher.publish(message);

        return "";
    }

    @ExceptionHandler({NotEnoughQuantitiesException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(Exception exception) {
        return exception.getMessage();
    }

}
