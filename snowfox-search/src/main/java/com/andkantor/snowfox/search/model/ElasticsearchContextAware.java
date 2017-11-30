package com.andkantor.snowfox.search.model;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ElasticsearchContextAware {

    @Value("${snowfox.elasticsearch.index}")
    protected String indexName;

    @Value("${snowfox.elasticsearch.type}")
    protected String typeName;

    @Autowired
    protected TransportClient client;

}
