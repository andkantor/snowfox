package com.andkantor.snowfox.web.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface PageResponse<T> {

    @JsonProperty("_embedded")
    Embedded<T> embedded();

}
