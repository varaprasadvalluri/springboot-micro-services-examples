package com.microservice.cloudconfig.cloudconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
@EnableConfigServer
@RefreshScope
@SpringBootApplication
public class CloudconfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudconfigServiceApplication.class, args);
	}

}
