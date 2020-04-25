package org.thibaut.thelibrary;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetSocketAddress;

@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@EnableElasticsearchRepositories
public class BookApplication {

	public static void main(String[] args) {

		SpringApplication.run( BookApplication.class, args );

	}

}
