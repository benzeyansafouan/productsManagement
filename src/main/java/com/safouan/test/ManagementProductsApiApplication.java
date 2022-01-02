package com.safouan.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;





@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan(basePackages = {"com.safouan.test"})
@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.safouan.test"})
public class ManagementProductsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementProductsApiApplication.class, args);
	}

}
