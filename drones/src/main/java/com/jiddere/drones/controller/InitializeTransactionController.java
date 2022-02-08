package com.jiddere.drones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiddere.drones.paystack.InitializationRequestDto;
import com.jiddere.drones.paystack.InitializeResponseDto;
import com.jiddere.drones.service.InitializeTransactionService;

@RestController
@RequestMapping(value = "/payment", produces = "application/json")
public class InitializeTransactionController {
	
	private InitializeTransactionService service;

	public void setService(InitializeTransactionService service) {
		this.service = service;
	}
	
	@PostMapping("/initTransaction")
	public ResponseEntity<InitializeResponseDto> initializeTransaction(@RequestBody
			InitializationRequestDto requestDto){
		InitializeResponseDto responseDto = service.initializeTransaction(requestDto);
		return new ResponseEntity<InitializeResponseDto>(responseDto, HttpStatus.OK);
	}

}
