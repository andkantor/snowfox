package com.andkantor.snowfox.web.model.order;

import java.util.List;

import com.andkantor.snowfox.web.model.base.Price;
import com.andkantor.snowfox.web.model.cart.CalculatedCart;
import com.andkantor.snowfox.web.model.cart.CalculatedCartItem;

public class Order {

    private CalculatedCart cart;
    private Price shipping;

    public Order() {
    }

    public Order(CalculatedCart cart, Price shipping) {
        this.cart = cart;
        this.shipping = shipping;
    }

    public List<CalculatedCartItem> getItems() {
        return cart.getItems();
    }

    public Price getSubTotal() {
        return cart.getSubTotal();
    }

    public Price getShipping() {
        return shipping;
    }

    public Price getTotal() {
        return cart.getSubTotal().add(shipping);
    }
}
