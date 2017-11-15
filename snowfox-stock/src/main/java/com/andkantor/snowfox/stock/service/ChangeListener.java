package com.andkantor.snowfox.stock.service;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.andkantor.snowfox.stock.model.StockChangeMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ChangeListener {

    @Autowired
    private StockCache stockCache;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${snowfox.stock.topic}")
    public void receive(ConsumerRecord<?, String> consumerRecord) {
        try {
            String json = consumerRecord.value();
            StockChangeMessage message = objectMapper.readValue(json, StockChangeMessage.class);
            stockCache.update(message.productId(), message.currentQuantity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
