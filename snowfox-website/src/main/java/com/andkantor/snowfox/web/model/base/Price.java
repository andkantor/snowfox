package com.andkantor.snowfox.web.model.base;

import com.andkantor.snowfox.web.model.product.Currency;

public class Price {

    private double amount;
    private Currency currency;

    public Price() {
    }

    public Price(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
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

    public Price add(Price other) {
        if (!other.currency.equals(currency)) {
            throw new IllegalArgumentException("Cannot add prices with different currency");
        }
        return new Price(amount + other.amount, currency);
    }

    public Price multiply(double number) {
        return new Price(amount * number, currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
