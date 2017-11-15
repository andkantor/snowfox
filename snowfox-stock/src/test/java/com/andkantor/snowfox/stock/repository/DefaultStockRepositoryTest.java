package com.andkantor.snowfox.stock.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.andkantor.snowfox.stock.exception.NotEnoughQuantitiesException;
import com.andkantor.snowfox.stock.model.Operation;
import com.andkantor.snowfox.stock.model.StockChange;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore("enable for e2e testing")
public class DefaultStockRepositoryTest {

    @Autowired
    DefaultStockRepository stockRepository;

    @Test
    public void test() throws NotEnoughQuantitiesException {
        StockChange increment = StockChange.builder()
                .operation(Operation.INCREMENT)
                .quantity(12L)
                .build();
        StockChange decrement = StockChange.builder()
                .operation(Operation.DECREMENT)
                .quantity(10L)
                .build();

        stockRepository.update(1L, increment);
        stockRepository.update(1L, decrement);

        System.out.println(stockRepository.get(1));
    }

    // TODO add unit tests
}
