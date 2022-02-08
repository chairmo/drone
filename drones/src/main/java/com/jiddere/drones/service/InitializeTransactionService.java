package com.jiddere.drones.service;

import com.jiddere.drones.paystack.InitializationRequestDto;
import com.jiddere.drones.paystack.InitializeResponseDto;

public interface InitializeTransactionService {
		InitializeResponseDto 
		initializeTransaction (InitializationRequestDto requestDto);
}
