package com.andkantor.snowfox.stock.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.andkantor.snowfox.stock.model.QuantityChange;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore("enable for e2e testing")
public class DefaultStockRepositoryTest {

    @Autowired
    DefaultStockRepository stockRepository;

    @Test
    public void test() {
        stockRepository.increment(new QuantityChange(1, 2));
        stockRepository.decrement(new QuantityChange(1, -10));
        System.out.println(stockRepository.get(1));
    }

}
