package com.andkantor.snowfox.web.response;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.andkantor.snowfox.web.model.base.Product;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SnowFoxStyle
@Value.Immutable
@JsonSerialize(as = ImmutableProductPageResponse.class)
@JsonDeserialize(as = ImmutableProductPageResponse.class)
public interface ProductPageResponse extends PageResponse<Product> {

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ImmutableProductPageResponse.Builder {
    }
}
