package org.thibaut.thelibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.annotation.PostConstruct;

@EnableDiscoveryClient
@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {

		SpringApplication.run( CatalogApplication.class, args );

	}

}
