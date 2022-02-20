package com.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.currencyexchangeservice.beans.ExchangeValues;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private ExchangeRepository exchRepo;
	@Autowired
	private Environment env;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@HystrixCommand(fallbackMethod = "fallbackSampleData")
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
//	@RequestMapping(method = RequestMethod.GET, value = "/currency-exchange/from/{from}/to/{to}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ExchangeValues> getExchangeValues(@PathVariable String from,
			@PathVariable String to) {
		//ExchangeValues excha = exchRepo.findByFromAndTo(from, to);
		//logger.info("{} -->" + excha);
		// excha.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		// return new ResponseEntity<ExchangeValues>(excha, HttpStatus.OK);
		new RuntimeException();
		return null;
	}

	public ResponseEntity<ExchangeValues> fallbackSampleData(@PathVariable String from, @PathVariable String to) {
		ExchangeValues excha = new ExchangeValues(1l, "SR", "INR", BigDecimal.ONE, 0);
		logger.info("{} -->" + excha);
		excha.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return ResponseEntity.ok(excha);

	}
}
