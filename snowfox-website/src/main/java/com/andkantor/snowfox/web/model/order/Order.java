package com.andkantor.snowfox.web.model.order;

import java.util.List;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.andkantor.snowfox.web.model.base.Price;
import com.andkantor.snowfox.web.model.cart.CalculatedCart;
import com.andkantor.snowfox.web.model.cart.CalculatedCartItem;

@SnowFoxStyle
@Value.Immutable
public interface Order {

    CalculatedCart cart();
    Price shipping();

    @Value.Derived
    default List<CalculatedCartItem> items() {
        return cart().items();
    }

    @Value.Derived
    default Price subTotal() {
        return cart().subTotal();
    }

    @Value.Derived
    default Price total() {
        return cart().subTotal().add(shipping());
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableOrder.Builder {
    }
}
