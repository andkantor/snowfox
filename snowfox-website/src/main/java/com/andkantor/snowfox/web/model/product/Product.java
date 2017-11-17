package com.andkantor.snowfox.web.model.product;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.andkantor.snowfox.web.model.base.Price;

@SnowFoxStyle
@Value.Immutable
public interface Product {

    Long id();
    String name();
    String description();
    Price price();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableProduct.Builder {
    }
}
