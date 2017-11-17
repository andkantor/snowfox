package com.andkantor.snowfox.web.model.cart;

import static com.andkantor.snowfox.web.model.base.Price.price;
import static com.andkantor.snowfox.web.model.cart.CalculatedCartItem.calculatedCartItem;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.andkantor.snowfox.web.model.base.Currency;
import com.andkantor.snowfox.web.model.base.Price;
import com.andkantor.snowfox.web.model.base.Product;
import com.andkantor.snowfox.web.service.Cart;

@SnowFoxStyle
@Value.Immutable
public interface CalculatedCart {

    List<CalculatedCartItem> items();

    @Value.Derived
    default Price subTotal() {
        Optional<Price> subTotal = items().stream()
                .map(CalculatedCartItem::price)
                .reduce(Price::add);
        return subTotal.orElse(price(0.0, Currency.EUR));
    }

    static CalculatedCart calculatedCart(Cart cart, List<Product> products) {
        return builder()
                .items(products.stream()
                        // TODO remove when product service is implemented properly
                        .filter(product -> cart.getQuantity(product.id()) != null)
                        .map(product -> calculatedCartItem(product, cart.getQuantity(product.id())))
                        .collect(Collectors.toList()))
                .build();
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableCalculatedCart.Builder {
    }
}
