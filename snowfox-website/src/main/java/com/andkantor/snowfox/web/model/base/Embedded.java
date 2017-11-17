package com.andkantor.snowfox.web.model.base;

import java.util.List;

import org.immutables.value.Value;

import com.andkantor.snowfox.style.SnowFoxStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SnowFoxStyle
@Value.Immutable
@JsonSerialize(as = ImmutableEmbedded.class)
@JsonDeserialize(as = ImmutableEmbedded.class)
public interface Embedded<T> {

    List<T> items();

    static <T> Builder<T> builder() {
        return new Builder<>();
    }

    class Builder<T> extends ImmutableEmbedded.Builder<T> {
    }
}
