package com.andkantor.snowfox.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.andkantor.snowfox.stock.model.StockChangeMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ChangePublisher {

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
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
