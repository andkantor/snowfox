package com.andkantor.snowfox.search.config;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "docker-cluster")
                .put("xpack.security.user", "elastic:changeme")
                .build();

        return new PreBuiltXPackTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("elastic", 9300)))
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("elastic", 9301)));
    }

}
