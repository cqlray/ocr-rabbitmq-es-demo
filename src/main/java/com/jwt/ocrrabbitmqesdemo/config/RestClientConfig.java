package com.jwt.ocrrabbitmqesdemo.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * The base class AbstractElasticsearchConfiguration already provides the elasticsearchTemplate bean.
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Value("${es.cluster-nodes}")
    private String clusterNodes;
    @Value("${es.username:}")
    private String username;
    @Value("${es.password:}")
    private String password;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(clusterNodes.split(","))
//                .withConnectTimeout(Duration.ofSeconds(5))
//                .withSocketTimeout(Duration.ofSeconds(3))
//                .withBasicAuth(username, password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}