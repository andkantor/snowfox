package com.andkantor.snowfox.web.service;

import org.springframework.stereotype.Component;

import com.andkantor.snowfox.web.model.order.Order;
import com.andkantor.snowfox.web.response.OrderSubmissionResponse;

@Component
public class OrderService {

//    @Autowired
//    private RestTemplate restTemplate;

    public OrderSubmissionResponse submitOrder(Order order) {
        OrderSubmissionResponse response = new OrderSubmissionResponse();
        response.setSuccess(true);
        return response;
//        return restTemplate.postForObject("http://order-service/v1/", order, OrderSubmissionResponse.class);
    }
}
