package com.andkantor.snowfox.stock.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.andkantor.snowfox.stock.model.StockChangeMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ChangePublisher {

    private static final Logger LOGGER = Logger.getLogger(ChangePublisher.class);

    @Value("${snowfox.stock.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    private ObjectMapper objectMapper;

    public void publish(StockChangeMessage message) {
        try {
            String json = objectMapper.writeValueAsString(message);
            template.send(topicName, json);
            LOGGER.info("Message published. ProductId: " + message.productId() + ", Quantity: " + message.currentQuantity());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
