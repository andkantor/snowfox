package com.andkantor.snowfox.web.model.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderService {

    private RestTemplate restTemplate;

    @Autowired
    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OrderSubmissionResponse submitOrder(Order order) {
        OrderSubmissionResponse response = new OrderSubmissionResponse();
        response.setSuccess(true);
        return response;
//        return restTemplate.postForObject("http://order-service/v1/", order, OrderSubmissionResponse.class);
    }
}
