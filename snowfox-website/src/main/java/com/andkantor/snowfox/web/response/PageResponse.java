package com.andkantor.snowfox.web.response;

import com.andkantor.snowfox.web.model.base.Embedded;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface PageResponse<T> {

    @JsonProperty("_embedded")
    Embedded<T> embedded();

}
