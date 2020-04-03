package org.thibaut.thelibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {

		SpringApplication.run( BookApplication.class, args );

	}

}
