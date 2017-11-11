package com.andkantor.snowfox.stock.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StockChangeMarshallingTest extends AbstractJackson2MarshallingTest {

    @Test
    public void testMarshalling() throws Exception {
        StockChange expected = StockChange.builder()
                .operation(Operation.INCREMENT)
                .quantity(12L)
                .build();

        String json = write(expected);
        StockChange actual = read(json, StockChange.class);

        assertThat(actual).isEqualTo(expected);
    }

}