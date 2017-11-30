package com.andkantor.snowfox.search.repository;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andkantor.snowfox.search.model.ElasticsearchContextAware;
import com.andkantor.snowfox.search.model.product.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProductRepository extends ElasticsearchContextAware {

    @Autowired
    private ObjectMapper objectMapper;

    public void save(Product product) {
        try {
            String source = objectMapper.writeValueAsString(product);

            client.prepareIndex(indexName, typeName, product.id().toString())
                    .setSource(source, XContentType.JSON)
                    .execute().actionGet();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findAll() {
        SearchResponse searchResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
//                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//                .setQuery(QueryBuilders.termQuery("multi", "test"))
//                .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))
//                .setFrom(0).setSize(60).setExplain(true)
                .get();

        return Stream.of(searchResponse.getHits().getHits())
                .map(SearchHit::getSourceAsString)
                .map(this::readValue)
                .collect(toList());
    }

    private Product readValue(String json) {
        try {
            return objectMapper.readValue(json, Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
