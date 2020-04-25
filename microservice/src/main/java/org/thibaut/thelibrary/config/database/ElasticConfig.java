package org.thibaut.thelibrary.config.database;

import lombok.Getter;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.HttpHeaders;

import java.time.Duration;

/**
 * Created by suman.das on 6/19/19.
 */
@Configuration
@EnableElasticsearchRepositories
@Getter
public class ElasticConfig extends AbstractElasticsearchConfiguration {

	@Value("${elasticsearch.host:51.178.48.191}")
	public String host;

	@Value("${elasticsearch.port:9300}")
	public int port;

	private final int timeout = 60;

	@Bean
	@Override
	public RestHighLevelClient elasticsearchClient( ) {

//		final CredentialsProvider credentialsProvider =
//				new BasicCredentialsProvider();
//		credentialsProvider.setCredentials(AuthScope.ANY,
//				new UsernamePasswordCredentials("elastic", "DTnRyEle8Z8NnMuq4Era"));
//
//		RestClientBuilder builder = RestClient.builder(
//				new HttpHost("51.178.48.191", 9200))
//				                            .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
//					                            @Override
//					                            public HttpAsyncClientBuilder customizeHttpClient(
//							                            HttpAsyncClientBuilder httpClientBuilder) {
//						                            return httpClientBuilder
//								                                   .setDefaultCredentialsProvider(credentialsProvider);
//					                            }
//				                            });
//		return new RestHighLevelClient(builder);

		HttpHeaders defaultHeaders = new HttpHeaders();
		defaultHeaders.setBasicAuth("elastic", "DTnRyEle8Z8NnMuq4Era");

		ClientConfiguration clientConfiguration = ClientConfiguration.builder()
				                                          .connectedTo("51.178.48.191:9200", "localhost:9300")
				                                          .withConnectTimeout( Duration.ofSeconds(5))
				                                          .withSocketTimeout(Duration.ofSeconds(3))
				                                          .withDefaultHeaders(defaultHeaders)
				                                          .withBasicAuth("elastic", "DTnRyEle8Z8NnMuq4Era")
                                                      .build();

		return RestClients.create(clientConfiguration).rest();
	}

	@Bean
	@Override
	public EntityMapper entityMapper() {
		ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(elasticsearchMappingContext(),
				new DefaultConversionService());
		entityMapper.setConversions(elasticsearchCustomConversions());

		return entityMapper;
	}
}
