package com.andkantor.snowfox.web.model.cart;

import static com.andkantor.snowfox.web.model.base.Price.price;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.andkantor.snowfox.web.model.base.Currency;
import com.andkantor.snowfox.web.model.base.Price;
import com.andkantor.snowfox.web.model.base.Product;

public class CalculatedCart {

    private List<CalculatedCartItem> items;

    public CalculatedCart(Cart cart, List<Product> products) {
        this.items = products.stream()
                // TODO remove when product service is implemented properly
                .filter(product -> cart.getQuantity(product.id()) != null)
                .map(product -> new CalculatedCartItem(product, cart.getQuantity(product.id())))
                .collect(Collectors.toList());
    }

    public List<CalculatedCartItem> getItems() {
        return items;
    }

    public Price getSubTotal() {
        Optional<Price> subTotal = items.stream()
                .map(CalculatedCartItem::getPrice)
                .reduce(Price::add);
        return subTotal.orElse(price(0.0, Currency.EUR));
    }
}
