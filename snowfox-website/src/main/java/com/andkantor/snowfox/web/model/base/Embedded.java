package com.andkantor.snowfox.web.model.base;

import java.util.List;

public class Embedded<T> {

    private List<T> items;

    public Embedded() {
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
