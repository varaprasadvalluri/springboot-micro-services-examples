package com.namingserver.netflixerukanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetflixErukaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixErukaNamingServerApplication.class, args);
	}

}
