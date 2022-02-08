package com.jiddere.drones.paystack;


@lombok.Data
public class InitializeResponseDto {
	private String status;
	private String message;
	private Data data;
}
