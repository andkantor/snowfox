package com.andkantor.snowfox.web.model.base;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SnowFoxStyle
@Value.Immutable
@JsonSerialize(as = ImmutablePrice.class)
@JsonDeserialize(as = ImmutablePrice.class)
public interface Price {

    double amount();
    Currency currency();

    @Value.Derived
    default String format() {
        return amount() + " " + currency();
    }

    default Price add(Price other) {
        if (!other.currency().equals(currency())) {
            throw new IllegalArgumentException("Cannot add prices with different currency");
        }
        return price(amount() + other.amount(), currency());
    }

    default Price multiply(double number) {
        return price(amount() * number, currency());
    }

    static Price price(double amount, Currency currency) {
        return builder()
                .amount(amount)
                .currency(currency)
                .build();
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutablePrice.Builder {
    }
}
