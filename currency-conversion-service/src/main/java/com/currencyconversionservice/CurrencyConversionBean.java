package com.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;

	private String from;
	private String to;

	private BigDecimal quatity;
	private BigDecimal convertionMultiple;
	private BigDecimal calculatedAmount;
	private int port;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public CurrencyConversionBean() {
	}

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal quatity, BigDecimal conversionMultiples,
			BigDecimal calculatedAmount,int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quatity = quatity;
		this.convertionMultiple=conversionMultiples;
		this.calculatedAmount = calculatedAmount;
		this.port=port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getQuatity() {
		return quatity;
	}

	public void setQuatity(BigDecimal quatity) {
		this.quatity = quatity;
	}

	public BigDecimal getConvertionMultiple() {
		return convertionMultiple;
	}

	public void setConvertionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}

	

}
