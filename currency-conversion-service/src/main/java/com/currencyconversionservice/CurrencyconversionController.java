package com.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class CurrencyconversionController {

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriParams = new HashMap<>();
		uriParams.put("from", from);
		uriParams.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriParams);
		CurrencyConversionBean beanResponse = responseEntity.getBody();
		return new CurrencyConversionBean(beanResponse.getId(), from, to, quantity,
				beanResponse.getConvertionMultiple(),
				beanResponse.getConvertionMultiple().multiply(beanResponse.getConvertionMultiple()),
				beanResponse.getPort());

	}

	@Autowired
	private CurrencyConvertionServiceProxy proxy;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean beanResponse = proxy.getExchangeValues(from, to);

		logger.info("{}"+beanResponse);
		return new CurrencyConversionBean(beanResponse.getId(), from, to, quantity,
				beanResponse.getConvertionMultiple(),
				beanResponse.getConvertionMultiple().multiply(beanResponse.getConvertionMultiple()),
				beanResponse.getPort());

	}
}
