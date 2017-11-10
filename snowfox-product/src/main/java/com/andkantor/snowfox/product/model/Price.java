package com.andkantor.snowfox.product.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price {

    @Column(precision = 10, scale = 4, name = "price_amount")
    private double amount;

    @Column(name = "price_currency")
    private Currency currency;

    public Price() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
