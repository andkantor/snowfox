package com.andkantor.snowfox.web.model.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResponse<T> {

    @JsonProperty(value = "_embedded")
    private Embedded<T> embedded;

    public PageResponse() {
    }

    public Embedded<T> getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded<T> embedded) {
        this.embedded = embedded;
    }
}
