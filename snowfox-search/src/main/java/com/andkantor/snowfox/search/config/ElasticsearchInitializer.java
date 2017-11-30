package com.andkantor.snowfox.search.config;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.elasticsearch.common.xcontent.XContentType.JSON;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.andkantor.snowfox.search.model.ElasticsearchContextAware;

@Component
public class ElasticsearchInitializer extends ElasticsearchContextAware implements ApplicationListener<ContextRefreshedEvent> {

    @Value("classpath:mappings.json")
    private Resource mappingsJson;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        IndicesExistsResponse existsResponse = client.admin().indices().prepareExists(indexName).execute().actionGet();
        if (!existsResponse.isExists()) {
            client.admin().indices().prepareCreate(indexName)
                    .setSettings(Settings.builder()
                            // TODO from configuration
                            .put("index.number_of_shards", 1)
                            .put("index.number_of_replicas", 0))
                    .addMapping(typeName, mapping(), JSON)
                    .execute()
                    .actionGet();
            // TODO logging
        }
    }

    private String mapping() {
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(mappingsJson.getInputStream(), writer, UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }
}
