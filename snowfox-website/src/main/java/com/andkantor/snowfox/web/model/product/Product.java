package com.andkantor.snowfox.web.model.product;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.andkantor.snowfox.web.model.base.Price;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SnowFoxStyle
@Value.Immutable
@JsonSerialize(as = ImmutableProduct.class)
@JsonDeserialize(as = ImmutableProduct.class)
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
