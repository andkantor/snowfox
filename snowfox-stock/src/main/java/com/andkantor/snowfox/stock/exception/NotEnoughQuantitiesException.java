package com.andkantor.snowfox.stock.exception;

public class NotEnoughQuantitiesException extends Exception {

    public NotEnoughQuantitiesException() {
        super("Not enough products in stock to fulfill the request");
    }
}
