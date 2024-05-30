package com.pvrmweb.course.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT("WAITING_PAYMENT"),
	SHIPPED("SHIPPED"),
	PAID("PAID"),
	DELIVERED("DELIVERED"),
	CANCELED("CANCELED");
	
	private final String value;
	
	OrderStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
