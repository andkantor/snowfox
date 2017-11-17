package com.andkantor.snowfox.stock.service;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.andkantor.snowfox.stock.model.StockChangeMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ChangeListener {

    private static final Logger LOGGER = Logger.getLogger(ChangeListener.class);

    @Autowired
    private StockCache stockCache;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${snowfox.stock.topic}")
    public void receive(ConsumerRecord<?, String> consumerRecord) {
        try {
            String json = consumerRecord.value();
            StockChangeMessage message = objectMapper.readValue(json, StockChangeMessage.class);
            LOGGER.info("Message received. ProductId: " + message.productId() + ", Quantity: " + message.currentQuantity());
            stockCache.update(message.productId(), message.currentQuantity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
