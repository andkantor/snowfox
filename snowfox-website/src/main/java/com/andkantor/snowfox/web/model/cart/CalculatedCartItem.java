package com.andkantor.snowfox.web.model.cart;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.andkantor.snowfox.web.model.base.Price;
import com.andkantor.snowfox.web.model.base.Product;

@SnowFoxStyle
@Value.Immutable
public interface CalculatedCartItem {

    Product product();
    Long quantity();

    @Value.Derived
    default Long id() {
        return product().id();
    }

    @Value.Derived
    default String name() {
        return product().name();
    }

    @Value.Derived
    default Price price() {
        return product().price().multiply(quantity());
    }

    static CalculatedCartItem calculatedCartItem(Product product, Long quantity) {
        return builder()
                .product(product)
                .quantity(quantity)
                .build();
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableCalculatedCartItem.Builder {
    }

}
