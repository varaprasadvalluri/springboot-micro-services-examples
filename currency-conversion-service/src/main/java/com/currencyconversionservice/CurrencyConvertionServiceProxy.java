package com.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient("currency-exchange-service")
public interface CurrencyConvertionServiceProxy {

	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public  CurrencyConversionBean getExchangeValues(@PathVariable String from, @PathVariable String to) ;
}
