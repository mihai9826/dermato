package com.mihaimadan.dermato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DermatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DermatoApplication.class, args);
	}

}
