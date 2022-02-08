package com.jiddere.drones.paystack;

import lombok.Data;

@Data
public class InitializationRequestDto {
	private String amount;
	private String email;
	private String reference;
	private String callbackUrl;
	private Integer invoiceLimit;
	private Channels[] channels;
	private String subaccount;
	private Integer transactionCharge;

	private PaystackBearer paystackBearer;
}
