package com.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currencyexchangeservice.beans.ExchangeValues;

public interface ExchangeRepository extends JpaRepository<ExchangeValues, Long>{

	
	public ExchangeValues findByFromAndTo(String from,String to);
}
