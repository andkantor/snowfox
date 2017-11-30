package com.andkantor.snowfox.search.model.product;

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

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutablePrice.Builder {
    }
}
