package com.andkantor.snowfox.stock.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class StockChangeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturn200WhenSendingRequestToController() throws Exception {
//        @SuppressWarnings("rawtypes")
//        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
//                "http://localhost:" + this.port + "/hello-world", Map.class);
//
//        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}