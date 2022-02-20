package com.microservice.sample.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.sample.limitsservice.beans.LimitConfig;


@RefreshScope
@RestController
public class LimitConfigController {
	
	@Autowired
	private Configuration confg;
	
	@GetMapping("/limits")
	public LimitConfig getLimitConfiguration() {
		return new LimitConfig(confg.getMinimum(), confg.getMaximum());
	}

}
