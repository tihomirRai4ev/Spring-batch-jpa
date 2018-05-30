package com.traychev.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * App entry point.
 *
 * @author tihom
 *
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = RestConsumerController.class)
@EnableJpaAuditing
public class SpringRestConsumerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringRestConsumerApplication.class, args);
	}
}